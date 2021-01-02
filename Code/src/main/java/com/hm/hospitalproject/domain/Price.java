package com.hm.hospitalproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/02/16:05
 * @Description:
 */
@Entity
public class Price {
    @Id
    private String ProjectName;
    @Column
    private float Pprice;

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    public float getPprice() {
        return Pprice;
    }

    public void setPprice(float pprice) {
        Pprice = pprice;
    }


}
