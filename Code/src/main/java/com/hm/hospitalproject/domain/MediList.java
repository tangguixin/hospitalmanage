package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/16:04
 * @Description:
 */
@Entity
public class MediList {
    @Id
    private int MediCode;
    @Column
    private String MList;
    @Column
    private double Fee;
    @Column
    private Boolean MediCon;
    @Column
    private  String Medirank;
    @Column
    private int MediCodeNow;

}
