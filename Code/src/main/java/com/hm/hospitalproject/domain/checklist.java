package com.hm.hospitalproject.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/11:21
 * @Description:医生给病人开的检查单
 */


@Data
@Entity
public class checklist {
   @Id
   private Integer checkId;
   @Column
   private Integer patientId;
   @Column
   private Integer doctorId;
   @Column
   private String chickList;
   @Column
   private Boolean jiesuan;
}
