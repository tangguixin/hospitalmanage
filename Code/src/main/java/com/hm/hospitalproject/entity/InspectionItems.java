package com.hm.hospitalproject.entity;

import lombok.Data;


/**
 * 检查项目
 */

@Data
public class InspectionItems {
    /**
     * 检查项目的主键
     */

    private Integer checkId;

    /**
     * 检查项目的名字
     */

    private String  itemName;

    /**
     * 检查项目的花费
     */

    private double cost;

    /**
     * 检查项目的描述
     */

    private String itemDescribe;
}
