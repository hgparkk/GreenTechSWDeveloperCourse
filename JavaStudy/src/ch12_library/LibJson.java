package ch12_library;

import org.json.simple.JSONObject;

import ch09_class.school.Student;
import hyeongyu.MyUtil;

public class LibJson {
	public static void main(String[] args) {
		Student hobbang = new Student("호빵맨",90,80,70); // let hobbang = {"name" : "호빵맨", "kor" : 90, "eng" : 80, " math" : 70, "avg" : }
		System.out.println(hobbang);
		
		hobbang.getName(); // hobbang.name or hobbang["name"]
		
		JSONObject jsonObject = new JSONObject();
		
		double n = MyUtil.myRound(10, 2);
		
		System.out.println(n);
	}
}