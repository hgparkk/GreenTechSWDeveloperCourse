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
		
		System.out.println("========================================================");
		
		Calendar calToday = Calendar.getInstance(); //Calendar 클래스 사용하기
		
		System.out.println(calToday);
		
		Date calToDate = calToday.getTime();
		
		System.out.println(sdf.format(calToDate));
		
		System.out.println("========================================================");
		
		long longToday = System.currentTimeMillis(); // System 클래스 사용하기
		System.out.println(longToday); // 1970년 1월 1일 부터 현재까지 경과된 시간을 밀리초 단위로 반환
		
		System.out.println(sdf.format(longToday));
		
		long dateToLong = dateToday.getTime();
		System.out.println(dateToLong);
		
		System.out.println("========================================================");
		
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
		
		System.out.println("========================================================");
		
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
		
		System.out.println("========================================================");
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2002,6-1,2);
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(cal.getTime()));
		
		cal.set(2002,5,2,20,20,20);
		System.out.println(sdf.format(cal.getTime()));
		
		Date date = cal.getTime();
		
		cal.setTime(dateTomorrow); // Date 타입에서 Calendar 객체 얻기
		System.out.println(sdf.format(cal.getTime()));
		
		int year = cal.get(Calendar.YEAR);
		System.out.println(year);
		
		int month = cal.get(Calendar.MONTH);
		System.out.println(month);
		
		int day = cal.get(Calendar.DATE);
		System.out.println(day);
		
		int hour = cal.get(Calendar.HOUR);
		System.out.println(hour);
		
		int hourOfDay = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println(hourOfDay);
		
		int minute = cal.get(Calendar.MINUTE);
		System.out.println(minute);
		
		int second = cal.get(Calendar.SECOND);
		System.out.println(second);
		
		System.out.println("========================================================");
		
		String oneDay = "2024.07.10 09:30:00";
		String twoDay = "2024.07.12 03:10:20";
		
		sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		
		Date oneDate = sdf.parse(oneDay);
		Date twoDate = sdf.parse(twoDay);
		
		System.out.println(oneDate);
		System.out.println(twoDate);
		
		System.out.println(oneDate.getTime());
		System.out.println(twoDate.getTime());
		
		long diffMillSec = twoDate.getTime() - oneDate.getTime();
		System.out.println(diffMillSec + "밀리 초 차이");
		
		long diffSecond = diffMillSec/1000;
		System.out.println(diffSecond + "초 차이");
		
		long diffMinute = diffSecond/60;
		System.out.println(diffMinute + "분 차이");
		
		long diffHour = diffMinute/60;
		System.out.println(diffHour + "시간 차이");
		
		long diffDate = diffHour/24;
		System.out.println(diffDate + "일 차이");
		
		diffDate = (long)Math.ceil((double)diffHour/24);
		System.out.println(diffDate + "일 차이");
		
		Date nowDate = new Date();
		sdf = new SimpleDateFormat("yyyy.MM.dd");
		String start = "2024.06.27";
		long diffDayStart = sdf.parse(start).getTime() - nowDate.getTime();
		diffDayStart = (long)(Math.ceil((double)diffDayStart/86400000));
		System.out.println((diffDayStart > 0) ? ("D+"+diffDayStart):("D"+diffDayStart));
		
		String holiday = "2024.08.15";
		long diffDayHoliday = sdf.parse(holiday).getTime() - nowDate.getTime();
		diffDayHoliday = (long)(Math.ceil((double)diffDayHoliday/86400000));
		System.out.println((diffDayHoliday > 0) ? ("D+"+diffDayHoliday):("D"+diffDayHoliday));
		
		calDday(start);
		calDday(holiday);
		calDday("2024.07.22");
		
		System.out.println("========================================================");
		
		Calendar toCal = Calendar.getInstance();
		
		System.out.println(sdf.format(toCal.getTime()));
		
		toCal.add(Calendar.DATE, 3);
		
		System.out.println(sdf.format(toCal.getTime()));
		
		toCal.add(Calendar.DATE, 45);
		
		System.out.println(sdf.format(toCal.getTime()));
		
		toCal.add(Calendar.DATE, -7);
		
		System.out.println(sdf.format(toCal.getTime()));
		
		toCal.add(Calendar.MONTH, 1);
		
		System.out.println(sdf.format(toCal.getTime()));
		
		toCal.add(Calendar.MONTH, 4);
		
		System.out.println(sdf.format(toCal.getTime()));
	}
	
	public static void calDday(String date) throws ParseException{
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		long diffDay = sdf.parse(date).getTime() - now.getTime();
		diffDay = (long)(Math.ceil((double)diffDay/86400000));
		System.out.println((diffDay > 0) ? ("D+"+diffDay):("D"+diffDay));
	}
}