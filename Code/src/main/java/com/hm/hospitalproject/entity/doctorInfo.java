package com.hm.hospitalproject.entity;

public class DoctorInfo {
    private Integer doctorId;

    private String doctorAbout;

    private String doctorForte;

    private String doctorImg;

    private String doctorName;

    private Integer doctorPhone;

    private String doctorSex;

    private String doctorTitle;

    private String officesName;

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorAbout() {
        return doctorAbout;
    }

    public void setDoctorAbout(String doctorAbout) {
        this.doctorAbout = doctorAbout == null ? null : doctorAbout.trim();
    }

    public String getDoctorForte() {
        return doctorForte;
    }

    public void setDoctorForte(String doctorForte) {
        this.doctorForte = doctorForte == null ? null : doctorForte.trim();
    }

    public String getDoctorImg() {
        return doctorImg;
    }

    public void setDoctorImg(String doctorImg) {
        this.doctorImg = doctorImg == null ? null : doctorImg.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public Integer getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(Integer doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex == null ? null : doctorSex.trim();
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle == null ? null : doctorTitle.trim();
    }

    public String getOfficesName() {
        return officesName;
    }

    public void setOfficesName(String officesName) {
        this.officesName = officesName == null ? null : officesName.trim();
    }
}