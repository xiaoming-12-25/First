package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.TaxOrgan;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.util.FormatDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet(urlPatterns = "/toAddTaxPayerServlet.do")
public class ToAddTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 *   添加纳税人前
 *   所需要的一些信息
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Date date=new Date();
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        String format = FormatDate.format(date);
        req.setAttribute("curDate",format);
        List<TaxOrgan> taxOrgans =taxyer1Dao.SelctTaxOrganAll();
        req.setAttribute("organs",taxOrgans);
        List<Industry> industryList=taxyer1Dao.SelectIndustryName();
        req.setAttribute("industrys",industryList);
        User user =(User) req.getSession().getAttribute("user");
        req.setAttribute("user",user);
        req.getRequestDispatcher("/manage/jsp/addTaxPayer.jsp").forward(req,resp);
    }
}
