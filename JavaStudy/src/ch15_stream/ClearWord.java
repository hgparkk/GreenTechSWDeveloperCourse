package ch15_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ClearWord {
	public static void main(String[] args) {
		ArrayList<String> wordList = new ArrayList<>();

		String path = System.getProperty("user.dir");

		String myCSVPath = path + "\\src\\ch15_stream\\my_korean.csv";

		try (BufferedReader buffReader = new BufferedReader(new FileReader(myCSVPath))) {
			while (true) {
				String line = buffReader.readLine();
				if (line == null) {
					break;
				}

				wordList.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ArrayList<String> clearWord = new ArrayList<>();
		
		for(int i=0;i<wordList.size();i++) {
			boolean check = false;
			for(int j=0;j<wordList.size();j++) {
				if(i!=j) {
					String word1 = wordList.get(i);
					String word2 = wordList.get(j);
					
					if(word1.substring(word1.length()-1,word1.length()).equals(word2.substring(0,1))){
						check = true;
					}
				}
			}
			if(!check) {
				clearWord.add(wordList.get(i));
				System.out.println(wordList.get(i));
			}
		}
	}
}