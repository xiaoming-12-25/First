package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/deleteTaxPayerServlet.do")
public class DeleteTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 删除纳税人信息
 * 更改特定值
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        PrintWriter out = resp.getWriter();
        JSONObject json=new JSONObject();
        int i = taxyer1Dao.DeleteTaxyer(id);
        if (i==1){
            json.put("success",true);
            json.put("msg","删除成功");
        }else {
            json.put("success",false);
            json.put("msg","删除失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
