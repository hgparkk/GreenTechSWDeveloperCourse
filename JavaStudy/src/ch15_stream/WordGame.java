package ch15_stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {
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

		Scanner scan = new Scanner(System.in);
		int comWordIndex = (int) (Math.random() * wordList.size());
		ArrayList<Integer> already = new ArrayList<>();
		already.add(-1);

		while (true) {
			String comWord = wordList.get(comWordIndex);
			already.add(comWordIndex);
			System.out.println("제시어 : " + comWord);
			System.out.print(">>> ");
			String answer = scan.nextLine();

			if (!wordList.contains(answer)) {
				System.out.println("컴퓨터 승리");
				break;
			}

			if (!answer.substring(0, 1).equals(comWord.substring(comWord.length() - 1, comWord.length()))) {
				System.out.println("컴퓨터 승리");
				break;
			}

			int answerIndex = -1;

			for (int i = 0; i < wordList.size(); i++) {
				if (answer.equals(wordList.get(i))) {
					answerIndex = i;
				}
			}

			if (already.contains(answerIndex)) {
				System.out.println("컴퓨터 승리");
				break;
			}

			already.add(answerIndex);
			ArrayList<Integer> availableWordIndex = new ArrayList<>();
			for (int i = 0; i < wordList.size(); i++) {
				if (wordList.get(i).substring(0, 1).equals(answer.substring(answer.length() - 1, answer.length()))) {
					availableWordIndex.add(i);
				}
			}

			if (availableWordIndex.isEmpty()) {
				System.out.println("사용자 승리");
				break;
			} else {
				int nextWordIndex = -1;
				while (already.contains(nextWordIndex)) {
					int checkIndex = (int) (Math.random() * availableWordIndex.size());
					nextWordIndex = availableWordIndex.get(checkIndex);
				}
				comWordIndex = nextWordIndex;
			}
		}
		scan.close();
	}
}