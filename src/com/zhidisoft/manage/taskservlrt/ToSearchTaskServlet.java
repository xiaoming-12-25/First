package com.zhidisoft.manage.taskservlrt;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.TaxOrgan;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/toSearchTaskServlet.do")
public class ToSearchTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 任务查询
 * 给模糊查询框赋值
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        List<TaxOrgan> taxOrgans = taxyer1Dao.SelctTaxOrganAll();
        List<Industry> industryList = taxyer1Dao.SelectIndustryName();
        req.setAttribute("organs",taxOrgans);
        req.setAttribute("industrys",industryList);
        req.getRequestDispatcher("/manage/jsp/searchTask.jsp").forward(req,resp);

    }
}
