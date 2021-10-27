package com.zhidisoft.system.dao;

import com.zhidisoft.system.entity.TaxUser;
import com.zhidisoft.system.entity.User;
import com.zhidisoft.system.entity.UserComplete;
import com.zhidisoft.util.BeanUtil;
import com.zhidisoft.util.DBUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * 登录验证
 * 查询该账号是否在数据库存在
 * 存在给对象赋值
 * 不存在对象值为空
 * @<code>SelectUser</code>
 *
 */
public class UserDao {
    public User SelectUser(String name){
        User user=new User();
        String st="select * from tb_user where username=?";
        //调用工具类方法  工具类的方法
        List<Map<String, String>> query = DBUtil.query(st, name);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(user,map);
        }
        return user;
    }
    /**
     * 查看用户详细信息
     * @<code></code>
     *
     */
    public UserComplete SelectUserComplete(int id){
        UserComplete userComplete = new UserComplete();
        String st="select * from tb_taxer t join tb_user u on u.taxerId = t.id where u.id=?";
        List<Map<String, String>> query = DBUtil.query(st, id);
        for (Map<String, String> map : query) {
            BeanUtil.mapToBean(userComplete,map);
        }
        return userComplete;
    }
    /**
     * 修改密码
     * @<code>UpdatePassword</code>
     * */
    public int UpdatePassword(int id, String password){
        String st="update tb_user set password=? where id=?";
        int update = DBUtil.update(st,password,id);
        return update;
    }
    /**
     *
     * 办税人员查询 查询所有办税人员
     * @<code>SelecrTaxUserAll</code>
     *
     */
    public List<TaxUser> SelecrTaxUserAll(){
        List<TaxUser> list=new ArrayList<>();
        String st="select * from tb_taxer";
        List<Map<String, String>> query = DBUtil.query(st);
        for (Map<String, String> map :query) {
            TaxUser taxUser=new TaxUser();
            BeanUtil.mapToBean(taxUser,map);
            list.add(taxUser);
        }
        return list;
    }
    /**
     *
     * 办税人员分页  模糊  查询
     * @<code>SelectTaxUesrDim</code>
     *
     */
    public List<TaxUser> SelectTaxUesrDim(int page,int size,String taxerName){
        List<TaxUser> list=new ArrayList<>();
        String st="select * from tb_taxer where dele=1";
        if (taxerName.length()>0){
            st=st+" and taxerName like '%"+taxerName+"%'";
        }
        st=st+" limit ?,? ";
        List<Map<String, String>> query = DBUtil.query(st,(page-1)*size,size );
        for (Map<String, String> map : query) {
            TaxUser taxUser=new TaxUser();
            BeanUtil.mapToBean(taxUser,map);
            list.add(taxUser);
        }
        return list;
    }
    /**
     *
     * 查看办税人员分页查询的数据条数
     * @<code>SelectTaxUesrSum</code>
     *
     */
    public int SelectTaxUesrSum(String taxerName){
        String st="select count(id) from tb_taxer where dele=1";
        if (taxerName.length()>0){
            st=st+" and  taxerName like '%"+taxerName+"%'";
        }
        List<Map<String, String>> query = DBUtil.query(st);
        int s = Integer.parseInt(query.iterator().next().get("count(id)"));
        return s;
    }
    /**
     *
     * 办税人员查询  根据id查询
     * @<code>SelecrTaxUserId</code>
     *
     */
    public TaxUser SelecrTaxUserId(int id){
        String st="select * from tb_taxer where id=?";
        List<Map<String, String>> query = DBUtil.query(st,id);
        TaxUser taxUser=new TaxUser();
        for (Map<String, String> map :query) {
            BeanUtil.mapToBean(taxUser,map);
        }
        return taxUser ;
    }
    /**
    *
    * 添加办税人员
    * @<code>AddTaxUser</code>
    */
    public int AddTaxUser(TaxUser taxUser, String table){
        int add = DBUtil.add(taxUser, table);
        return add;
    }
    /**
     *
     * 办税人员查询  与税务机关连表查询
     * @<code>SelecrTaxUserId</code>
     *
     */
    public TaxUser SelecrTaxUserorganName(int id){
        String st="select * from tb_taxer t join tb_tax_organ o on o.id=t.organId  where t.id=?";
        List<Map<String, String>> query = DBUtil.query(st,id);
        TaxUser taxUser=new TaxUser();
        for (Map<String, String> map :query) {
            BeanUtil.mapToBean(taxUser,map);
        }
        return taxUser ;
    }
    /**
     *
     * 删除办税人员
     * 更改特定表签
     * @<code>DeleteTaxUser</code>
     *
     */
    public int DeleteTaxUser(int id){
        String st="update tb_taxer set dele=0 where id=?";
        int update = DBUtil.update(st, id);
        return update;
    }
    /**
     *
     * 更改办税人数据
     * @<code>UpdateTaxUser</code>
     *
     */
    public int UpdateTaxUser(String taxerCode,String taxerName, String mobile,String address,String sex,String birthday,String email, int organId,int id ){
        String st="update tb_taxer set taxerCode=?,taxerName=?,mobile=?, address=?,sex=?,birthday=?,email=?,organId=? where id=?";
        int update = DBUtil.update(st, taxerCode, taxerName, mobile, address, sex, birthday, email, organId, id);
        return update;
    }

}
