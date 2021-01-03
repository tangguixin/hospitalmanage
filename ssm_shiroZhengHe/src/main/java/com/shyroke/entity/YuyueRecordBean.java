package com.shyroke.entity;

public class YuyueRecordBean {
    private Integer id;

    private Integer patientId;

    private String department;

    private String doctor;

    private String time;

    private String iskanbing;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIskanbing() {
        return iskanbing;
    }

    public void setIskanbing(String iskanbing) {
        this.iskanbing = iskanbing;
    }
}