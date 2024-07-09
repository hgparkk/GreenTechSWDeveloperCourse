package ch08_collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionMap {
	public static void main(String[] args) {
		HashMap<String, String> stuMap = new HashMap<>();

		Map<String, String> stuMap2 = new HashMap<>();

		stuMap.put("첫째", "현구");
		stuMap.put("둘째", "다윗");
		stuMap.put("셋째", "기주");

		System.out.println(stuMap);

		stuMap.put("넷째", "기주");

		System.out.println(stuMap);

		stuMap.put("둘째", "재민");
		System.out.println(stuMap); // 중복 key 값을 허용하지 않는다.

		HashMap<String, Integer> coinMap = new HashMap<>();

		coinMap.put("비트코인", 75000000);
		coinMap.put("도지코인", 133);

		System.out.println(coinMap);

		System.out.println(stuMap.get("둘째"));

		System.out.println(coinMap.get("비트코인"));

		System.out.println(stuMap.get("없음"));

		System.out.println(stuMap.size());

		System.out.println(stuMap.containsKey("둘째"));
		System.out.println(stuMap.containsKey("다섯째"));

		System.out.println(stuMap.get("셋째") != null); // containsKey 와 같은 기능
		System.out.println(stuMap.get("다섯째") != null);
		
		System.out.println(stuMap.containsValue("기주"));
		System.out.println(stuMap.containsValue("경희"));
		
		stuMap.remove("둘째");
		
		System.out.println(stuMap);
		
		System.out.println("=========================================================");
		
		Set<String> keySet = stuMap.keySet();
		
		for(String key:keySet) {
			System.out.println(key);
			System.out.println(stuMap.get(key));
		}
		
		Set<Entry<String,String>> entrySet =stuMap.entrySet();
		
		for(Entry<String,String> entry : entrySet) {
			System.out.println(entry);
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
	}
}