package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/16:05
 * @Description:
 */
@Entity
public class RoomRank {

    @Id
    private String RoomName;
    @Column
    private String RRank;
    @Column
    private int PCode;


    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getRRank() {
        return RRank;
    }

    public void setRRank(String RRank) {
        this.RRank = RRank;
    }

    public int getPCode() {
        return PCode;
    }

    public void setPCode(int PCode) {
        this.PCode = PCode;
    }



}
