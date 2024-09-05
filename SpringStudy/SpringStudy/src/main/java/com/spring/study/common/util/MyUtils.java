package com.spring.study.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtils {
	public static String makeUniqueId() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String result = sdf.format(date);
		
		for(int i = 0; i <6;i++) {
			int random = (int) (Math.random() * 10);
			result += random;
		}
		
		return result;
	}
}