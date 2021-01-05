package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:11
 * @Description:
 */
//在线预约信息表

@Data
@Entity
public class onlineGuahao {
    @Id
    private int orderId;
    @Column
    private int userid;
    @Column
    private String roomId;
    @Column
    private String doctorId;
    @Column
    private boolean isSuccess;
    @Column
    private boolean isCancel;
    @Column
    private Timestamp createTime;

    /**
     * 预约类型
     */
    @Column
    private String type;

}
