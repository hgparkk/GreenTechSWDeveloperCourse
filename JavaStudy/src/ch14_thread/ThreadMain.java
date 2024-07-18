package ch14_thread;

public class ThreadMain {
	public static void printNum(int n) {
		for (int i = n; i <= n + 5; i++) {
			System.out.println(i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		MyThread myThread1 = new MyThread(40);

		myThread1.start();

		MyThread myThread2 = new MyThread(50);
		myThread2.start();

		System.out.println("메인쓰레드 종료");
		
		Thread myThread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				printNum(80);
			}
		});
		
		myThread3.start();
		
		Thread myThread4 = new Thread(()-> printNum(100));
		
		myThread4.start();
	}
}