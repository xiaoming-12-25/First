package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.TaxPayer;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(urlPatterns = "/addTaxPayerServlet.do")
public class AddTaxPayerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
/**
 *
 *  添加纳税人的信息
 *
 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        String payerCode = req.getParameter("payerCode");
        String payerName = req.getParameter("payerName");
        String bizAddress = req.getParameter("bizAddress");
        String bizAddressPhone = req.getParameter("bizAddressPhone");
        int taxOrganId = Integer.parseInt(req.getParameter("taxOrganId"));
        int industryId = Integer.parseInt(req.getParameter("industryId"));
        String bizScope = req.getParameter("bizScope");
        String billType = req.getParameter("billType");
        String legalPerson = req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard");
        String recordDate = req.getParameter("recordDate");
        System.out.println(recordDate);
        int userId = Integer.parseInt(req.getParameter("userId"));
        TaxPayer taxPayer=new TaxPayer(payerCode,payerName,bizAddress,bizAddressPhone,taxOrganId,industryId,
                bizScope,billType,legalPerson,legalIdCard,finaceName,finaceIdCard,recordDate,userId);
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        int tb = taxyer1Dao.AddTaxyer(taxPayer, "tb_tax_payer");
        JSONObject json=new JSONObject();
        PrintWriter out = resp.getWriter();
        if (tb==1){
            json.put("success",true);
            json.put("msg","添加成功");
        }else {
            json.put("success",false);
            json.put("msg","添加失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
