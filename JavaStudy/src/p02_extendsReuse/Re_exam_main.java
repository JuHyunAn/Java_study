package p02_extendsReuse;

import java.util.Scanner;

//객체 지향스러운 캡슐
public class Re_exam_main {

	public static void main(String[] args) {
		
//		Re_exam_func exam = new Re_exam_func();
		
		//********************************* 중요!! *********************************//
		//							 											   //
		// "추가되는 데이터"를 입력하기 위해서는 당연히 해당 데이터가 있는 클래스가 필요하기 때문에 override 클래스를 참조!!, 
		// func 클래스는 삭제 (why? 이미 자식 클래스인 override가 부모 클래스인 func의 모든 기능을 물려 받고 있기 때문에 중복됨)
		Re_exam_override exam = new Re_exam_override();
		//							 											   //
		//*************************************************************************//
		
		int total = exam.total();
		float avg = exam.avg();
		
		Re_exam_console console = new Re_exam_console(exam);
		
		// 콘솔에 있는 인터페이스 set함수를 참조, set함수의 매개변수로 인터페이스 클래스를 받는다.
		// 인터페이스 클래스 자체에 input과 print가 있으므로, 신규 과목을 오버라이드 하기 위해서 사용
		console.setSub(new addable() {
			
			// 추가하고자 하는 데이터를  자식 클래스(override)가 가지고 있기 때문에 부모 클래스(func)를 형변환한다.
			// 추가하고자 하는 데이터에 접근하기 위해 override 클래스를 참조!
			
			@Override
			public void input(Re_exam_func exam) {	// concole - input함수에 내용 추가
				Re_exam_override examOr = (Re_exam_override) exam;	// 변수 exam이 func 클래스의 참조변수이기 때문에 input 함수의 매개변수로 func 클래스를 받는다!
				// TODO Auto-generated method stub
				Scanner scan = new Scanner(System.in);
				System.out.print("사회 성적 입력 :");
				examOr.setSubject4(scan.nextInt());
				System.out.print("과학 성적 입력 :");
				examOr.setSubject5(scan.nextInt());
				
			}

			@Override
			public void print(Re_exam_func exam) {	// console - print함수에 내용 추가
				// TODO Auto-generated method stub
				Re_exam_override examOr = (Re_exam_override) exam;	// 변수 exam이 func 클래스의 참조변수이기 때문에 print 함수의 매개변수로 func 클래스를 받는다!
				System.out.printf("사회 성적 : %d\n", examOr.getSubject4());
				System.out.printf("과학 성적 : %d\n", examOr.getSubject5());
			}
			
		});
		
		console.input();
		
		console.print();
	}
	
}
