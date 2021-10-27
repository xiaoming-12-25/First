package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
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
@WebServlet(urlPatterns = "/tapayer.do")
public class TaxpayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 分页查询纳税人信息
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int page = Integer.parseInt(req.getParameter("page"));
        int rows = Integer.parseInt(req.getParameter("rows"));
        String payerCode = req.getParameter("payerCode")==null?"":req.getParameter("payerCode");
        String payerName = req.getParameter("payerName")==null?"":req.getParameter("payerName");
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        List<TaxPayer1> chaxun = taxyer1Dao.SelectTaxPayer1Dim(page, rows,payerName,payerCode);
        int selectint = taxyer1Dao.count(payerName,payerCode);
        JSONObject json=new JSONObject();
        json.put("rows",chaxun);
        json.put("total",selectint);
        PrintWriter out = resp.getWriter();
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
