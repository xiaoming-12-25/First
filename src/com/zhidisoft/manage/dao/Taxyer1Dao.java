package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.Industry;
import com.zhidisoft.manage.entity.TaxOrgan;
import com.zhidisoft.manage.entity.TaxPayer;
import com.zhidisoft.manage.entity.TaxPayer1;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Taxyer1Dao {
    /**
     *
     *  分页  模糊查询 纳税人
     * @<code>SelectTaxPayer1Dim</code>
     *
     */
    public List<TaxPayer1> SelectTaxPayer1Dim(int page ,int sise,String payerName,String payerCode){
        List<TaxPayer1> list=new ArrayList<>();
        String st="select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id " +
                "where p.removeState=0 and p.payerName like concat('%',?,'%') and p.payerCode like concat('%',?,'%') limit ?,?" ;
        List<Map<String, String>> query = DBUtil.query(st, payerName,payerCode,(page-1)*sise, sise);
        for (Map<String, String> mp :query) {
            TaxPayer1 ttt = new TaxPayer1();
            BeanUtil.mapToBean(ttt,mp);
            list.add(ttt);
        }
        return list;
    }
    /**
     *
     * 查看模糊查询的纳税人数据条数
     * @<code>count</code>
     *
     */
    public int count(String payerName,String payerCode){
        List<TaxPayer1> list=new ArrayList<>();
        String st="select payerName ,payerCode from tb_tax_payer where removeState=0 and payerName like concat('%',?,'%') and payerCode like concat('%',?,'%') " ;
        List<Map<String, String>> query = DBUtil.query(st, payerName, payerCode);
        int size = query.size();
        return size;
    }
    /**
     *
     * 纳税人   查看详情
     * @<code>SelectTaxPayer1</code>
     *
     */
    public TaxPayer1 SelectTaxPayer1(int id){
        TaxPayer1 tp = new TaxPayer1();
        String st="select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id where removeState=0 and p.id=? ";
        List<Map<String, String>> query = DBUtil.query(st, id);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(tp,map);
        }
        return tp;
    }
    /**
     *
     * 查看纳税人所需要修改的数据
     * 根据id查询
     * @<code>SelectTaxPayer</code>
     *
     */
    public TaxPayer SelectTaxPayer(int id){
        TaxPayer tp = new TaxPayer();
        String st="select * from tb_tax_payer where removeState=0 and id=? ";
        List<Map<String, String>> query = DBUtil.query(st, id);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(tp,map);
        }
        return tp;
    }
    /**
     *
     * 添加纳税人信息
     * @<code>AddTaxyer</code>
     *
     */
    public int AddTaxyer(TaxPayer taxPayer,String table){
        int tb = DBUtil.add(taxPayer,table);
        return tb;
    }
    /**
     *
     * 删除纳税人信息
     * ==修改特定的标签
     * @<code>DeleteTaxyer</code>
     *
     */
    public int DeleteTaxyer(int id){
        String st="update tb_tax_payer set removeState=1 where id=?";
        int update = DBUtil.update(st, id);
        return update;
    }
    /**
     *
     * 更改纳税人的信息
     * @<code>UpdateTaxyer</code>
     *
     */
    public int  UpdateTaxyer(String payerCode, String payerName, String bizAddress,String bizAddressPhone,
                             int taxOrganId,int industryId,String bizScope,String invoiceType,String legalPerson,
                             String legalIdCard,String finaceName,String finaceIdCard,int id){
        String st="update tb_tax_payer set payerCode=?, payerName=?, bizAddress=? ,bizAddressPhone=? ,taxOrganId=? ,industryId=?, " +
                "bizScope=?, invoiceType=?, legalPerson=?, legalIdCard=?,  finaceName=?, finaceIdCard=?  where  id=? ";
        int update = DBUtil.update(st,payerCode, payerName,bizAddress,bizAddressPhone, taxOrganId,industryId,bizScope,
                invoiceType,legalPerson, legalIdCard,finaceName,finaceIdCard,id);
        return update;
    }
    /**
     *
     * 根据纳税人编号查询
     * @<code>SelectTaxyerBianhao</code>
     *
     */
    public TaxPayer1 SelectTaxyerBianhao(String bianhao){
        TaxPayer1 tp = new TaxPayer1();
        String st="select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id where removeState=0 and p.payerCode=? ";
        List<Map<String, String>> query = DBUtil.query(st, bianhao);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(tp,map);
        }
        return tp;
    }
/**
 *
 * 查询
 * 税务机关表（tb_tax_organ）
 * 的id 和  名称
 * @<code>SelctTaxOrganAll</code>
 *
 */
    public List<TaxOrgan> SelctTaxOrganAll(){
        List<TaxOrgan> list=new ArrayList<>();
        String st="select id,organName from tb_tax_organ";
        List<Map<String, String>> query = DBUtil.query(st);
        for (Map<String, String> map : query) {
            TaxOrgan taxOrgan=new TaxOrgan();
            BeanUtil.mapToBean(taxOrgan,map);
            list.add(taxOrgan);
        }
        return list;
    }
    /**
     *
     * 查询  根据id查询
     * 税务机关表（tb_tax_organ）
     * 的id 和  名称
     * @<code>SelctTaxOrganId</code>
     *
     */
    public TaxOrgan SelctTaxOrganId(int id){
        String st="select id,organName from tb_tax_organ where id=?";
        List<Map<String, String>> query = DBUtil.query(st,id);
        TaxOrgan taxOrgan=new TaxOrgan();
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(taxOrgan,map);
        }
        return taxOrgan;
    }

/**
 *
 * 查询
 * 行业代码表（tb_industry）
 * @<code>SelectIndustryName</code>
 *
 */
    public List<Industry> SelectIndustryName(){
        List<Industry> list=new ArrayList<>();
        String st="select * from tb_industry";
        List<Map<String, String>> query = DBUtil.query(st);
        for (Map<String, String> map : query) {
            Industry industry=new Industry();
            BeanUtil.mapToBean(industry,map);
            list.add(industry);
        }
        return list;
    }
    /**
     *
     * 查询   根据id查询
     * 行业代码表（tb_industry）
     * @<code>SelectIndustryid</code>
     *
     */
    public Industry SelectIndustryid(int id){
        String st="select * from tb_industry where id=?";
        List<Map<String, String>> query = DBUtil.query(st,id);
        Industry industry=new Industry();
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(industry,map);
        }
        return industry;
    }
    /**
     *
     * 查询纳税人管理
     * @<code>SelectTaxPayer1All</code>
     */
    public List<TaxPayer1> SelectTaxPayer1All(int page ,int sise){
        List<TaxPayer1> list=new ArrayList<>();
        String st="select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id" +
                " and p.userId=u.id where removeState=0  limit ?,?";
        List<Map<String, String>> query = DBUtil.query(st, (page-1)*sise, sise);
        for (Map<String, String> mp :query) {
            TaxPayer1 ttt = new TaxPayer1();
            BeanUtil.mapToBean(ttt,mp);
            list.add(ttt);
        }
        return list;
    }
    /**
     *
     * 纳税人数据条数
     * @<code>selectint</code>
     */
    public int selectint(){
        List<TaxPayer1> list=new ArrayList<>();
        String st="select  count(*) from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id where removeState=0 ";
        List<Map<String, String>> query = DBUtil.query(st);
        int i = Integer.parseInt(query.iterator().next().get("count(*)"));
        return i;
    }
}
