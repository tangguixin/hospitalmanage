package com.hm.hospitalproject.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Drugs {
    private Integer id;

    private String baozhiqi;

    private String chengfen;

    private String company;

    private String fuzuoyong;

    private String jixing;

    private String name;

    private String price;

    private Date shenchanriqi;

    private String yongfa;

    private String zuoyong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBaozhiqi() {
        return baozhiqi;
    }

    public void setBaozhiqi(String baozhiqi) {
        this.baozhiqi = baozhiqi == null ? null : baozhiqi.trim();
    }

    public String getChengfen() {
        return chengfen;
    }

    public void setChengfen(String chengfen) {
        this.chengfen = chengfen == null ? null : chengfen.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getFuzuoyong() {
        return fuzuoyong;
    }

    public void setFuzuoyong(String fuzuoyong) {
        this.fuzuoyong = fuzuoyong == null ? null : fuzuoyong.trim();
    }

    public String getJixing() {
        return jixing;
    }

    public void setJixing(String jixing) {
        this.jixing = jixing == null ? null : jixing.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Date getShenchanriqi() {
        return shenchanriqi;
    }

    public void setShenchanriqi(Date shenchanriqi) {
        this.shenchanriqi = shenchanriqi;
    }

    public String getYongfa() {
        return yongfa;
    }

    public void setYongfa(String yongfa) {
        this.yongfa = yongfa == null ? null : yongfa.trim();
    }

    public String getZuoyong() {
        return zuoyong;
    }

    public void setZuoyong(String zuoyong) {
        this.zuoyong = zuoyong == null ? null : zuoyong.trim();
    }
}