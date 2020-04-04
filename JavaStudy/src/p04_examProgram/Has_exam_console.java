package p04_examProgram;

import java.util.Scanner;
// 메인 함수에서 인터페이스(입출력)를 담당하는 클래스 (= 입출력 데이터를 가져옴)
public class Has_exam_console {
	
	// console 클래스가 다른 클래스를 참조하고 있다. (다른 부품을 가지고 있다!! = 상속받게 된다! = has 상속을 받는다.)
	private Has_exam_func exam;
	
	public Has_exam_console() {
		this.exam = new Has_exam_func();
	}
	
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("국어 성적 입력 :");
		this.exam.setKor(scan.nextInt());	// kor에 입력한 값을 넣어주도록 set해준다.
		System.out.println("영어 성적 입력 :");
		this.exam.setEng(scan.nextInt());
		System.out.println("수학 성적 입력 :");
		this.exam.setMath(scan.nextInt());
		
	}

	public void print() {
		System.out.printf("국어 성적 : %d\n", this.exam.getKor());
		System.out.printf("영어 성적 : %d\n", this.exam.getEng());
		System.out.printf("수학 성적 : %d\n", this.exam.getMath());
	}
	
}

// 종속성을 없애기 위해  main 함수로 빼둔 콘솔 입출력을 다시 신규 캡슐화 하는 이유는, 아까우니까! 재사용을 위해서