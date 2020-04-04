package p04_examProgram2;

import java.util.Scanner;

public class Exam_main {

	public static void main(String[] args) {
		
		Exam_func exam = new Exam_func();
		Exam_console console = new Exam_console();
		
		for (int i = 0; i < 3; i++) {	// new 연산자를 통해 생성자의 배열을 활성화!
			exam.getExams()[i] = new Exam_func();
		}
		
		Scanner scan = new Scanner(System.in);
		String[] names = new String[3];
		
		int count = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("<< 성적 산출 프로그램 (3개 과목) >>");
			System.out.println("※ 원하는 메뉴를 선택해주세요.");
			System.out.println("1. 성적 입력");
			System.out.println("2. 성적 산출");
			System.out.println("3. 프로그램 종료");
			System.out.print("> ");
			int number = scan.nextInt();
			System.out.println();
			
			if (number == 2) {
				if (count == 0) {
					System.out.println("입력된 성적이 없습니다!");
					continue;
				}
			}
			
			System.out.println();
			
			switch (number) {
			
			case Exam_func.score_input:
				count++;
				console.input(exam, names);
				break;
			
			case Exam_func.score_print:
				exam.studentScore();
				exam.subjectTotal();
				exam.subjectAvg();
				
				// 학생별 성적 출력
				console.print(exam, names);
				break;
				
			case Exam_func.program_end:
				System.out.println("※ 프로그램을 종료합니다.");
				System.out.println();
				loop = false;
				break;
			}
	
		}
	
	}
	
}
