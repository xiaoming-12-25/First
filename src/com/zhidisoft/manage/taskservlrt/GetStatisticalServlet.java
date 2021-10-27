package com.zhidisoft.manage.taskservlrt;

import com.zhidisoft.manage.dao.TaxSourceDao;
import com.zhidisoft.manage.entity.TaxPayer1;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getStatisticalServlet.do")
public class GetStatisticalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        TaxSourceDao taxSourceDao=new TaxSourceDao();
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("rows"));
        List<TaxPayer1> list = taxSourceDao.noSurvey(page, size, payerCode, payerName);
        JSONObject json=new JSONObject();
        int count = taxSourceDao.noCount(payerCode, payerName);
        json.put("rows",list);
        json.put("total",count);
        PrintWriter out = resp.getWriter();
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
