package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/16:04
 * @Description:
 */
@Entity
public class InlineGuahao {
    @Id
    private int  PCode;
    @Column
    private String DName;
    @Column
    private Timestamp Time;

    public int getPCode() {
        return PCode;
    }

    public void setPCode(int PCode) {
        this.PCode = PCode;
    }

    public String getDName() {
        return DName;
    }

    public void setDName(String DName) {
        this.DName = DName;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }



}
