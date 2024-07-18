package ch13_exception;

import java.text.ParseException;
import java.util.Scanner;

public class ExceptionMain {
	public static void main(String[] args) {
		int[] intArray = { 1, 2, 3 };
		try {
			System.out.println("인덱싱 이전");
			System.out.println(intArray[4]);
			System.out.println("인덱싱 이후");
		} catch (ArrayIndexOutOfBoundsException aioobe) {
			System.out.println(aioobe);
			aioobe.printStackTrace();
		}

		System.out.println("인덱싱 예외처리 끝남");

		try {
			System.out.println(intArray[4]);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.err.println("빨간글자");

		System.out.println("========================================================");

		Scanner scan = new Scanner(System.in);

		/*
		 * while(true) { System.out.println("행동 선택");
		 * System.out.println("1. 밥먹기 | 2. 잠자기 | 3. 종료"); System.out.print(">>> ");
		 * 
		 * int command = 0;
		 * 
		 * try { command = Integer.parseInt(scan.nextLine()); }catch(Exception e) {
		 * System.out.println("숫자만 입력해주세요!!"); continue; }
		 * 
		 * if(command == 1) { System.out.println("냠냠"); }else if(command ==2) {
		 * System.out.println("쿨쿨"); }else if(command==3) { System.out.println("빠빠");
		 * break; }else { System.out.println("숫자는 1~3중 하나를 입력"); } }
		 */

		System.out.println("========================================================");

		try {
			int command = Integer.parseInt("12f212");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			long time = ExMethod.strToLong("2024.07.16");
			System.out.println(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String result;
		try {
			result = ExMethod.rsp(4);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		try {
			ExMethod.printName("호빵1맨");
		} catch (BizException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getErrCode());
		}

		System.out.println("========================================================");

		try {
			ExMethod.printName(null);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 주로 자원을 닫기 위한 목적으로 사용
			System.out.println("에러가 나든 말든 실행");
		}

		try {
			System.out.println(scan.nextLine());
		} catch (Exception e) {

		} finally {
			scan.close();
		}

		try (Scanner sc = new Scanner(System.in)) { // try with resource try() 소괄호 안에 선언후
			System.out.println(sc.nextLine()); // try(){} 중괄호 안에서 객체를 사용하면 이후 자동으로 close 해준다.
		} catch (Exception e) {
			System.out.println("catch가 없어도 된다.");
		}
	}
}