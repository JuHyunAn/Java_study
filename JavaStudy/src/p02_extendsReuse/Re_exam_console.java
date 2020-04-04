package p02_extendsReuse;

import java.util.Scanner;

public class Re_exam_console {
	
	Re_exam_func exam = new Re_exam_func();
	
	public Re_exam_console() {
		this.exam = new Re_exam_func();
	}
	
	public Re_exam_console(Re_exam_func exam) {	// 매개변수로 exam을 받았으므로, main함수에서도 동일하게 받아야 한다.
		this.exam = exam;
	}
	
	// sub로 인터페이스 참조 & 호출
	private addable sub;
	
	// 인터페이스를 통해서 override 함수에 있는 신규 과목을 input할 것이기 때문에 set함수를 생성!
	public void setSub(addable sub) {
		this.sub = sub;
	}

	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.print("국어 성적 입력 :");
		this.exam.setKor(scan.nextInt());
		System.out.print("영어 성적 입력 :");
		this.exam.setEng(scan.nextInt());
		System.out.print("수학 성적 입력 :");
		this.exam.setMath(scan.nextInt());
		
		if (sub != null) {
			// addable 인터페이스에서 input의 매개변수로 Re_exam_func을 받고 있기 때문에 똑같이 this.exam을 받아야 한다.
			sub.input(this.exam);
		}
	}

	public void print() {
		System.out.printf("국어 성적 : %d\n", this.exam.getKor());
		System.out.printf("영어 성적 : %d\n", this.exam.getEng());
		System.out.printf("수학 성적 : %d\n", this.exam.getMath());
		System.out.printf("총점 : %d\n", this.exam.getTotal());
		System.out.printf("평균 : %d\n", this.exam.getAvg());
		
		if (sub != null) {
			// addable 인터페이스에서 input의 매개변수로 Re_exam_func을 받고 있기 때문에 똑같이 this.exam을 받아야 한다.
			sub.print(this.exam);
		}
	}
	
}