package ch09_class.common;

public class MyUtil {
	public static double myRound(double num, int n) {
		return Math.round(num * Math.pow(10, n)) / Math.pow(10, n);
	}
}