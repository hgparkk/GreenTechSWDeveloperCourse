package hyeongyu.submit08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

public class Submit08 {

	// Q. 01
	public static ArrayList<Integer> makeLotto() {
		HashSet<Integer> resultSet = new HashSet<>();
		while (resultSet.size() < 6) {
			resultSet.add((int) (Math.random() * 45) + 1);
		}
		ArrayList<Integer> resultList = new ArrayList<>(resultSet);
		Collections.sort(resultList);
		return resultList;
	}

	public static void main(String[] args) {
		// Q. 01
		ArrayList<Integer> myLotto = makeLotto();
		System.out.println(myLotto);
		
		System.out.println();
		
		// Q. 02
		HashMap<String, String> infoMap = new HashMap<>();
		
		infoMap.put("a001", "1234a");
		infoMap.put("b001", "1234b");
		infoMap.put("c001", "1234c");
		infoMap.put("d001", "1234d");
		infoMap.put("e001", "1234e");
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("아이디를 입력해주세요");
		System.out.print(">>> ");
		String id = scan.nextLine();
		System.out.println("비밀번호를 입력해주세요");
		System.out.print(">>> ");
		String pw = scan.nextLine();
		if(!infoMap.containsKey(id)) {
			System.out.println("존재하지 않는 아이디입니다.");
		}else if(!infoMap.get(id).equals(pw)) {
			System.out.println("비밀번호가 틀렸습니다.");
		}else {
			System.out.println("로그인 성공");
		}
	}
}
