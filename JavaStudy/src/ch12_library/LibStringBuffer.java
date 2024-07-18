package ch12_library;

public class LibStringBuffer {
	public static void main(String[] args) {
		String number = "";
		
		long startTimeLong = System.currentTimeMillis();
		for(int i= 0;i<500000;i++) {
			number += (int)(Math.random()*10);
			
			if(i%100000 == 0) {
				System.out.println(i);
			}
		}
		long endTimeLong = System.currentTimeMillis();
		
		System.out.println((double)((endTimeLong-startTimeLong)/1000.0) + " 초 소요");
		
		StringBuffer strBuff = new StringBuffer(); // 동기화를 지원함 (멀티 쓰레드 환경에서 해당 객체가 모든 쓰레드에 대해 안정적으로 사용된다.)
		
		startTimeLong = System.currentTimeMillis();
		for(int i= 0;i<100000000;i++) {
			strBuff.append((int)(Math.random()*10));
			
			if(i%100000 == 0) {
				System.out.println(i);
			}
		}
		endTimeLong = System.currentTimeMillis();
		
		System.out.println((double)((endTimeLong-startTimeLong)/1000.0) + " 초 소요");
		
		StringBuilder strBuild = new StringBuilder(); // 동기화를 지원하지 않음
		
		startTimeLong = System.currentTimeMillis();
		for(int i= 0;i<100000000;i++) {
			strBuild.append((int)(Math.random()*10));
			
			if(i%100000 == 0) {
				System.out.println(i);
			}
		}
		endTimeLong = System.currentTimeMillis();
		
		System.out.println((double)((endTimeLong-startTimeLong)/1000.0) + " 초 소요");
	}
}