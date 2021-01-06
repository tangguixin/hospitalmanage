package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:17
 * @Description:  每一项检查和每种药物的单价和药材剩余情况表
 */
@Data
@Entity
public class perPrice {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private String chengfen;
    @Column
    private String yongfa;
    @Column
    private String zuoyong;
    @Column
    private String fuzuoyong;
    @Column
    private String price;
    @Column
    private String baozhiqi;
    @Column
    private Date shenchanriqi;
    @Column
    private String company;
    @Column
    private String jixing;

}
