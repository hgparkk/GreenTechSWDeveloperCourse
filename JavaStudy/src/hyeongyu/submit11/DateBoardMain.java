package hyeongyu.submit11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

public class DateBoardMain {
	public static void main(String[] args) throws ParseException {
		ArrayList<DateBoard> dbList = new ArrayList<DateBoard>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		for (int i = 0; i < 100; i++) {
			int randDay = (int) (Math.random() * 365) + 1;
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, randDay * -1);

			String strDate = sdf.format(cal.getTime());
			dbList.add(new DateBoard((i + 1) + "번째 생성된 글", strDate));
		}

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		// Q. 02
		System.out.println("============================ 최신순 정렬 ============================");
		System.out.println();

		Collections.sort(dbList, (db1, db2) -> {
			try {
				return sdf.parse(db1.getDate()).getTime() - sdf.parse(db2.getDate()).getTime() > 0 ? (-1) : (1);
			} catch (ParseException e) {
				return -1;
			}
		});

		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		System.out.println();
		System.out.println("============================ 과거순 정렬 ============================");
		System.out.println();

		Collections.sort(dbList, (db1, db2) -> {
			try {
				return sdf.parse(db2.getDate()).getTime() - sdf.parse(db1.getDate()).getTime() > 0 ? (-1) : (1);
			} catch (ParseException e) {
				return -1;
			}
		});
		for (int i = 0; i < dbList.size(); i++) {
			System.out.println(dbList.get(i));
		}

		System.out.println();
		System.out.println("============================ 최근 한달 내 ============================");
		System.out.println();

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, -1);
		Date now = new Date();
		for (int i = 0; i < dbList.size(); i++) {
			long currentLong = sdf.parse(dbList.get(i).getDate()).getTime();
			if (cal.getTimeInMillis() < currentLong && currentLong < now.getTime()) {
				System.out.println(dbList.get(i));
			}
		}

		System.out.println();
		System.out.println("============================ 이번달 출력 ============================");
		System.out.println();

		cal = Calendar.getInstance();
		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH);
		for (int i = 0; i < dbList.size(); i++) {
			Calendar current = Calendar.getInstance();
			Date currentDate = sdf.parse(dbList.get(i).getDate());
			current.setTime(currentDate);
			if (current.get(Calendar.YEAR) == nowYear && current.get(Calendar.MONTH) == nowMonth) {
				System.out.println(dbList.get(i));
			}
		}
	}
}