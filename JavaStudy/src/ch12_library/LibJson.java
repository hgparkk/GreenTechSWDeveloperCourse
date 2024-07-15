package ch12_library;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ch09_class.school.Student;
import hyeongyu.MyUtil;

public class LibJson {
	public static void main(String[] args) throws ParseException {
		Student hobbang = new Student("호빵맨", 90, 80, 70); // let hobbang = {"name" : "호빵맨", "kor" : 90, "eng" : 80, "
															// math" : 70, "avg" : 80.0}
		System.out.println(hobbang);

		hobbang.getName(); // hobbang.name or hobbang["name"]

		JSONObject jsonObject = new JSONObject();

		System.out.println(MyUtil.myRound(3.1415, 3));

		jsonObject.put("name", "아이유");
		System.out.println(jsonObject);

		jsonObject.put("age", 32);
		System.out.println(jsonObject);

		jsonObject.put("age", 31); // JSON은 내부에 중복되는 Key 값을 가질 수 없기 때문에 같은 Key 값을 넣으면 기존에 가지고 있던 Key 값을 수정한다.
		System.out.println(jsonObject);

		JSONArray jsonArray = new JSONArray();
		jsonArray.add("블루밍");
		jsonArray.add("밤편지");
		jsonArray.add("코인");
		jsonArray.add(100);

		System.out.println(jsonArray);

		jsonObject.put("songList", jsonArray);

		System.out.println(jsonObject);
		System.out.println(jsonObject.toString());

		String jsonString = jsonObject.toString(); // JSON 객체에 대해 문자열 타입으로 표현한 것 <- 데이터 통신시 사용

		JSONObject nahuna = new JSONObject();

		nahuna.put("name", "나훈아");
		nahuna.put("age", 60);

		JSONArray songs = new JSONArray();
		songs.add("테스형");
		songs.add("붉은 입술");

		nahuna.put("songs", songs);

		System.out.println(nahuna);

		jsonObject.put("father", nahuna);

		System.out.println(jsonObject);

		System.out.println(jsonObject.get("name"));

		String name = (String) jsonObject.get("name");

		int age = (int) jsonObject.get("age");
		System.out.println(age);

		JSONArray songList = (JSONArray) jsonObject.get("songList");

		for (int i = 0; i < songList.size(); i++) {
			System.out.println(songList.get(i));
		}

		JSONObject father = (JSONObject) jsonObject.get("father");

		String nahunaName = (String) father.get("name");
		System.out.println(nahunaName);

		JSONArray song = (JSONArray) father.get("songs");

		System.out.println(song.get(0));

		System.out.println("========================================================");

		String response = "{\"father\":{\"songs\":[\"테스형\",\"붉은 입술\"],\"name\":\"나훈아\",\"age\":60},\"name\":\"아이유\",\"songList\":[\"블루밍\",\"밤편지\",\"코인\",100],\"age\":31}";

		JSONParser jsonParser = new JSONParser();

		JSONObject jsonData = (JSONObject) jsonParser.parse(response);

		System.out.println(jsonData);

		name = (String) jsonData.get("name");
		System.out.println(name);
		long ageLong = (long) jsonData.get("age");
		System.out.println(ageLong);

		System.out.println("========================================================");

		JsonObject gsonObject = new JsonObject();
		gsonObject.addProperty("name", "아이유");
		gsonObject.addProperty("age", 31);

		System.out.println(gsonObject);

		JsonArray gsonArray = new JsonArray();
		gsonArray.add("좋은 날");
		gsonArray.add("분홍신");
		System.out.println(gsonArray);

		gsonObject.add("songs", gsonArray);
		System.out.println(gsonObject);

		Gson gson = new Gson();

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gsonPretty = gsonBuilder.setPrettyPrinting().create();

		String gsonString = gson.toJson(gsonObject);

		System.out.println(gsonString);

		String gsonStringPretty = gsonPretty.toJson(gsonObject);

		System.out.println(gsonStringPretty);

		Student jjinbbang = new Student("찐빵맨", 90, 80, 70);
		System.out.println(jjinbbang);
		String jjinJson = gson.toJson(jjinbbang);
		System.out.println(jjinJson); // 자바 객체에 대해 직렬화 (serialization)

		String[] nameArray = { "호빵맨", "찐빵맨", "꿀빵맨" };
		String strName = gson.toJson(nameArray);
		System.out.println(strName);

		ArrayList<String> nameList = new ArrayList<>();
		nameList.add("짱구");
		nameList.add("철수");
		nameList.add("맹구");

		String strJjang = gson.toJson(nameList);
		System.out.println(strJjang);

		ArrayList<Student> stuList = new ArrayList<>();
		stuList.add(new Student("짱구", 67, 76, 66));
		stuList.add(new Student("철수", 77, 86, 86));
		stuList.add(new Student("맹구", 97, 66, 96));
		String stuStu = gson.toJson(stuList);
		System.out.println(stuStu);

		String str = "{\"name\":\"찐빵맨\",\"kor\":90,\"eng\":80,\"math\":70,\"avg\":80.0}\r\n";

		Student comeback = gson.fromJson(str, Student.class);

		System.out.println(comeback);

		String resp = "{\"success\": true, \"timeseries\": true, \"base\": \"USD\", \"start_date\": \"2020-08-01\", \"end_date\": \"2022-08-01\", \"rates\": {\"2020-08-01\": {\"JPY\": 105.65, \"KES\": 107.57, \"KGS\": 76.52, \"KHR\": 4092.64, \"KMF\": 417.5, \"KPW\": 898.38, \"KRW\": 1192.25}, \"2020-08-02\": {\"JPY\": 105.74, \"KES\": 107.69, \"KGS\": 76.62, \"KHR\": 4100, \"KMF\": 418.06, \"KPW\": 899.58, \"KRW\": 1193.46}}}";

		// 2020 8 2 한국 환율 꺼내기
		JSONObject jsonResp = (JSONObject) jsonParser.parse(resp);

		JSONObject jsonRates = (JSONObject) jsonResp.get("rates");

		JSONObject Date0802 = (JSONObject) jsonRates.get("2020-08-02");

		Double KRW = (double) Date0802.get("KRW");

		System.out.println(KRW);
	}
}