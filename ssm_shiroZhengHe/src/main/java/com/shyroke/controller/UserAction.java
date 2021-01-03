package com.shyroke.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.shyroke.entity.Doctor;
import com.shyroke.entity.PatientBean;
import com.shyroke.entity.Users;
import com.shyroke.entity.YuyueRecordBean;
import com.shyroke.mapper.PatientBeanMapper;
import com.shyroke.mapper.UsersMapper;
import com.shyroke.mapper.YuyueRecordBeanMapper;
import com.shyroke.util.CommonUtil;

@Controller
@RequestMapping(value = "userAction")
public class UserAction {

	@Autowired
	UsersMapper userMapper;
	
	@Autowired
	private YuyueRecordBeanMapper yuyueMapper;

	@Autowired
	private PatientBeanMapper patientMapper;
	
	@RequestMapping(value = "login")
	@ResponseBody
	public String login(Users user, HttpSession session) {

		Users users = userMapper.isUserExit(user);

		if (users != null) {
			// 合法用户

			if (users.getType().equals("患者")) {
				session.setAttribute("users", users);
			} else if (users.getType().equals("医生")) {
				session.setAttribute("doctor", users);
			} else if (users.getType().equals("药品管理员")) {
				session.setAttribute("medicionAdmin", users);
			} else if (users.getType().equals("前台")) {
				session.setAttribute("qiantai", users);
			} else if (users.getType().equals("管理员")) {
				session.setAttribute("admin", users);
			}

			Gson gson = new Gson();
			String userJson = gson.toJson(users);
			return userJson;

		} else {

			String errMsg = "{\"errMsg\":\"用户名或者密码错误\"}";

			return errMsg;
		}

	}

	/**
	 * 跳转到预约页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "yuyueView")
	public String yuyueView() {

		return "views/patient/yuyue";
	}

	/**
	 * 处理预约信息
	 * 
	 * @param session
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "yuyue")
	@ResponseBody
	public String yuyue(HttpSession session, HttpServletRequest request,YuyueRecordBean record) {

		Users user = (Users) session.getAttribute("users");

		if (user != null) {
			System.out.println(user);
		}


		String yuyuetime = request.getParameter("time");
		Date yuyueDate = CommonUtil.parseDateStr(yuyuetime);
		Date currenDate = new Date();
		if (yuyueDate.before(currenDate)) {
			//预约世间错误
			return "{\"errmsg\":\"预约时间错误，只能预约明天之后\"}";
		} else {
			//预约正确
			record.setPatientId(user.getId());
			record.setIskanbing("否");
			yuyueMapper.insert(record);
			
			return "{\"msg\":\"预约成功\"}";
		}

	}

	/**
	 * 患者退出
	 */
	@RequestMapping(value = "exit")
	public String exit(HttpSession session) {

		if (session.getAttribute("users") != null) {
			session.removeAttribute("users");
		} else if (session.getAttribute("doctor") != null) {
			session.removeAttribute("doctor");
		} else if (session.getAttribute("medicionAdmin") != null) {
			session.removeAttribute("medicionAdmin");
		} else if (session.getAttribute("qiantai") != null) {
			session.removeAttribute("qiantai");
		} else if (session.getAttribute("qiantai") != null) {
			session.removeAttribute("admin");
		}

		return "index";
	}
	
	/**
	 * 跳转到患者注册页面
	 * @return
	 */
	@RequestMapping(value="register")
	public String register() {
		return "views/patient/register";
	}
	

	/**
	 * 保存患者注册的信息
	 * @return
	 */
	@RequestMapping(value="saveRegister")
	@ResponseBody
	public String saveRegister(PatientBean patient,Users user) {
		/**
		 * 保存登录用户user信息
		 */
		user.setCreateTime(new Date());
		user.setType("患者");
		userMapper.insert(user);
		Users user1=userMapper.selectByUserName(user.getUsername());
		/**
		 * 保存患者信息
		 */
		patient.setUserId(user1.getId());
		patientMapper.insert(patient);
		
		return "{\"msg\":\"注册成功\"}";
	}
	
}
