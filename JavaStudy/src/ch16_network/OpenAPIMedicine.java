package ch16_network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class OpenAPIMedicine {
	public static void main(String[] args) throws IOException, ParseException {
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
		urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* 응답데이터 형식(xml/json) Default:xml */

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
		// System.out.println(sb.toString());

		JSONParser jsonParser = new JSONParser();

		JSONObject json = (JSONObject) jsonParser.parse(sb.toString());

		JSONObject body = (JSONObject) json.get("body");

		JSONArray items = (JSONArray) body.get("items");

		JSONObject potion = (JSONObject) items.get(0);

		System.out.println(potion.get("itemName"));

		String path = System.getProperty("user.dir");
		String csvPath = path + "\\src\\files\\medicine.txt";

		for (int i = 0; i < items.size(); i++) {
			JSONObject currentObject = (JSONObject) items.get(i);
			String itemSeq = (String) currentObject.get("itemSeq");
			String entpName = (String) currentObject.get("entpName");
			String itemName = (String) currentObject.get("itemName");
			String efcyQesitm = (String) currentObject.get("efcyQesitm");

			if(efcyQesitm == null) {
				continue;
			}
			
			efcyQesitm = efcyQesitm.replace("\n", "");

			String writeLine = itemSeq + "|" + entpName + "|" + itemName + "|" + efcyQesitm;

			try (BufferedWriter buffWriter = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(csvPath, true), "UTF-8"))) {
				buffWriter.write(writeLine);
				buffWriter.newLine();
				buffWriter.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("끝");
	}
}