package com.zhidisoft.manage.entity;

import java.util.Objects;

/**
 *
 * organName:  税务机关名称
 * parentId:   上级税务机关代码
 * address:    税务机关地址
 * phone:      税务机关联系电话
 * faxPhone:   传真电话
 * email:      电子信箱
 * leaderId:   负责人
 * taxTypeCode:国地税类型代码
 * state:      有效标志
 * recordDate: 录入日期
 * recordUserId:录入人员
 *
 */
public class TaxOrgan {
    private int id;
    private String organName;
    private int parentId;
    private String address;
    private String phone;
    private String faxPhone;
    private String email;
    private int leaderId;
    private String taxTypeCode;
    private int state;
    private String recordDate;
    private int recordUserId;

    public TaxOrgan() {}

    public TaxOrgan(int id, String organName) {
        this.id = id;
        this.organName = organName;
    }

    public TaxOrgan(int id, String organName, int parentId, String address, String phone, String faxPhone, String email, int leaderId, String taxTypeCode, int state, String recordDate, int recordUserId) {
        this.id = id;
        this.organName = organName;
        this.parentId = parentId;
        this.address = address;
        this.phone = phone;
        this.faxPhone = faxPhone;
        this.email = email;
        this.leaderId = leaderId;
        this.taxTypeCode = taxTypeCode;
        this.state = state;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public void setFaxPhone(String faxPhone) {
        this.faxPhone = faxPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(int leaderId) {
        this.leaderId = leaderId;
    }

    public String getTaxTypeCode() {
        return taxTypeCode;
    }

    public void setTaxTypeCode(String taxTypeCode) {
        this.taxTypeCode = taxTypeCode;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaxOrgan taxOrgan = (TaxOrgan) o;
        return id == taxOrgan.id && parentId == taxOrgan.parentId && leaderId == taxOrgan.leaderId && state == taxOrgan.state && recordUserId == taxOrgan.recordUserId && Objects.equals(organName, taxOrgan.organName) && Objects.equals(address, taxOrgan.address) && Objects.equals(phone, taxOrgan.phone) && Objects.equals(faxPhone, taxOrgan.faxPhone) && Objects.equals(email, taxOrgan.email) && Objects.equals(taxTypeCode, taxOrgan.taxTypeCode) && Objects.equals(recordDate, taxOrgan.recordDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, organName, parentId, address, phone, faxPhone, email, leaderId, taxTypeCode, state, recordDate, recordUserId);
    }

    @Override
    public String toString() {
        return "TaxOrgan{" +
                "id=" + id +
                ", organName='" + organName + '\'' +
                '}';
    }
}
