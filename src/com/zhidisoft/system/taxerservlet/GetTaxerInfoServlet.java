package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/getTaxerInfoServlet.do")
public class GetTaxerInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 查看办税人员详情
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao=new UserDao();
        TaxUser taxUser = userDao.SelecrTaxUserorganName(id);
        req.setAttribute("taxer",taxUser);
        req.getRequestDispatcher("/manage/jsp/taxerInfo.jsp").forward(req,resp);
    }
}
