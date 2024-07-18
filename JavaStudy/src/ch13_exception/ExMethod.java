package ch13_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExMethod {
	public static long strToLong(String date) throws ParseException { // throws : 예외 처리를 호출하는 곳으로 넘긴다.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		return sdf.parse(date).getTime();
	}

	public static String rsp(int number) throws Exception {
		if (number == 0) {
			return "가위";
		} else if (number == 1) {
			return "바위";
		} else if (number == 2) {
			return "보";
		} else {
			throw new Exception("숫자 0~2만 가능");
		}
	}

	public static void printName(String name) throws BizException {
		if(name.length()==0) {
			throw new BizException("빈 문자열이 들어옴","API 001");
		}else if(name.matches(".*[0-9].*")) {
			throw new BizException("숫자가 들어옴","API 002");
		}
		System.out.println(name);
	}
}