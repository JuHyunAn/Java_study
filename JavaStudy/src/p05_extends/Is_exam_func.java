package p05_extends;

public class Is_exam_func {
	
	// 3과목의 점수와 총합, 평균을 구함
	private int subject1;
	private int subject2;
	private int subject3;
	private int total;
	private float avg;

	// setter값 호출
	public void setSubject1(int subject1) {
		this.subject1 = subject1;
	}
	public void setSubject2(int subject2) {
		this.subject2 = subject2;
	}
	public void setSubject3(int subject3) {
		this.subject3 = subject3;
	}
	
	// 총합
	public int total() {
		return this.subject1 + this.subject2 + this.subject3;
	}
	
	// 평균
	public float avg() {
		return (float)this.total / 3;
	}
	public int getSubject1() {
		return this.subject1;
	}
	public int getSubject2() {
		return this.subject2;
	}
	public int getSubject3() {
		return this.subject3;
	}
	
}
