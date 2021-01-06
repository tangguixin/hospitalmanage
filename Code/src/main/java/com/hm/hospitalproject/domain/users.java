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
 * @Date: 2021/01/05/17:56
 * @Description:
 */

@Entity
@Data
public class users {
    @Id
    private Integer id;
    @Column
    private String shenfenzheng;
    @Column
    private String password;
    @Column
    private String type;
    @Column
    private Timestamp createTime;

}
