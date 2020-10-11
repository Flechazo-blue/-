package com.kaikeba.homework1;

import java.util.Objects;

public class ExpressDelivery {
    private String trackingNum;
    private String company;
    private String pickupCode;

    public ExpressDelivery(){}

    public ExpressDelivery(String trackingNum, String company) {
        this.trackingNum = trackingNum;
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpressDelivery that = (ExpressDelivery) o;

        if(that == null){
            return false;
        }

        if(pickupCode != null){
            if(pickupCode.equals(that.pickupCode)){
                return true;
            }
        }

        if(trackingNum != null){
            if(trackingNum.equals(that.trackingNum)){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "{" +
                "快递单号 ： '" + trackingNum + '\'' + '\n' +
                ", 公司名称 ： '" + company + '\'' + '\n' +
                ", 取件码 ： '" + pickupCode + '\'' + '\n' +
                '}';
    }

    public String getTrackingNum() {
        return trackingNum;
    }

    public void setTrackingNum(String trackingNum) {
        this.trackingNum = trackingNum;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPickupCode() {
        return pickupCode;
    }

    public void setPickupCode(String pickupCode) {
        this.pickupCode = pickupCode;
    }
}
