package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.TaxOrgan;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/toEditTaxerServlet.do")
public class ToEditTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 更改办税专员信息前需要获得的信息
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        UserDao userDao=new UserDao();
        TaxUser taxUser = userDao.SelecrTaxUserId(id);
        req.setAttribute("taxer",taxUser);
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        List<TaxOrgan> taxOrgans = taxyer1Dao.SelctTaxOrganAll();
        req.setAttribute("organs",taxOrgans);
        req.getRequestDispatcher("/manage/jsp/editTaxer.jsp").forward(req,resp);
    }
}
