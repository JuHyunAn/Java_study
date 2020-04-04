package javaStu;

import java.util.Scanner;

public class Te07Study5 {

	public static void main(String[] args) {
		
		// 문제) 임의의 수 n을 입력받고, 문자열 입력 시 n번 출력 (프로그램은 q, Q를 입력했을때 종료)
		
		// 1. 임의의 수 n을 입력받도록
		// 2. 문자열 입력 받도록
		// 3. 문자열 입력 시 한줄에 n번 나오도록 반복
		// 4. q, Q 입력 시 종료, 아니면 계속 입력 대기되도록?
		
		System.out.println("반복할 횟수를 입력하세요.");
		
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		
		System.out.println("");
		
		System.out.println("반복할 문자를 입력하세요");
		
		String str;
		
		while(true) {	// q, Q를 입력해야만 종료되어야 되기 때문에, 계속해서 입력을 반복 시켜야 한다.
			System.out.print("> ");		
			
			str = scan.next();
														// 문자형을 비교 연산을 통해 구별 하고자 할 때에는 "equals()"함수를 사용해야 한다.
			if (str.equals("q") || str.equals("Q")) {	// 문자열에 직접 비교 연산을 사용하는 것은 의미가 없다.
				System.out.println("프로그램을 종료합니다.");	// 이유는, 실제로 해당 문자와 비교하는 것이 아니라,
				break;									// 문자가 저장된 메모리의 '리터럴 주소'와 비교를 하게 되기 때문!!
			}
			
			for (int i = 0; i < num; i++) {
					System.out.print(str);
				}
			System.out.println("");
		}
		scan.close();
	}
	
}
