package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/12:23
 * @Description:
 */

@Entity
@Data
public class roomInfo {

    /**
     * 科室ID
     */
    @Id
    private Integer roomId;
    /**
     * 科室名称
     */
    @Column
    private String roomname;

    /**
     *描述
     */
    @Column
    private String description;

}


