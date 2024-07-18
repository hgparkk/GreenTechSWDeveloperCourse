package ch13_exception;

public class ExQuiz {
	public static void main(String[] args) {
		try {
			test(null);
			System.out.println("B");
		} catch (BizException e) {
			System.out.println("C");
		} catch (Exception e) {
			System.out.println("D");
		} finally {
			System.out.println("E");
		}
		System.out.println("F");
	}

	public static void test(String word) throws BizException {
		if (word.length() == 0) {
			throw new BizException();
		}
		System.out.println("A");
	}
}