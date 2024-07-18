package ch14_thread;

public class MyThread extends Thread {

	private int start;

	public MyThread() {
	}

	public MyThread(int start) {
		this.start = start;
	}

	@Override
	public void run() {
		for (int i = start; i <= start + 5; i++) {
			System.out.println(i);

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}