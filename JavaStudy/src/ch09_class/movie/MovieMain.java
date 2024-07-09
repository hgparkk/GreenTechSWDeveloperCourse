package ch09_class.movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MovieMain {
	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<>();

		Movie veteran = new Movie("베테랑", "어이가 없네","ㅂㅌㄹ");

		movieList.add(veteran);
		movieList.add(new Movie("신세계", "거 죽기 딱 좋은 날씨네","ㅅㅅㄱ"));

		veteran.goat = "나 여기 아트박스 사장인데";

		System.out.println(movieList.get(0));

		movieList.add(new Movie("명량", "신에게는 아직 12척의 배가 있습니다.","ㅁㄹ"));
		movieList.add(new Movie("범죄도시", "어 아직 싱글이야","ㅂㅈㄷㅅ"));
		movieList.add(new Movie("내부자들", "모히또가서 몰디브나 한 잔 할라니까","ㄴㅂㅈㄷ"));
		movieList.add(new Movie("타짜", "예림이 그 패 봐봐","ㅌㅉ"));
		movieList.add(new Movie("범죄와의전쟁", "느그 서장 남천동 살제?","ㅂㅈㅇㅇㅈㅈ"));
		movieList.add(new Movie("기생충", "넌 다 계획이 있구나","ㄱㅅㅊ"));
		
		Collections.shuffle(movieList); //리스트 무작위로 섞기.

		Scanner scan = new Scanner(System.in);

		int count = 0;
		for (int i = 0; i < movieList.size(); i++) {
			System.out.println(movieList.get(i).goat);

			System.out.print(">>> ");
			String title = scan.nextLine();

			if (title.equals(movieList.get(i).title)) {
				System.out.println("정답!! +2점");
				count+=2;
				continue;
			}
			System.out.println("오답");
			System.out.println("힌트 : " + movieList.get(i).hint);
			System.out.print(">>> ");
			title = scan.nextLine();
			if (title.equals(movieList.get(i).title)) {
				System.out.println("정답!! +1점");
				count++;
				continue;
			}
			System.out.println("오답");
		}

		System.out.println(count + "점 획득!!");
	}
}