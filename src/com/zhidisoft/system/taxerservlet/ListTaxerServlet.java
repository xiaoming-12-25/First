package com.zhidisoft.system.taxerservlet;

import com.zhidisoft.system.dao.UserDao;
import com.zhidisoft.system.entity.TaxUser;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/listTaxerServlet.do")
public class ListTaxerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 办税人分页  模糊查询
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("rows"));
        String taxerName = req.getParameter("taxerName")==null?"":req.getParameter("taxerName");
        UserDao userDao=new UserDao();
        List<TaxUser> list = userDao.SelectTaxUesrDim(page, size, taxerName);
        JSONObject json=new JSONObject();
        int count = userDao.SelectTaxUesrSum(taxerName);
        json.put("rows",list);
        json.put("total",count);
        PrintWriter out = resp.getWriter();
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
