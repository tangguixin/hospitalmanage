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
public class RoomWin {
    @Id
    private String RoomName;
    @Column
    private boolean Win1;
    @Column
    private boolean Win2;
    @Column
    private boolean Win3;

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public boolean isWin1() {
        return Win1;
    }

    public void setWin1(boolean win1) {
        Win1 = win1;
    }

    public boolean isWin2() {
        return Win2;
    }

    public void setWin2(boolean win2) {
        Win2 = win2;
    }

    public boolean isWin3() {
        return Win3;
    }

    public void setWin3(boolean win3) {
        Win3 = win3;
    }



}
