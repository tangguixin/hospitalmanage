package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:26
 * @Description: 病人收费单表（账单）
 */


@Data
@Entity
public class patientbills {
    @Id
    private Integer billId;
    @Column
    private Integer patientId;
    @Column
    private String billList;
    @Column
    private Timestamp creatTime;
    @Column
    private boolean jisuan;
}
