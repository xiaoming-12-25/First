package com.zhidisoft.system.userservlet;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/ver.do")
public class VerificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 *    图片验证码
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LineCaptcha lc = CaptchaUtil.createLineCaptcha(200, 40, 4, 50);
        String code = lc.getCode();
        req.getSession().setAttribute("code",code);
        ServletOutputStream os = resp.getOutputStream();
        lc.write(os);
        os.flush();
        os.close();
    }
}
