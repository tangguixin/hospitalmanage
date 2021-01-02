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
public class Payment {
    @Id
    private int PCode;
    @Column
    private String RRank;
    @Column
    private float TotalPrice;
    @Column
    private boolean PayCond;

    public int getPCode() {
        return PCode;
    }

    public void setPCode(int PCode) {
        this.PCode = PCode;
    }

    public String getRRank() {
        return RRank;
    }

    public void setRRank(String RRank) {
        this.RRank = RRank;
    }

    public float getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        TotalPrice = totalPrice;
    }

    public boolean isPayCond() {
        return PayCond;
    }

    public void setPayCond(boolean payCond) {
        PayCond = payCond;
    }




}
