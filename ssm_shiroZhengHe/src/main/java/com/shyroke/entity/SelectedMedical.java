package com.shyroke.entity;

public class SelectedMedical {
    private Integer id;

    private Integer selelctedMedicalId;

    private String selectedMedicalName;

    private Integer doctorId;

    private String doctorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSelelctedMedicalId() {
        return selelctedMedicalId;
    }

    public void setSelelctedMedicalId(Integer selelctedMedicalId) {
        this.selelctedMedicalId = selelctedMedicalId;
    }

    public String getSelectedMedicalName() {
        return selectedMedicalName;
    }

    public void setSelectedMedicalName(String selectedMedicalName) {
        this.selectedMedicalName = selectedMedicalName;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}