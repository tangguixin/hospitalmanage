package com.hm.hospitalproject.entity;

import lombok.Data;


import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:32
 * @Description:
 */

//医院财务表(可能不用)



@Data
public class finance {

    private Integer financeId;

    private Timestamp createTime;

    private Double Income;

    private Double Outcome;
}
