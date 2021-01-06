package com.hm.hospitalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/17:56
 * @Description:
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class users {

    private Integer id;

    private String shenfenzheng;

    private String password;

    private String type;

    private Timestamp createTime;

}
