package com.hm.hospitalproject.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hm.hospitalproject.entity.users;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/06/12:46
 * @Description:
 */

@Repository
public interface UserMapper extends BaseMapper<users> {
    @Select("getAllusers")
    List<users> getAllusers();
}
