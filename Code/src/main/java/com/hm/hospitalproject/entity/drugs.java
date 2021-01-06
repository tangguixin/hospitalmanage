package com.hm.hospitalproject.entity;

import lombok.Data;


import java.util.Date;

/**
 * 药品
 */

@Data
public class drugs {

    /**
     * 药品的自增主键
     */

    private Integer id;

    /**
     * 药品的名字
     */

    private String name;

    /**
     * 药品的成分
     */

    private String chengfen;

    /**
     * 药品的用法
     */

    private String yongfa;

    /**
     * 药品的作用
     */

    private String zuoyong;

    /**
     * 药品的副作用
     */

    private String fuzuoyong;

    /**
     * 药品的价格
     */

    private String price;

    /**
     * 药品的保质期
     */

    private String baozhiqi;

    /**
     * 药品的生产日期
     */

    private Date shenchanriqi;

    /**
     * 生成药品的公司
     */

    private String company;

    /**
     * 药品的极性
     */

    private String jixing;
}
