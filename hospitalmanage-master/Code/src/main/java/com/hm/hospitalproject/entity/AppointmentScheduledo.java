package com.hm.hospitalproject.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AppointmentScheduledo {
    @TableId
    private String doctorName;

    private String endTime;

    private Integer leftPeople;

    private String roomid;

    private String startTime;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Integer getLeftPeople() {
        return leftPeople;
    }

    public void setLeftPeople(Integer leftPeople) {
        this.leftPeople = leftPeople;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid == null ? null : roomid.trim();
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }
}