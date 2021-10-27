package com.zhidisoft.manage.entity;

public class TaskManager {
    private int id;
    private String taskName;
    private String payerCode;
    private String payerName;
    private String industryName;
    private String bizScope;
    private String executeTime;
    private String recordTaskDate;
    private String timeOutfrom;
    public TaskManager() {}

    public TaskManager(int id, String taskName, String payerCode, String payerName, String industryName, String bizScope, String executeTime, String recordTaskDate, String timeOutfrom) {
        this.id = id;
        this.taskName = taskName;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.industryName = industryName;
        this.bizScope = bizScope;
        this.executeTime = executeTime;
        this.recordTaskDate = recordTaskDate;
        this.timeOutfrom = timeOutfrom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getRecordTaskDate() {
        return recordTaskDate;
    }

    public void setRecordTaskDate(String recordTaskDate) {
        this.recordTaskDate = recordTaskDate;
    }

    public String getTimeOutfrom() {
        return timeOutfrom;
    }

    public void setTimeOutfrom(String timeOutfrom) {
        this.timeOutfrom = timeOutfrom;
    }

    @Override
    public String toString() {
        return "TaskManager{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", payerCode='" + payerCode + '\'' +
                ", payerName='" + payerName + '\'' +
                ", industryName='" + industryName + '\'' +
                ", bizScope='" + bizScope + '\'' +
                ", executeTime='" + executeTime + '\'' +
                ", recordTaskDate='" + recordTaskDate + '\'' +
                ", timeOutfrom='" + timeOutfrom + '\'' +
                '}';
    }
}
