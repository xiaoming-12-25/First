package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;
import com.zhidisoft.system.entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addTaxerServlet.do")
public class AddTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 添加办税人员
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        String taxerCode = req.getParameter("taxerCode");
        String taxerName = req.getParameter("taxerName");
        String mobile = req.getParameter("mobile");
        String address = req.getParameter("address");
        String sex = req.getParameter("sex");
        String birthday = req.getParameter("birthday");
        String email = req.getParameter("email");
        int organId = Integer.parseInt(req.getParameter("organId"));
        UserDao userDao=new UserDao();
        User user =(User) req.getSession().getAttribute("user");
        User use = userDao.SelectUser(user.getUsername());
        TaxUser taxUser=new TaxUser(taxerCode,taxerName,mobile,address,sex,birthday,email,organId,user.getId());

        int tb = userDao.AddTaxUser(taxUser, "tb_taxer");
        JSONObject json=new JSONObject();
        PrintWriter out = resp.getWriter();
        if (tb==1){
            json.put("success",true);
            json.put("msg","添加成功");
        }else {
            json.put("success",false);
            json.put("msg","添加失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
