package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:32
 * @Description: 医院财务表(可能不用)
 */
@Data
@Entity
public class finance {
    @Id
    private Integer financeId;
    @Column
    private Timestamp createTime;
    @Column
    private Double Income;
    @Column
    private Double Outcome;
}
