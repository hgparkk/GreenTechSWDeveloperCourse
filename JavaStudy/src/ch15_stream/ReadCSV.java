package ch15_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

public class ReadCSV {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");

		String csvPath = path + "\\src\\ch15_stream\\kr_korean.csv";
		
		HashSet<String> wordSet = new HashSet<>();

		try (BufferedReader buffReader = new BufferedReader(new FileReader(csvPath))) {
			while(true) {
				String line = buffReader.readLine();
				if(line==null) {
					break;
				}
				
				String[] data = line.split(",");
				
				if(data.length<2) {
					continue;
				}
				
				if(data[1].equals("명사")) {
					String word = data[0].replace("-","");
					String pattern = "^[가-힣]{2,3}$";
					if(word.matches(pattern)) {
						wordSet.add(word);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String myCSVPath = path + "\\src\\ch15_stream\\my_korean.csv";
		
		try(BufferedWriter buffWriter = new BufferedWriter(new FileWriter(myCSVPath))){
			for(String word : wordSet) {
				buffWriter.write(word);
				buffWriter.newLine();
				buffWriter.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("데이터 처리 및 저장 완료");
	}
}