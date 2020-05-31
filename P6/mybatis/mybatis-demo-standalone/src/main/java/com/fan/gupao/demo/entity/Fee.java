package com.fan.gupao.demo.entity;

public class Fee {
    private String id;

    private String feeAmt;

    private String feeDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getFeeAmt() {
        return feeAmt;
    }

    public void setFeeAmt(String feeAmt) {
        this.feeAmt = feeAmt == null ? null : feeAmt.trim();
    }

    public String getFeeDate() {
        return feeDate;
    }

    public void setFeeDate(String feeDate) {
        this.feeDate = feeDate == null ? null : feeDate.trim();
    }
}