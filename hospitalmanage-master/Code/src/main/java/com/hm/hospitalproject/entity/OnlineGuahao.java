package com.hm.hospitalproject.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OnlineGuahao {
    @TableId
    private int orderId;
    private String ordertime;

    private Date createTime;

    private Integer doctorId;

    private Boolean isCancel;

    private Boolean isSuccess;

    private Integer roomId;

    private String type;

    private Integer userid;


}