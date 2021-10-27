package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.TaxOrgan;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/toAddTaxerServlet.do")
public class ToAddTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    /**
     *
     * 添加办税人前获得的一些数据
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        List<TaxOrgan> taxOrgans = taxyer1Dao.SelctTaxOrganAll();
        req.setAttribute("organs",taxOrgans);
        req.getRequestDispatcher("/manage/jsp/addTaxer.jsp").forward(req,resp);
    }
}
