package com.fan.gupao.demo3;

import java.util.Date;

/**
 * @Description:
 * @Author: 樊高风
 * @Date: 10:26 2020/5/31
 */
public class IdentiyCard {

    private String idNumber;
    private String address;
    private Date startDate;
    private Date endData;

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndData() {
        return endData;
    }

    public void setEndData(Date endData) {
        this.endData = endData;
    }
}
