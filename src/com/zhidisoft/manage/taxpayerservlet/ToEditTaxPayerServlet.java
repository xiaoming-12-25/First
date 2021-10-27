package com.zhidisoft.manage.taxpayerservlet;

import com.zhidisoft.manage.dao.Taxyer1Dao;
import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.TaxOrgan;
import com.zhidisoft.manage.entity.TaxPayer;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/toEditTaxPayerServlet.do")
public class ToEditTaxPayerServlet extends HttpServlet {
    /**
     *
     * 接受需要更改信息的纳税人
     * 将接收到的数据返回到修改页面
     *
     * */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        TaxPayer taxPayer=taxyer1Dao.SelectTaxPayer(id);
        req.setAttribute("payer",taxPayer);
        List<TaxOrgan> taxOrgans =taxyer1Dao.SelctTaxOrganAll();
        req.setAttribute("organs",taxOrgans);
        List<Industry> industryList=taxyer1Dao.SelectIndustryName();
        req.setAttribute("industrys",industryList);
        req.getRequestDispatcher("/manage/jsp/editTaxPayer.jsp").forward(req,resp);
    }
/**
 *
 * 接受修改后的数据
 * 更新纳税人信息
 *
 * */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json; charset=UTF-8");
        Taxyer1Dao taxyer1Dao=new Taxyer1Dao();
        PrintWriter out = resp.getWriter();
        JSONObject json=new JSONObject();
        int id = Integer.parseInt(req.getParameter("id"));
        TaxPayer taxPayer=taxyer1Dao.SelectTaxPayer(id);
        String payerCode = req.getParameter("payerCode")==null?taxPayer.getPayerCode():req.getParameter("payerCode");
        String payerName = req.getParameter("payerName")==null?taxPayer.getPayerName():req.getParameter("payerName");
        String bizAddress = req.getParameter("bizAddress")==null?taxPayer.getBizAddress():req.getParameter("bizAddress");
        String bizAddressPhone = req.getParameter("bizAddressPhone")==null?taxPayer.getBizAddressPhone():req.getParameter("bizAddressPhone");
        int taxOrganId = req.getParameter("taxOrganId")==null?taxPayer.getTaxOrganId():Integer.parseInt(req.getParameter("taxOrganId"));
        int industryId = req.getParameter("industryId")==null?taxPayer.getIndustryId():Integer.parseInt(req.getParameter("industryId"));
        String bizScope = req.getParameter("bizScope")==null?taxPayer.getBizScope():req.getParameter("bizScope");
        String invoiceType = req.getParameter("invoiceType")==null?taxPayer.getInvoiceType():req.getParameter("invoiceType");
        String legalPerson = req.getParameter("legalPerson")==null?taxPayer.getLegalPerson():req.getParameter("legalPerson");
        String legalIdCard = req.getParameter("legalIdCard")==null?taxPayer.getLegalIdCard():req.getParameter("legalIdCard");
        String finaceName = req.getParameter("finaceName")==null?taxPayer.getFinaceName():req.getParameter("finaceName");
        String finaceIdCard = req.getParameter("finaceIdCard")==null?taxPayer.getFinaceIdCard():req.getParameter("finaceIdCard");
        int i = taxyer1Dao.UpdateTaxyer(payerCode, payerName, bizAddress, bizAddressPhone, taxOrganId, industryId,
                bizScope, invoiceType, legalPerson, legalIdCard, finaceName, finaceIdCard, id);
        if (i==1){
            json.put("success",true);
            json.put("msg","更新成功");
        }else {
            json.put("success",false);
            json.put("msg","更新失败");
        }
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
