package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 药品
 */

@Entity
@Data
public class drugs {

    /**
     * 药品的自增主键
     */
    @Id
    private Integer id;

    /**
     * 药品的名字
     */
    @Column
    private String name;

    /**
     * 药品的成分
     */
    @Column
    private String chengfen;

    /**
     * 药品的用法
     */
    @Column
    private String yongfa;

    /**
     * 药品的作用
     */
    @Column
    private String zuoyong;

    /**
     * 药品的副作用
     */
    @Column
    private String fuzuoyong;

    /**
     * 药品的价格
     */
    @Column
    private String price;

    /**
     * 药品的保质期
     */
    @Column
    private String baozhiqi;

    /**
     * 药品的生产日期
     */
    @Column
    private Date shenchanriqi;

    /**
     * 生成药品的公司
     */
    @Column
    private String company;

    /**
     * 药品的极性
     */
    @Column
    private String jixing;
}
