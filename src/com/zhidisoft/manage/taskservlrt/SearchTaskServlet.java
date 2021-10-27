package com.zhidisoft.manage.taskservlrt;

import com.zhidisoft.manage.dao.TaxSourceDao;
import com.zhidisoft.manage.entity.TaskManager;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

    @WebServlet(urlPatterns = "/searchTaskServlet.do")
public class SearchTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 查询任务    分页查询
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        String payerCode = req.getParameter("payerCode")==null?"":req.getParameter("payerCode");
        String payerName = req.getParameter("payerName")==null?"":req.getParameter("payerName");
        int subOrganId = Integer.parseInt(req.getParameter("subOrganId")==null? "-1" :req.getParameter("subOrganId"));
        int industryId= Integer.parseInt(req.getParameter("industryId")==null? "-1" :req.getParameter("industryId"));
        String startDate = req.getParameter("startDate")==null?"":req.getParameter("startDate");
        String endDate = req.getParameter("endDate")==null?"":req.getParameter("endDate");
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        TaxSourceDao taxSourceDao=new TaxSourceDao();
        List<TaskManager> list = taxSourceDao.SelectTask(page, rows, payerCode, payerName, subOrganId, industryId, startDate, endDate);
        int count = taxSourceDao.count(payerCode, payerName, subOrganId, industryId, startDate, endDate);
        JSONObject json=new JSONObject();
        json.put("rows",list);
        json.put("total",count);
        PrintWriter out = resp.getWriter();
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
