package com.zhidisoft.system.userservlet;

import com.zhidisoft.system.dao.UserDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/updatePassword.do")
public class UpdatePasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 修改密码
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int eid = Integer.parseInt(req.getParameter("eid"));
        String newPassword = req.getParameter("newPassword");
        UserDao userDao=new UserDao();
        PrintWriter out = resp.getWriter();
        JSONObject json =new JSONObject();
        int i = userDao.UpdatePassword(eid, newPassword);
        if (i==1) {
            json.put("success", true);
            json.put("msg", "修改成功");
        } else {
            json.put("success", false);
            json.put("msg", "修改失败，密码输入错误");
        }
        out.print(json.toString());
        out.flush();
        out.close();
    }
}
