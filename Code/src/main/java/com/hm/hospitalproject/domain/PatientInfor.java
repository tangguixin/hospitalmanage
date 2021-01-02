package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/15:48
 * @Description:
 */
@Entity
public class PatientInfor {
    @Id
    private int PCode;
    @Column
    private String PName;
    @Column
    private int  PID;
    @Column
    private String SEX;
    @Column
    private int AGE;
    @Column
    private String PHis;
    @Column
    private String PAd ;
    @Column
    private String  Pcheck;

    public int getPCode() {
        return PCode;
    }

    public void setPCode(int PCode) {
        this.PCode = PCode;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }

    public String getPHis() {
        return PHis;
    }

    public void setPHis(String PHis) {
        this.PHis = PHis;
    }

    public String getPAd() {
        return PAd;
    }

    public void setPAd(String PAd) {
        this.PAd = PAd;
    }

    public String getPcheck() {
        return Pcheck;
    }

    public void setPcheck(String pcheck) {
        Pcheck = pcheck;
    }







}
