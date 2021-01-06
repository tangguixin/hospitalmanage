package com.hm.hospitalproject.controller;

import com.hm.hospitalproject.entity.Drugs;
import com.hm.hospitalproject.entity.InspectionItems;
import com.hm.hospitalproject.server.DrusServer;
import com.hm.hospitalproject.server.InspectionItemsServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 唐贵欣
 * @Date: 2021/01/05/13:18
 * @Description:
 */
@Controller
@RequestMapping("hospitalAction")
@Api(value = "医院相关api",description = "eg:")
public class HospitalManager {



    @Autowired
    private DrusServer drusServer;
    @Autowired
    private InspectionItemsServer inspectionItemsServer;


    private static Logger log = LoggerFactory.getLogger(PatientController.class);

    @RequestMapping(value = "/getAlldrugs",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有药物列表",httpMethod = "GET")
    public List<Drugs> getAlldrugs(){
      return   drusServer.getAllDrus();
    }


    @RequestMapping(value = "/getAllchecks",method = RequestMethod.GET)
    @ApiOperation(value = "获取所有检查项列表",httpMethod = "GET")
    public List<InspectionItems> getAllchecks(){

        return inspectionItemsServer.getAllItems();
    }




}
