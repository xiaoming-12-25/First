package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.TaxSourceDao;
import com.zhidisoft.manage.entity.TaxSource;
import com.zhidisoft.system.entity.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addTaskServlet.do")
public class TaxSourceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 * 添加新任务
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int payerId = Integer.parseInt(req.getParameter("payerId"));
        String taskName = req.getParameter("taskName");
        int subOrganId = Integer.parseInt(req.getParameter("subOrganId"));
        int approverId = Integer.parseInt(req.getParameter("approverId"));
        int executeId = Integer.parseInt(req.getParameter("executeId"));
        String executeTime = req.getParameter("executeTime");
        String taskState = req.getParameter("taskState");
        User user =(User) req.getSession().getAttribute("user");
        int ecordUserId = user.getId();
        TaxSource taxSource = new TaxSource(payerId,taskName,subOrganId,approverId,executeId,executeTime,taskState,ecordUserId);
        TaxSourceDao taxSourceDao=new TaxSourceDao();
        PrintWriter out = resp.getWriter();
        JSONObject json=new JSONObject();
        int source = taxSourceDao.AddTaxSource(taxSource, "tb_tax_source");
        if (source==1){
            json.put("msg","添加成功");
        }else {
            json.put("msg","添加失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
