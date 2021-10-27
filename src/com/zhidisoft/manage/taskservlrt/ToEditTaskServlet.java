package com.zhidisoft.manage.taskservlrt;

import com.zhidisoft.manage.dao.TaxSourceDao;
import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.TaxOrgan;
import com.zhidisoft.manage.entity.TaxPayer1;
import com.zhidisoft.manage.entity.TaxSource;
import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;
import com.zhidisoft.system.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/toEditTaskServlet.do")
public class ToEditTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    /**
     *
     * 更改任务前
     * 获取需要更改的信息
     *
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        TaxSourceDao taxSourceDao=new TaxSourceDao();
        int id = Integer.parseInt(req.getParameter("id"));
        TaxPayer1 taxPayer1 = taxSourceDao.SelectTaxPayer1(id);
        req.setAttribute("payer",taxPayer1);
        User user =(User) req.getSession().getAttribute("user");
        req.setAttribute("user",user);
        TaxSource taxSource = taxSourceDao.SelectTaxSourceId(id);
        req.setAttribute("task",taxSource);
        UserDao userDao=new UserDao();
        List<TaxUser> taxUsers = userDao.SelecrTaxUserAll();
        req.setAttribute("taxers",taxUsers);
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        List<TaxOrgan> taxOrgans = taxyer1Dao.SelctTaxOrganAll();
        req.setAttribute("organs",taxOrgans);
        req.getRequestDispatcher("/manage/jsp/editTask.jsp").forward(req,resp);
    }
}
