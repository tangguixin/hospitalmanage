package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 检查项目
 */

@Entity
@Data
public class InspectionItems {
    /**
     * 检查项目的主键
     */
    @Id
    private Integer checkId;

    /**
     * 检查项目的名字
     */
    @Column
    private String  itemName;

    /**
     * 检查项目的花费
     */
    @Column
    private double cost;

    /**
     * 检查项目的描述
     */
    @Column
    private String itemDescribe;
}
