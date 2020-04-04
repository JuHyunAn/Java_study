package p01_calcProgram;

import java.util.Scanner;

public class Calc_main {

	public static void main(String[] args) {
		
		Calc_func calc = new Calc_func();
		Calc_number number = new Calc_number();
		
		Scanner scan = new Scanner(System.in);
		
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("<<계산기 프로그램>>");
			System.out.println("기능 사용");
			System.out.println("1. 덧셈");
			System.out.println("2. 뺄셈");
			System.out.println("3. 곱셈");
			System.out.println("4. 나눗셈");
			System.out.println("5. 프로그램 종료");
			int selectNum = scan.nextInt();
			
			switch(selectNum) {
			
			// final 변수를 참조해올때에는 해당 변수가 있는 '클래스명'으로 참조해와야 한다! (= 기존 함수 참조 방법이랑 동일!)
			case Calc_number.PLUS:
				// 더하기 연산
				System.out.println("더할 두 수를 차례대로 입력하세요.");
				number.setNum1(scan.nextInt());
				number.setNum2(scan.nextInt());
				System.out.printf("※ 결과 : %d \n", calc.plus(number.num1, number.num2));
				break;
			
			case Calc_number.MINUS:
				System.out.println("빼기를 진행할 두 수를 차례대로 입력하세요.");
				number.setNum1(scan.nextInt());
				number.setNum2(scan.nextInt());
				System.out.printf("※ 결과 : %d \n", calc.minus(number.num1, number.num2));
				break;
				
			case Calc_number.MULTI:
				System.out.println("곱할 두 수를 차례대로 입력하세요.");
				number.setNum1(scan.nextInt());
				number.setNum2(scan.nextInt());
				System.out.printf("※ 결과 : %d \n", calc.multi(number.num1, number.num2));
				break;
				
			case Calc_number.DIVIDE:
				System.out.println("나누기를 진행할 두 수를 차례대로 입력하세요.");
				number.setNum1(scan.nextInt());
				number.setNum2(scan.nextInt());
				System.out.printf("※ 결과 : %f \n", calc.divide(number.num1, number.num2));
				break;
				
			case Calc_number.ENDCALC:
				System.out.println("프로그램을 종료합니다.");
				loop = false;
				break;
			
			default:
				System.out.println("사용할 기능을 다시 입력해주세요.");
				break;
			}
		
		}
		
	}

}
