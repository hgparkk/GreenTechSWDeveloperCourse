package ch09_class.school;

import ch09_class.common.MyUtil;

public class Student {
	private String name;
	private int kor;
	private int eng;
	private int math;
	private double avg;

	public Student() {
	}

	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		calAvg();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return this.kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
		calAvg();
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
		calAvg();
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
		calAvg();
	}

	public double getAvg() {
		return this.avg;
	}
	
	private void calAvg() {
		this.avg = (kor + eng + math) / 3.0;
		this.avg=MyUtil.myRound(avg, 2);
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", avg=" + avg + "]";
	}
}
