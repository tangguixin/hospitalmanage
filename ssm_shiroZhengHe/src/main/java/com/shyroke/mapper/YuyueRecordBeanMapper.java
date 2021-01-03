package com.shyroke.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shyroke.entity.YuyueRecordBean;

public interface YuyueRecordBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(YuyueRecordBean record);

    int insertSelective(YuyueRecordBean record);

    YuyueRecordBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(YuyueRecordBean record);

    int updateByPrimaryKey(YuyueRecordBean record);

    /**
     * 获取某个医生的所有预约记录
     * @param name 医生名字
     * @return
     */
	List<YuyueRecordBean> getAllRecordsByDocName(@Param("docname")String name);

	List<YuyueRecordBean> selectRecordByPatientUserId(@Param("userid")Integer userId);
}