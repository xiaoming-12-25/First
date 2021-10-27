package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.system.dao.UserDao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteTaxerServlet.do")
public class DeleteTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 删除办税专员
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao=new UserDao();
        PrintWriter out = resp.getWriter();
        JSONObject json=new JSONObject();
        int i = userDao.DeleteTaxUser(id);
        if (i==1){
            json.put("success",true);
            json.put("msg","删除成功");
        }else {
            json.put("success",false);
            json.put("msg","删除失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
