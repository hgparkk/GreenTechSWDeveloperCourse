package ch16_network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONObject;
import org.json.XML;
import org.json.JSONArray;

public class OpenAPIXML {
	public static void main(String[] args) throws IOException {
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=7iwd9W8L5Kbf0TSMmZlfTf9B4Bzi6b6KX5HkUGG0XkD19ZSr%2BIw3WD9zmD1MoXdQ7UQhPYlBK3wWkg3%2B4jSaVQ%3D%3D"); /*
																														 * Service
																														 * Key
																														 */
		urlBuilder
				.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("100", "UTF-8")); /* 한 페이지 결과 수 */

		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		
		JSONObject json = XML.toJSONObject(sb.toString());
		
		JSONObject response = (JSONObject)json.get("response");
		
		JSONObject body = (JSONObject) response.get("body");
		
		JSONObject items = (JSONObject) body.get("items");

		JSONArray item = (JSONArray) items.get("item");

		JSONObject potion = (JSONObject) item.get(0);
		
		System.out.println(potion);

	}
}