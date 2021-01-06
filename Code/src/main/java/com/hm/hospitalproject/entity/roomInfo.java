package com.hm.hospitalproject.entity;

import lombok.Data;



/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/12:23
 * @Description:
 */


@Data
public class roomInfo {

    /**
     * 科室ID
     */

    private Integer roomId;
    /**
     * 科室名称
     */

    private String roomname;

    /**
     *描述
     */

    private String description;

}


