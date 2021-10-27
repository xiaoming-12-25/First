package com.zhidisoft.manage.entity;

/**
 *
 * payerId:      纳税人id
 * taskName:     任务名称
 * taxOrganId:   下达部门
 * approverId:   批准人
 * executeId:    执行人员
 * executeTime:  执行时间
 * taskFrom:     任务来源
 * taskState:    任务执行情况
 * idea:         调查结论或意见
 * riskLevel:    风险等级
 * recordDate:   录入日期
 * recordUserId: 录入人员
 *
 */

public class    TaxSource {
    private int id;
    private int payerId;
    private String taskName;
    private int subOrganId;
    private int approverId;
    private int executeId;
    private String executeTime;
    private String taskFrom;
    private String taskState;
    private String idea;
    private int riskLevel;
    private String recordTaskDate;
    private int recordUserId;

    public TaxSource() {}
    /**
     * 添加任务
     * */
    public TaxSource(int payerId, String taskName, int subOrganId, int approverId, int executeId, String executeTime, String taskState,int recordUserId) {
        this.payerId = payerId;
        this.taskName = taskName;
        this.subOrganId = subOrganId;
        this.approverId = approverId;
        this.executeId = executeId;
        this.executeTime = executeTime;
        this.taskState = taskState;
        this.recordUserId=recordUserId;
    }
    public TaxSource(int id, int payerId, String taskName, int subOrganId, int approverId, int executeId, String executeTime, String taskFrom, String taskState, String idea, int riskLevel, String recordTaskDate, int recordUserId) {
        this.id = id;
        this.payerId = payerId;
        this.taskName = taskName;
        this.subOrganId = subOrganId;
        this.approverId = approverId;
        this.executeId = executeId;
        this.executeTime = executeTime;
        this.taskFrom = taskFrom;
        this.taskState = taskState;
        this.idea = idea;
        this.riskLevel = riskLevel;
        this.recordTaskDate = recordTaskDate;
        this.recordUserId = recordUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPayerId() {
        return payerId;
    }

    public void setPayerId(int payerId) {
        this.payerId = payerId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getSubOrganId() {
        return subOrganId;
    }

    public void setSubOrganId(int subOrganId) {
        this.subOrganId = subOrganId;
    }

    public int getApproverId() {
        return approverId;
    }

    public void setApproverId(int approverId) {
        this.approverId = approverId;
    }

    public int getExecuteId() {
        return executeId;
    }

    public void setExecuteId(int executeId) {
        this.executeId = executeId;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getTaskFrom() {
        return taskFrom;
    }

    public void setTaskFrom(String taskFrom) {
        this.taskFrom = taskFrom;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRecordTaskDate() {
        return recordTaskDate;
    }

    public void setRecordTaskDate(String recordTaskDate) {
        this.recordTaskDate = recordTaskDate;
    }

    public int getRecordUserId() {
        return recordUserId;
    }

    public void setRecordUserId(int recordUserId) {
        this.recordUserId = recordUserId;
    }

    @Override
    public String toString() {
        return "TaxSource{" +
                "id=" + id +
                ", payerId=" + payerId +
                ", taskName='" + taskName + '\'' +
                ", subOrganId=" + subOrganId +
                ", approverId=" + approverId +
                ", executeId=" + executeId +
                ", executeTime='" + executeTime + '\'' +
                ", taskFrom='" + taskFrom + '\'' +
                ", taskState='" + taskState + '\'' +
                ", idea='" + idea + '\'' +
                ", riskLevel=" + riskLevel +
                ", recordTaskDate='" + recordTaskDate + '\'' +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
