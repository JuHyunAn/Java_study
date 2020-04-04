package p04_examProgram2;

import java.util.Scanner;

public class Exam_console {
	
	// input하고 print는 console에서 관리하고 싶다.
	
	// 입력
	public void input(Exam_func exam, String[] names) {	// input의 매개변수로 func을 참조한다.
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.printf("※ %d번째 학생의 이름을 입력하여 주십시요.\n", i+1);
			System.out.print("이름 : ");
			names[i] = scan.next();
			System.out.println();
			System.out.printf("※ %s 학생의 성적을 입력해주세요.\n", names[i]);
			System.out.print("과목 1 : ");
			exam.getExams()[i].setSubject1(scan.nextInt());	// private변수에 접근하기 위해 setter사용
			System.out.print("과목 2 : ");
			exam.getExams()[i].setSubject2(scan.nextInt());
			System.out.print("과목 3 : ");
			exam.getExams()[i].setSubject3(scan.nextInt());
			System.out.println();
		}
	
	}
	
	// 출력
	public void print(Exam_func exam, String[] names) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i++) {
			System.out.printf("※ %s 학생의 성적입니다.\n", names[i]);
			System.out.printf("> 과목1 : %d점, 과목2 : %d점, 과목3 : %d점, 총합 : %d, 평균 : %f\n", 
					exam.getExams()[i].getSubject1(), exam.getExams()[i].getSubject2(), exam.getExams()[i].getSubject3(),
					exam.getExams()[i].getTotal(), exam.getExams()[i].getAvg());
		}
		System.out.println();
		System.out.println("※ 과목별 평균 점수 입니다.");
	}
	
}
