package com.zhidisoft.manage.dao;

import com.zhidisoft.manage.entity.*;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TaxSourceDao {
    /**
     *
     * 任务查询  分页模糊查询
     * @<code>SelectTask</code>
     *
     */
    public List<TaskManager> SelectTask(int page, int sise, String payerCode, String payerName, int subOrganId, int industryId, String startDate, String endDate) {
        List<TaskManager> list = new ArrayList();
        String st = "select *,timestampdiff(day,executeTime,recordTaskDate) as timeOutfrom from tb_tax_source s join tb_tax_payer p join tb_industry i on s.payerId=p.id and p.industryId=i.id where s.removeState=0 ";
        if (payerCode.length() > 0) {
            st = st + " and p.payerCode like '%" + payerCode + "%'";
        }
        if (payerName.length() > 0) {
            st = st + " and p.payerName like '%" + payerName + "%'";
        }
        if (subOrganId != -1) {
            st = st + " and s.subOrganId like '%" + subOrganId + "%'";
        }
        if (industryId != -1) {
            st = st + " and p.industryId like '%" + industryId + "%'";
        }
        if (startDate.length() > 0) {
            st = st + " and s.executeTime  like '%" + startDate + "%'";
        }
        if (endDate.length() > 0) {
            st = st + " and s.recordTaskDate like '%" + endDate + "%'";
        }
        st = st + " limit ?,?";
        List<Map<String, String>> query = DBUtil.query(st, (page - 1) * sise, sise);
        for (Map<String, String> map : query) {
            TaskManager taskManager = new TaskManager();
            BeanUtil.mapToBean(taskManager, map);
            list.add(taskManager);
        }
        return list;
    }

    /**
     *
     * 数据条数   任务查询数据的数量
     * @<code>count</code>
     *
     */

    public int count(String payerCode, String payerName, int subOrganId, int industryId, String startDate, String endDate) {
        String st = "select count(s.id) from tb_tax_source s join tb_tax_payer p join tb_industry i on s.payerId=p.id and p.industryId=i.id where s.removeState=0 ";
        if (payerCode.length() > 0) {
            st = st + " and p.payerCode like '%" + payerCode + "%'";
        }
        if (payerName.length() > 0) {
            st = st + " and p.payerName like '%" + payerName + "%'";
        }
        if (subOrganId != -1) {
            st = st + " and s.subOrganId like '%" + subOrganId + "%'";
        }
        if (industryId != -1) {
            st = st + " and p.industryId like '%" + industryId + "%'";
        }
        if (startDate.length() > 0) {
            st = st + " and s.executeTime  like '%" + startDate + "%'";
        }
        if (endDate.length() > 0) {
            st = st + " and s.recordTaskDate like '%" + endDate + "%'";
        }
        List<Map<String, String>> query = DBUtil.query(st);
        int i = Integer.parseInt(query.iterator().next().get("count(s.id)"));
        return i;
    }
    /**
     *
     * 添加任务 时查看 纳税人 详情
     * @<code>SelectTaxPayer1</code>
     */
    public TaxPayer1 SelectTaxPayer1(int id){
        TaxPayer1 tp = new TaxPayer1();
        String st="select * from tb_tax_payer p join tb_industry i join tb_tax_organ o join tb_tax_source s on p.taxOrganId=o.id and p.industryId=i.id and p.id=s.payerId where s.id=? ";
        List<Map<String, String>> query = DBUtil.query(st, id);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(tp,map);
        }
        return tp;
    }
    /**
     *
     * 添加任务信息
     * @<code>AddTaxSource</code>
     *
     */
    public int AddTaxSource(TaxSource taxSource, String table) {
        int add = DBUtil.add(taxSource, table);
        return add;
    }
    /**
     *
     * 税源基础信息表（tb_tax_source）
     * 任务信息查询所有
     * @<code>SelectTaxSourceAll</code>
     *
     */
    public List<TaxSource> SelectTaxSourceAll() {
        List<TaxSource> list = new ArrayList<>();
        String st = "select * from tb_tax_source";
        List<Map<String, String>> query = DBUtil.query(st);
        for (Map<String, String> map : query) {
            TaxSource taxSource = new TaxSource();
            BeanUtil.mapToBean(taxSource, map);
            list.add(taxSource);
        }
        return list;
    }
    /**
     *
     * 查询任务详情
     * @<code>SelectTaxSourceId</code>
     */
    public TaxSource SelectTaxSourceId(int id){
        TaxSource taxSource = new TaxSource();
        String st="select * from tb_tax_source where id=?";
        List<Map<String, String>> query = DBUtil.query(st, id);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(taxSource,map);
        }
        return taxSource;
    }
    /**
     *
     * 删除任务详情
     * 更改特定的标签
     * @<code>DeleteTaxkId</code>
     *
     */
    public int DeleteTaxkId(int id){
        String st="update tb_tax_source set removeState=1 where id=?";
        int update = DBUtil.update(st, id);
        return update;
    }
    /**
     *
     * 更改任务
     * @<code>UpdateTaskId</code>
     *
     */
    public int UpdateTaskId(String taskName,int subOrganId,int approverId,int executeId,String executeTime,String taskState,int id){
        String st="update tb_tax_source set taskName=?,subOrganId=?,approverId=?,executeId=?,executeTime=?,taskState=? where id=?";
        int update = DBUtil.update(st, taskName, subOrganId, approverId, executeId, executeTime,taskState, id);
        return update;
    }
    /**
     *
     * 未被调查 分页模糊查询
     * @<code>noSurvey</code>
     *
     */
    public List<TaxPayer1> noSurvey(int page ,int size,String payerCode,String payerName){
        String sql = "select * from tb_tax_payer p LEFT join tb_tax_source s on p.id=s.payerId JOIN tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id  where s.id is null and p.removeState=0";
        boolean pc = payerCode != null && payerCode.length() > 0;
        boolean pn = payerName != null && payerName.length() > 0;
        if(pc){
            sql = sql+" and p.payerCode = " + payerCode;
        }
        if(pn){
            sql = sql+" and p.payerName like '%" + payerName +"%'";
        }
        sql = sql + " limit ?,?";
        List<Map<String, String>> query = DBUtil.query(sql, (page-1)*size, size);
        List<TaxPayer1> l = new ArrayList<>();
        for (Map<String, String> mp:query) {
            TaxPayer1 tp = new TaxPayer1();
            BeanUtil.mapToBean(tp,mp);
            l.add(tp);
        }
        return l;
    }

/**
 *
 * 未被调查的数据条数
 * @<code>noCount</code>
 *
 */
    public int noCount(String payerCode,String payerName){
        String sql = "select count(p.id) from tb_tax_payer p LEFT join tb_tax_source s on p.id=s.payerId JOIN tb_industry i join tb_tax_organ o join tb_user u on p.taxOrganId=o.id and p.industryId=i.id and p.userId=u.id  where s.id is null and p.removeState=0";
        boolean pc = payerCode != null && payerCode.length() > 0;
        boolean pn = payerName != null && payerName.length() > 0;
        if(pc){
            sql = sql+" and p.payerCode = " + payerCode;
            System.out.println(sql);
        }
        if(pn){
            sql = sql+" and p.payerName like '%" + payerName +"%'";
        }
        List<Map<String, String>> query = DBUtil.query(sql);
        int s = Integer.parseInt(query.iterator().next().get("count(p.id)"));
        return s;
    }
}
