package com.zhidisoft.manage.taskservlrt;

import com.zhidisoft.manage.dao.TaxSourceDao;
import com.zhidisoft.manage.entity.TaxSource;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/editTaskServlet.do")
public class EditTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    /**
     *
     * 更改任务信息
     * 执行
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        TaxSourceDao taxSourceDao=new TaxSourceDao();
        TaxSource taxSource = taxSourceDao.SelectTaxSourceId(id);
        String taskName = req.getParameter("taskName")==null?taxSource.getTaskName(): req.getParameter("taskName");
        int subOrganId = Integer.parseInt(req.getParameter("subOrganId")==null? String.valueOf(taxSource.getSubOrganId()) :req.getParameter("subOrganId"));
        int approverId = Integer.parseInt(req.getParameter("approverId")==null? String.valueOf(taxSource.getApproverId()) :req.getParameter("approverId"));
        int executeId = Integer.parseInt(req.getParameter("executeId")==null? String.valueOf(taxSource.getExecuteId()) :req.getParameter("executeId"));
        String executeTime = req.getParameter("executeTime")==null?taxSource.getExecuteTime():req.getParameter("executeTime");
        String taskState = req.getParameter("taskState")==null?taxSource.getTaskState():req.getParameter("taskState");
        int i = taxSourceDao.UpdateTaskId( taskName, subOrganId, approverId, executeId, executeTime, taskState, id);
        PrintWriter out = resp.getWriter();
        JSONObject json=new JSONObject();
        if (i==1){
            json.put("success",true);
            json.put("msg","更改成功");
        }else {
            json.put("success",false);
            json.put("msg","更改失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
