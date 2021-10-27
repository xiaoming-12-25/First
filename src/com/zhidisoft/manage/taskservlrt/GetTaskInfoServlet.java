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

@WebServlet(urlPatterns = "/getTaskInfoServlet.do")
public class GetTaskInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        /**
         *
         *查看任务详情
         *
         * */
    }
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
        int subOrganId = taxSource.getSubOrganId();
        int approverId = taxSource.getApproverId();
        int executeId = taxSource.getExecuteId();
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        TaxOrgan taxOrgan = taxyer1Dao.SelctTaxOrganId(subOrganId);
        req.setAttribute("subOrgan",taxOrgan);
        UserDao userDao=new UserDao();
        TaxUser taxUser = userDao.SelecrTaxUserId(approverId);
        req.setAttribute("approverTaxer",taxUser);
        TaxUser taxUser1 = userDao.SelecrTaxUserId(executeId);
        req.setAttribute("executeTaxer",taxUser1);
        req.getRequestDispatcher("/manage/jsp/taskInfo.jsp").forward(req,resp);
    }
}
