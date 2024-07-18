package ch14_thread;

public class MakeString {
	public static void main(String[] args) {
		StringBuffer strBuff = new StringBuffer();
		
		StringBuilder strBuild = new StringBuilder();

		Thread threadB = new Thread(() -> {
			for (int i = 0; i < 50000000; i++) {
				strBuild.append("0");
			}
			System.out.println(strBuild.length());
		});

		Thread threadC = new Thread(() -> {
			for (int i = 0; i < 50000000; i++) {
				strBuild.append("0");
			}
			System.out.println(strBuild.length());
		});

		threadB.start();
		threadC.start();
	}
}