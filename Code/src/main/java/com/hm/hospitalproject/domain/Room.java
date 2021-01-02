package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.transform.sax.SAXResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/16:05
 * @Description:
 */
@Entity
public class Room {
    @Id
    private String RoomName;
    @Column
    private String DName;
    @Column
    private Boolean Prop;

    public String getRoomName() {
        return RoomName;
    }

    public void setRoomName(String roomName) {
        RoomName = roomName;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public Boolean getProp() {
        return Prop;
    }

    public void setProp(Boolean prop) {
        Prop = prop;
    }


}
