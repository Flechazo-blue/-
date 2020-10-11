package com.kaikeba.homework.bean;

import java.util.Objects;

public class Express {
    private String number;
    private String company;
    private int code;

    public Express() {
    }

    public Express(String number, String company, int code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Express express = (Express) o;
        return Objects.equals(number, express.number);
    }

}
