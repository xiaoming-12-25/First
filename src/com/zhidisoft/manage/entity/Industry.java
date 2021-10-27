package com.zhidisoft.manage.entity;

import java.util.Objects;
/**
 *
 * industryName:行业名称
 * recordDate:录入日期
 * recordUserId:录入人员
 *
 */

public class Industry {
    private int id;
    private String industryName;
    private String recordDate;
    private int recordUserId;

    public Industry() {}

    public Industry(int id, String industryName, String recordDate, int recordUserId) {
        this.id = id;
        this.industryName = industryName;
        this.recordDate = recordDate;
        this.recordUserId = recordUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
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
        Industry industry = (Industry) o;
        return id == industry.id && recordUserId == industry.recordUserId && Objects.equals(industryName, industry.industryName) && Objects.equals(recordDate, industry.recordDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, industryName, recordDate, recordUserId);
    }

    @Override
    public String toString() {
        return "Industry{" +
                "id=" + id +
                ", industryName='" + industryName + '\'' +
                ", recordDate='" + recordDate + '\'' +
                ", recordUserId=" + recordUserId +
                '}';
    }
}
