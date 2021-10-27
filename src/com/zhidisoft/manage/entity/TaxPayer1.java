package com.zhidisoft.manage.entity;

public class TaxPayer1 {
    private int id;
    private String payerCode;
    private String payerName;
    private String bizAddress;
    private String bizAddressPhone;
    private String organName;
    private String industryName;
    private String bizScope;
    private String invoiceType;
    private String legalPerson;
    private String legalIdCard;
    private String finaceName;
    private String finaceIdCard;
    private String legalIdCardImageURL;
    private String finaceIdCardImageURL;
    private String taxerName;
    private String recordDate;
    private String username;



    public TaxPayer1() {}
/**
 *
 * 首页   --分页纳税人信息
 *
 * */
    public TaxPayer1(int id, String payerCode, String payerName, String organName, String industryName, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String recordDate) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.organName = organName;
        this.industryName = industryName;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.recordDate = recordDate;
    }
    /**
     *
     * 首页   --分页纳税人信息
     * 纳税人详细信息
     *
     * */
    public TaxPayer1(int id, String payerCode, String payerName, String bizAddress, String bizAddressPhone, String organName, String industryName, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String legalIdCardImageURL, String finaceIdCardImageURL, String taxerName, String recordDate) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizAddress = bizAddress;
        this.bizAddressPhone = bizAddressPhone;
        this.organName = organName;
        this.industryName = industryName;
        this.bizScope = bizScope;
        this.invoiceType = invoiceType;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.legalIdCardImageURL = legalIdCardImageURL;
        this.finaceIdCardImageURL = finaceIdCardImageURL;
        this.taxerName = taxerName;
        this.recordDate = recordDate;
    }
    /**
     *
     * 新建任务查询的详细信息纳税人的详细信息
     *
     *
     */
    public TaxPayer1(int id, String payerCode, String payerName, String bizAddress, String bizAddressPhone, String organName, String industryName, String bizScope, String invoiceType, String legalPerson, String legalIdCard, String finaceName, String finaceIdCard, String taxerName, String recordDate, String username) {
        this.id = id;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.bizAddress = bizAddress;
        this.bizAddressPhone = bizAddressPhone;
        this.organName = organName;
        this.industryName = industryName;
        this.bizScope = bizScope;
        this.invoiceType = invoiceType;
        this.legalPerson = legalPerson;
        this.legalIdCard = legalIdCard;
        this.finaceName = finaceName;
        this.finaceIdCard = finaceIdCard;
        this.taxerName = taxerName;
        this.recordDate = recordDate;
        this.username = username;
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

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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

    public String getLegalIdCardImageURL() {
        return legalIdCardImageURL;
    }

    public void setLegalIdCardImageURL(String legalIdCardImageURL) {
        this.legalIdCardImageURL = legalIdCardImageURL;
    }

    public String getFinaceIdCardImageURL() {
        return finaceIdCardImageURL;
    }

    public void setFinaceIdCardImageURL(String finaceIdCardImageURL) {
        this.finaceIdCardImageURL = finaceIdCardImageURL;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "TaxPayer1{" +
                "id=" + id +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", bizAddress='" + bizAddress + '\'' +
                ", bizAddressPhone='" + bizAddressPhone + '\'' +
                ", organName='" + organName + '\'' +
                ", industryName='" + industryName + '\'' +
                ", bizScope='" + bizScope + '\'' +
                ", invoiceType='" + invoiceType + '\'' +
                ", legalPerson='" + legalPerson + '\'' +
                ", legalIdCard='" + legalIdCard + '\'' +
                ", finaceName='" + finaceName + '\'' +
                ", finaceIdCard='" + finaceIdCard + '\'' +
                ", legalIdCardImageURL='" + legalIdCardImageURL + '\'' +
                ", finaceIdCardImageURL='" + finaceIdCardImageURL + '\'' +
                ", taxerName='" + taxerName + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
