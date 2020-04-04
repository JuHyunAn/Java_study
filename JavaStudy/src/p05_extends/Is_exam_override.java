package p05_extends;

public class Is_exam_override extends Is_exam_func {	// override 클래스를 func 클래스에 상속 시킨다.

	// 3가지 과목 외 두 가지 과목을 추가...점수 할당/총합/평균을 진행하기 위해서는 main함수에 접근되어야 한다.
	
	// main 함수에 접근하는 방법!
	// 1. main함수에 접근이 필요한 클래스를 이미 접근되어 있는 클래스에 상속.
	// 2. main함수에 접근이 필요한 클래스를 직접 main함수에 참조시키고, 남은 클래스를 상속시킨다.
	
	private int subject4;
	private int subject5;
	
	public void setSubject4(int subject4) {
		this.subject4 = subject4;
	}
	public void setSubject5(int subject5) {
		this.subject5 = subject5;
	}
	public int getSubject4() {
		return this.subject4;
	}
	public int getSubject5() {
		return this.subject5;
	}
	
	// 총점과 평균에 추가된 두 과목도 반영되어야 한다!!
	// 오버라이드를 하기 위해서는 '오버라이드하고자 하는 변수를 가지고 있는 클래스(부모클래스)'에 상속되어야 한다!
	// 즉, total과 avg를 오버라이드 하기 위해 해당 변수들이 있는 Re_exam_func.java 클래스를 상속한다.
	
	@Override
	public int total() {
		// super.total()은 func.java 클래스에 있는 total
		return super.total() + this.subject4 + this.subject5;	// 기존 total식에 추가된 4, 5번 과목 점수를 추가
	}
	
	@Override
	public float avg() {
		// 평균의 경우, 오버라이드로 인해 total값이 새롭게 변경되었으므로, 변경된 total 값을 참조
		return (float)this.total() / 5;
	}
	
}
