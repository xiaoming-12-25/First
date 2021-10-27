package com.zhidisoft.system.entity;

import java.util.Objects;

/**
 * taxerCode: 税务人员编号
 * taxerName: 税务人员名称
 * mobile:    税务人员电话
 * address:   税务人员地址
 * sex:       税务人员性别
 * birthday:  出生日期
 * email:     电子邮件
 * organId:   所属税务机关：      关联tb_tax_organ
 * state:     有效标志：1:       有效 0:无效 默认0
 * mgr:       上级领导：         tb_taxer中税务工作人员
 * admin:     系统管理员标志：    1代表是 0代表不是 默认为0
 * recordDate:录入日期
 * recordUserId:录入人员
 */
public class TaxUser {
    private int id;
    private String taxerCode;
    private String taxerName;
    private String mobile;
    private String address;
    private String sex;
    private String birthday;
    private String email;
    private int organId;
    private int state;
    private int mgr;
    private int admin;
    private String recordDate;
    private int recordUserId;
    //
    private String organName;


    public TaxUser() {}

    public TaxUser(String taxerCode, String taxerName, String mobile, String address, String sex, String birthday, String email, int organId , int recordUserId) {
        this.taxerCode = taxerCode;
        this.taxerName = taxerName;
        this.mobile = mobile;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.organId = organId;
        this.recordUserId=recordUserId;
    }

    public TaxUser(int id, String taxerCode, String taxerName, String mobile, String address, String sex, String birthday, String email, int organId, int state, int mgr, int admin, String recordDate, int recordUserId,String organName) {
        this.id = id;
        this.taxerCode = taxerCode;
        this.taxerName = taxerName;
        this.mobile = mobile;
        this.address = address;
        this.sex = sex;
        this.birthday = birthday;
        this.email = email;
        this.organId = organId;
        this.state = state;
        this.mgr = mgr;
        this.admin = admin;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
        this.organName= organName;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaxerCode() {
        return taxerCode;
    }

    public void setTaxerCode(String taxerCode) {
        this.taxerCode = taxerCode;
    }

    public String getTaxerName() {
        return taxerName;
    }

    public void setTaxerName(String taxerName) {
        this.taxerName = taxerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getOrganId() {
        return organId;
    }

    public void setOrganId(int organId) {
        this.organId = organId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    public int getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(int recordUserId) {
        this.recordUserId = recordUserId;
    }

    @Override
    public String toString() {
        return "TaxUser{" +
                "id=" + id +
                ", taxerCode='" + taxerCode + '\'' +
                ", taxerName='" + taxerName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", email='" + email + '\'' +
                ", organId=" + organId +
                ", state=" + state +
                ", mgr=" + mgr +
                ", admin=" + admin +
                ", recordDate='" + recordDate + '\'' +
                ", recordUserId=" + recordUserId +
                ", organName='" + organName + '\'' +
                '}';
    }
}
