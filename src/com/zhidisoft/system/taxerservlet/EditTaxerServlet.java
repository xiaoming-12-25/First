package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/editTaxerServlet.do")
public class EditTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 更改办税专员信息
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao=new UserDao();
        TaxUser taxUser = userDao.SelecrTaxUserId(id);
        String taxerCode = req.getParameter("taxerCode")==null?taxUser.getTaxerCode():req.getParameter("taxerCode");
        String taxerName = req.getParameter("taxerName")==null?taxUser.getTaxerName():req.getParameter("taxerName");
        String mobile = req.getParameter("mobile")==null?taxUser.getMobile():req.getParameter("mobile");
        String address = req.getParameter("address")==null?taxUser.getAddress():req.getParameter("address");
        String sex = req.getParameter("sex")==null?taxUser.getSex():req.getParameter("sex");
        String birthday = req.getParameter("birthday")==null?taxUser.getBirthday():req.getParameter("birthday");
        String email = req.getParameter("email")==null?taxUser.getEmail():req.getParameter("email");
        int organId = Integer.parseInt(req.getParameter("organId")==null? String.valueOf(taxUser.getOrganId()) :req.getParameter("organId"));
        int i = userDao.UpdateTaxUser(taxerCode, taxerName, mobile, address, sex, birthday, email, organId, id);
        PrintWriter out = resp.getWriter();
        JSONObject json =new JSONObject();
        if (i==1) {
            json.put("success", true);
            json.put("msg", "修改成功");
        } else {
            json.put("success", false);
            json.put("msg", "修改失败");
        }
        out.print(json.toString());
        out.flush();
        out.close();
    }
}
