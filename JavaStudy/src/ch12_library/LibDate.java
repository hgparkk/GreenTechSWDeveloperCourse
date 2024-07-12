package ch12_library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class LibDate {
	public static void main(String[] args) throws InterruptedException, ParseException {
		Date dateToday = new Date(); //Date 클래스 사용하기
		
		System.out.println(dateToday);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strToday = sdf.format(dateToday);
		
		System.out.println(strToday);
		
		System.out.println("=========================================================");
		
		Calendar calToday = Calendar.getInstance(); //Calendar 클래스 사용하기
		
		System.out.println(calToday);
		
		Date calToDate = calToday.getTime();
		
		System.out.println(sdf.format(calToDate));
		
		System.out.println("=========================================================");
		
		long longToday = System.currentTimeMillis(); // System 클래스 사용하기
		System.out.println(longToday); // 1970년 1월 1일 부터 현재까지 경과된 시간을 밀리초 단위로 반환
		
		System.out.println(sdf.format(longToday));
		
		long dateToLong = dateToday.getTime();
		System.out.println(dateToLong);
		
		System.out.println("=========================================================");
		
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(sdf.format(new Date()));
		sdf = new SimpleDateFormat("yy-MM-dd a K:mm:ss");
		System.out.println(sdf.format(new Date()));
		sdf = new SimpleDateFormat("E요일 HH:mm");
		System.out.println(sdf.format(new Date()));
		sdf = new SimpleDateFormat("yyyy.MM.dd a K:mm:ss",Locale.ENGLISH);
		System.out.println(sdf.format(new Date()));
		
		TimeZone zone = TimeZone.getTimeZone("America/New_York");
		sdf = new SimpleDateFormat("EEE MM dd HH:mm:ss z yyyy",Locale.ENGLISH);
		sdf.setTimeZone(zone);
		System.out.println(sdf.format(new Date()));
		
		System.out.println("=========================================================");
		
		String strTomorrow = "2024-07-13 17:30:00";
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date dateTomorrow = sdf.parse(strTomorrow);
		
		System.out.println(dateTomorrow);
		
		String strTime = "10:30:20";
		sdf = new SimpleDateFormat("HH:mm:ss");
		
		Date dateTime = sdf.parse(strTime);
		
		System.out.println(dateTime);
		
		String strYear = "2024.07.14";
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		
		Date dateYear = sdf.parse(strYear);
		
		System.out.println(dateYear);
		
		System.out.println("=========================================================");
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2002,6-1,2);
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		
		cal.set(2002,5,2,20,20,20);
		System.out.println(sdf.format(cal.getTime()));
	}
}