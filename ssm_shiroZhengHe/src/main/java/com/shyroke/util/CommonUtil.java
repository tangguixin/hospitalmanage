package com.shyroke.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 常用的工具包
 * 
 * @author 半颗柠檬、
 *
 */
public class CommonUtil {

	/**
	 * 将yyyy-MM-dd HH:mm格式的字符串转为Date
	 * 
	 * @param yuyuetime
	 * @return
	 * @throws ParseException
	 */
	public static Date parseDateStr(String yuyuetime) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		Date date = null;
		try {
			date = format.parse(yuyuetime);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 以yyyy-HH-dd 格式输出日期字符串
	 * @param shenchanriqi
	 * @return
	 */
	public static String getFormatTime(Date date) {

		DateFormat formate=new SimpleDateFormat("yyyy-HH-dd");
		
		return formate.format(date);
	}


}
