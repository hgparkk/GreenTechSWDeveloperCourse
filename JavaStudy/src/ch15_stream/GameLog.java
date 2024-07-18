package ch15_stream;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class GameLog {

	static void saveLog(String log) {
		String logPath = "C:\\temp\\log.txt";

		try (FileWriter writer = new FileWriter(logPath, true)) {
			writer.write(log + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");

		System.out.print("아이디 입력: ");

		String id = scan.nextLine();

		int grade = 1;

		while (true) {
			System.out.println("현재 강화"+grade);
			System.out.println("강화 확률 50%");
			System.out.println("1. 강화 | 2. 종료");
			System.out.print(">>> ");

			int command = Integer.parseInt(scan.nextLine());

			if (command == 1) {
				int random = (int) (Math.random() * 2);

				if (random == 0) {
					grade++;
					String date = sdf.format(new Date());
					saveLog(date + "|" + id + "님이 강화에 성공하였습니다." + (grade - 1) + " -> " + grade);
				} else {
					grade--;
					String date = sdf.format(new Date());
					saveLog(date + "|" + id + "님이 강화에 실패하였습니다." + (grade + 1) + " -> " + grade);
				}
			} else {
				break;
			}
		}
	}
}