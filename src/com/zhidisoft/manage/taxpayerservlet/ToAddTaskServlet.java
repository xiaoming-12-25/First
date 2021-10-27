package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.TaxOrgan;
import com.zhidisoft.manage.entity.TaxPayer1;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/toAddTaskServlet.do")
public class ToAddTaskServlet extends HttpServlet {
    /**
     *
     * 新建任务页面 失去焦点获取纳税人信息
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        String payerCode = req.getParameter("payerCode");
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        UserDao userDao=new UserDao();
        TaxPayer1 taxPayer = taxyer1Dao.SelectTaxyerBianhao(payerCode);
        req.setAttribute("payer",taxPayer);
        List<TaxOrgan> taxOrgans = taxyer1Dao.SelctTaxOrganAll();
        req.setAttribute("organs",taxOrgans);
        List<TaxUser> taxUsers=userDao.SelecrTaxUserAll();
        req.setAttribute("taxers",taxUsers);
        req.getRequestDispatcher("/manage/jsp/addTask.jsp").forward(req,resp);
    }
}
