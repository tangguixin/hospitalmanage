package com.shyroke.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shyroke.entity.ChufangRecord;
import com.shyroke.entity.Doctor;
import com.shyroke.entity.Medical;
import com.shyroke.entity.SelectedMedical;
import com.shyroke.entity.YuyueRecordBean;
import com.shyroke.mapper.ChufangRecordMapper;
import com.shyroke.mapper.DoctorMapper;
import com.shyroke.mapper.MedicalMapper;
import com.shyroke.mapper.SelectedMedicalMapper;
import com.shyroke.mapper.YuyueRecordBeanMapper;

@Controller
@RequestMapping(value = "chufangRecordAction")
public class ChufangRecordAction {
	
	@Autowired
	private ChufangRecordMapper chufangMapper;
	
	@Autowired
	private SelectedMedicalMapper selectedMedicalMapper;
	@Autowired
	private MedicalMapper medicalMapper;
	
	@Autowired
	private YuyueRecordBeanMapper recordMapper;

	@Autowired
	private DoctorMapper doctorMapper;

	/**
	 * 医生选中处方药，将之添加到已选择药品记录表中。
	 * @param selectedMedical
	 * @return
	 */
	@RequestMapping(value = "addMedical")
	@ResponseBody
	public String addMedical(SelectedMedical selectedMedical) {

		Doctor doctor = doctorMapper.selectByPrimaryKey(selectedMedical.getDoctorId());
		Medical medical=medicalMapper.selectByPrimaryKey(selectedMedical.getSelelctedMedicalId());
		
		selectedMedical.setDoctorName(doctor.getName());
		selectedMedical.setSelectedMedicalName(medical.getName());
		
		selectedMedicalMapper.insert(selectedMedical);

		return "success";
	}
	
	/**
	 * 保存医生开的处方药记录
	 * @param chufangRecord
	 * @return
	 */
	@RequestMapping(value="saveMedical")
	@ResponseBody
	public String saveMedical(ChufangRecord chufangRecord,@RequestParam(value="recordid")Integer recordid) {
	
		chufangRecord.setTime(new Date());
		
		
		//获取医生已开的药品
		List<SelectedMedical> selectedMedicalList=selectedMedicalMapper.selectByDoctorId(chufangRecord.getDoctorId());
		StringBuffer meidalName=new StringBuffer();
		for(SelectedMedical medical:selectedMedicalList) {
			meidalName.append(medical.getSelectedMedicalName()+",");
		}
		//清楚已选药品的记录
		selectedMedicalMapper.deleteByDoctorId(chufangRecord.getDoctorId());
		chufangRecord.setChufang(meidalName.toString());
		
		//更新病人预约记录为已看病
		YuyueRecordBean record=recordMapper.selectByPrimaryKey(recordid);
		record.setIskanbing("是");
		recordMapper.updateByPrimaryKey(record);
		
		chufangMapper.insert(chufangRecord);
		return "{\"msg\":\"添加成功\"}";
	}
}
