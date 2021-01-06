package com.hm.hospitalproject.server;

import com.hm.hospitalproject.entity.CheckIterm;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/07/1:30
 * @Description:
 */

@Service
public interface CheckServer {
    Boolean addCheck(CheckIterm checkIterm);
}
