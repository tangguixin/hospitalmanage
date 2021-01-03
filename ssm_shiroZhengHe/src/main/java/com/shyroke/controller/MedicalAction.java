package com.shyroke.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shyroke.entity.Medical;
import com.shyroke.mapper.MedicalMapper;
import com.shyroke.util.CommonUtil;

@Controller
@RequestMapping(value="medicalAction")
public class MedicalAction {

	@Autowired
	private MedicalMapper medicalMapper;
	
	@RequestMapping(value="getData")
	@ResponseBody
	public Map<String,Object> getData(@RequestParam(value="name",required=false)String name,
			@RequestParam(value="zuoyong",required=false)String zuoyong) {
		
		Map<String,Object> meidicalMap=new HashMap<String, Object>();
		
		List<Map<String,Object>> gridList=new ArrayList<Map<String,Object>>();
		Map<String,Object> columnMap=null;
		List<Medical> medicalList=null;
		if(name!=null && !name.equals("")) {
			//按药品名称查询
			medicalList=medicalMapper.selectByName(name);
		}else if(zuoyong!=null && !zuoyong.equals("")) {
			//按药品作用查询
			medicalList=medicalMapper.selectByZuoYong(zuoyong);
		}else {
			//查询全部药品
			 medicalList=medicalMapper.selectAll();
		}
		
		if(medicalList.size()>0) {
			for(Medical medical:medicalList) {
				
				columnMap=new HashMap<String, Object>();
				columnMap.put("id", medical.getId());
				columnMap.put("medical_id", medical.getId());
				columnMap.put("medical_name", medical.getName());
				columnMap.put("medical_yongfa", medical.getYongfa());
				columnMap.put("medical_zuoyong", medical.getZuoyong());

				gridList.add(columnMap);
			}
		}
	
		
		meidicalMap.put("rows", gridList);
		
		return meidicalMap;
		
	}
	
	/**
	 * 跳转到药品详细页面
	 * @param medicalid 药品id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="medicalDesc")
	public ModelAndView medicalDesc(@RequestParam(value="selelctedMedicalId",required=true)Integer medicalid,ModelAndView model) {
		
		Medical medical=medicalMapper.selectByPrimaryKey(medicalid);
		model.addObject("medical", medical);
		
		String shenchanriqi=CommonUtil.getFormatTime(medical.getShenchanriqi());
		model.addObject("shenchanriqi", shenchanriqi);
		
		model.setViewName("views/medical/medicalDesc");
		return model;
	}
	
	
}
