package com.hm.hospitalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private Integer Id;

    private Date createTime;

    private String password;

    private String shenfenzheng;

    private String type;

}