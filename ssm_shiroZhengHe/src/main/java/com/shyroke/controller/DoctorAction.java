package com.shyroke.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shyroke.entity.ChufangRecord;
import com.shyroke.entity.Doctor;
import com.shyroke.entity.PatientBean;
import com.shyroke.entity.Users;
import com.shyroke.entity.YuyueRecordBean;
import com.shyroke.mapper.ChufangRecordMapper;
import com.shyroke.mapper.DoctorMapper;
import com.shyroke.mapper.PatientBeanMapper;
import com.shyroke.mapper.YuyueRecordBeanMapper;

@Controller
@RequestMapping(value = "doctorAction")
public class DoctorAction {

	@Autowired
	private DoctorMapper doctorMapper;

	@Autowired
	private YuyueRecordBeanMapper recordMapper;

	@Autowired
	private PatientBeanMapper patientMapper;
	
	@Autowired
	private ChufangRecordMapper chufangRecordMapper;

	@RequestMapping(value = "getDoctorByDepartment")
	@ResponseBody
	public List<Doctor> getDoctorByDepartment(@RequestParam("department") String department) {

		List<Doctor> docs = doctorMapper.getDoctorsByDepartment(department);

		return docs;
	}

	/**
	 * 跳转到医生的挂号查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "guahaoView")
	public String guahaoView() {
		return "views/doctor/guahao";
	}

	/**
	 * 获取挂号页面的数据表格所需要的数据
	 * 
	 * @param session
	 * @param yuyueid
	 *            查询条件之一：预约编号
	 * @param patientname
	 *            查询条件之一：患者名字
	 * @return
	 */
	@RequestMapping(value = "getData")
	@ResponseBody
	public Map<String, Object> getData(HttpSession session,
			@RequestParam(value = "yuyueid", required = false) String yuyueid,
			@RequestParam(value = "patientname", required = false) String patientname) {

		Users currenuser = (Users) session.getAttribute("doctor");
		Doctor currenDoc = doctorMapper.selectByPrimaryKey(currenuser.getId());
		Map<String, Object> gridMap = new HashMap<String, Object>();
		List<Map<String, Object>> gridList = new ArrayList<Map<String, Object>>();
		List<YuyueRecordBean> recordList = new ArrayList<YuyueRecordBean>();
		if (yuyueid != null && yuyueid != "") {
			// 说明查询预约编号
			YuyueRecordBean record = recordMapper.selectByPrimaryKey(Integer.valueOf(yuyueid));

			if (record != null) { // 如果有该记录
				recordList.add(record);
			} else {
				recordList = null;
			}

		} else if (patientname != null && patientname != "") {
			// 说明查询患者名字
			PatientBean patient = patientMapper.selectPatientByTrueName(patientname);
			recordList = recordMapper.selectRecordByPatientUserId(patient.getUserId());

		} else {
			recordList = recordMapper.getAllRecordsByDocName(currenDoc.getName());
		}

		Map<String, Object> columnMap = null;

		if (recordList != null) { 
			for (YuyueRecordBean record : recordList) {
				columnMap = new HashMap<String, Object>();

				PatientBean patient = patientMapper.selectPatientByUserId(record.getPatientId());
				columnMap.put("recordid", record.getId());
				columnMap.put("name", patient.getTruename());
				columnMap.put("time", record.getTime());
				columnMap.put("isKanBing", record.getIskanbing());
				gridList.add(columnMap);

			}
		}
		int recordTotal = doctorMapper.getTotalRecord(currenDoc.getName());
		gridMap.put("total", recordTotal);
		gridMap.put("rows", gridList);

		return gridMap;
	}
	
	/**
	 * 确认对病人就诊，更新预约记录的isKanBing字段
	 * @return
	 */
	@RequestMapping(value="jiuzhen")
	public String jiuzhen(@RequestParam(value="recordid")String recordid) {
		
		YuyueRecordBean record=new YuyueRecordBean();
		record.setId(Integer.valueOf(recordid));
		record.setIskanbing("是");
		recordMapper.updateByPrimaryKeySelective(record);
		
		return "views/doctor/doctor";
	}

	/**
	 * 由预约记录id获取该病人的信息
	 * @param recordid 预约记录id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="patientInfo")
	public ModelAndView patientInfo(@RequestParam("recordid")Integer recordid,ModelAndView model) {
		
		YuyueRecordBean record=recordMapper.selectByPrimaryKey(recordid);
		
		PatientBean patient=patientMapper.selectPatientByUserId(record.getPatientId());
		model.addObject("patient", patient);
		
		//添加患者病情
		List<ChufangRecord> chufangrecordList=chufangRecordMapper.selectByPatientId(record.getPatientId());
		model.addObject("chufangrecordList", chufangrecordList);
		
		model.setViewName("views/patient/patientInfo");
		return model;
	}
	
	/**
	 * 跳转到医生就诊病人的页面
	 * @param model
	 * @param recordid
	 * @return
	 */
	@RequestMapping(value="zhenduanView")
	public ModelAndView zhenduanView(ModelAndView model,@RequestParam("recordid")Integer recordid) {
		YuyueRecordBean record=recordMapper.selectByPrimaryKey(recordid);
		
		Doctor doctor=doctorMapper.getDoctorByName(record.getDoctor());
		
		model.addObject("doctor", doctor);
		
		PatientBean patient=patientMapper.selectPatientByUserId(record.getPatientId());
		model.addObject("patient", patient);
		model.addObject("recordid",recordid);
		
		model.setViewName("views/doctor/jiuzhen");
		return model;
	}
	
}
