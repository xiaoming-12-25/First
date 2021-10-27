package com.zhidisoft.manage.entity;

import java.util.Objects;

/**
 *
 * payerCode:     纳税人识别号
 * payerName:     纳税人名称
 * bizAddress:    生产经营地址
 * taxOrganid:    所属税务机关
 * industryId:    行业
 * bizScope:      经营范围
 * invoiceType:   票种核定 发票种类：增值税专用发票、增值税普通发票
 * legalPerson:   法人代表
 * legalIdCard:   身份号码
 * legalMobile:   手机号码
 * legalIdCardImageURL:法人代表身份证扫描图片
 * finaceName:    财务人员
 * finaceIdCard:  财务人员身份号码
 * finaceMobile:  财务人员手机号码
 * finaceIdCardImageURL:财务人员身份证扫描图片
 * taxerName:     办税人员
 * taxerIdCard:   办税人员身份号码
 * taxerMobile:   办税人员手机号码
 * taxerIdCardImageURL:办税人员身份证扫描图片
 * bizAddressPhone:生产经营地电话
 * recordDate:    录入日期
 * userId:        录入人员
 *
 */

/**
 *
 * 更新纳税人员的信息的实体类
 * 添加纳税人的实体类
 * @<code>TaxPayer</code>
 * */

public class TaxPayer extends TaxPayer1 {
    private int id;
    private String payerCode;
    private String payerName;
    private String bizAddress;
    private String bizAddressPhone;
    private int taxOrganId;
    private int industryId;
    private String bizScope;
    private String invoiceType;
    private String legalPerson;
    private String legalIdCard;
    private String finaceName;
    private String finaceIdCard;
    private String taxerName;
    private String recordDate;
    private int userId;
    /*private String legalMobile;
    private String legalIdCardImageURL;
    private String finaceMobile;
    private String finaceIdCardImageURL;
    private String taxerIdCard;
    private String taxerMobile;
    private String taxerIdCardImageURL;
    */

    public TaxPayer() {}

    public TaxPayer(String payerCode, String payerName, String bizAddress, String bizAddressPhone, int taxOrganId, int industryId, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String recordDate, int userId) {
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizAddress = bizAddress;
        this.bizAddressPhone = bizAddressPhone;
        this.taxOrganId = taxOrganId;
        this.industryId = industryId;
        this.bizScope = bizScope;
        this.invoiceType = invoiceType;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.recordDate = recordDate;
        this.userId = userId;
    }

    public TaxPayer(String payerCode, String payerName, String bizAddress, String bizAddressPhone, int taxOrganId, int industryId, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String taxerName, String recordDate) {
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizAddress = bizAddress;
        this.bizAddressPhone = bizAddressPhone;
        this.taxOrganId = taxOrganId;
        this.industryId = industryId;
        this.bizScope = bizScope;
        this.invoiceType = invoiceType;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.taxerName = taxerName;
        this.recordDate = recordDate;
    }

    public TaxPayer(int id, String payerCode, String payerName, String bizAddress, String bizAddressPhone, int taxOrganId, int industryId, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String taxerName, String recordDate) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizAddress = bizAddress;
        this.bizAddressPhone = bizAddressPhone;
        this.taxOrganId = taxOrganId;
        this.industryId = industryId;
        this.bizScope = bizScope;
        this.invoiceType = invoiceType;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.taxerName = taxerName;
        this.recordDate = recordDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPayerCode() {
        return payerCode;
    }

    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getBizAddress() {
        return bizAddress;
    }

    public void setBizAddress(String bizAddress) {
        this.bizAddress = bizAddress;
    }

    public String getBizAddressPhone() {
        return bizAddressPhone;
    }

    public void setBizAddressPhone(String bizAddressPhone) {
        this.bizAddressPhone = bizAddressPhone;
    }

    public int getTaxOrganId() {
        return taxOrganId;
    }

    public void setTaxOrganId(int taxOrganId) {
        this.taxOrganId = taxOrganId;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public String getBizScope() {
        return bizScope;
    }

    public void setBizScope(String bizScope) {
        this.bizScope = bizScope;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getLegalIdCard() {
        return legalIdCard;
    }

    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard;
    }

    public String getFinaceName() {
        return finaceName;
    }

    public void setFinaceName(String finaceName) {
        this.finaceName = finaceName;
    }

    public String getFinaceIdCard() {
        return finaceIdCard;
    }

    public void setFinaceIdCard(String finaceIdCard) {
        this.finaceIdCard = finaceIdCard;
    }

    public String getTaxerName() {
        return taxerName;
    }

    public void setTaxerName(String taxerName) {
        this.taxerName = taxerName;
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }

    @Override
    public String toString() {
        return "TaxPayer{" +
                "id=" + id +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", bizAddress='" + bizAddress + '\'' +
                ", bizAddressPhone='" + bizAddressPhone + '\'' +
                ", taxOrganId=" + taxOrganId +
                ", industryId=" + industryId +
                ", bizScope='" + bizScope + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalIdCard='" + legalIdCard + '\'' +
                ", finaceName='" + finaceName + '\'' +
                ", finaceIdCard='" + finaceIdCard + '\'' +
                ", taxerName='" + taxerName + '\'' +
                ", recordDate='" + recordDate + '\'' +
                '}';
    }
}