package javaStu;

import java.util.Scanner;

public class Te05Study {

	public static void main(String[] args) {
		
		// 제어문
		// 1.) '안녕하세요' 개행해서 5번 출력 중 3번째만 '안녕못하는데요' 출력
		for (int i = 0; i < 5; i++) {
			
			if (i == 2) {
				System.out.println("안녕못하는데요?");
			}
			else {
				System.out.println("안녕하세요.");
			}
		}
		
		System.out.println("");
		
		// 2.1) 1, 2, 3, 4, 5를 개행해서 출력하기
		for (int i = 1; i <= 5; i++) {

			System.out.println(i);
		}
		
		System.out.println("");
		
		// 2.2) 짝수만 출력하기
		for (int i = 1; i <= 5; i++) {
			
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		System.out.println("");
		
		// 3.3) 홀수만 출력하기
		for (int i = 1; i <= 5; i++) {
			
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
		
		System.out.println("");
		
		// 3.1) 구구단 2단 출력하기 (2*1 2*2 2*3 ... 2*9)
		for (int i = 1; i <= 9; i++) {
			int a = 2;
			System.out.printf("%d x %d = %d\n", 2, i, a*i);
		}
		
		System.out.println("");

		// 3.2) 구구단 전체 출력하기
		for (int i = 1; i <= 9; i++) {
			for (int a = 1; a <= 9; a++) {
				System.out.printf("%d x %d = %d  ", i, a, i*a);
			}
			System.out.println();
		}
		
		System.out.println("");
		
		// 문자열
		// 4. "good day"를 콘솔창으로 입력 받은 뒤 그대로 출력하기
		System.out.println("출력하고자 하는 문자를 입력해주세요.");
		System.out.print("> ");
		
		Scanner scan = new Scanner (System.in); {
			String str;
			
			str = scan.nextLine();
			System.out.println(str);
		}
		
		System.out.println("");
		
		// 5.1 "good day"를 콘솔창으로 입력 받은 뒤 문자열 중 4번째 문자만 출력하기 = 'd'가 출력됨
		// 힌트!) charAt();
		System.out.println("문자를 입력하면, 4번째 위치의 문자만 반환합니다.");
		System.out.print("> ");
		
		Scanner scanTwo = new Scanner(System.in);
		String strTwo;
		
		strTwo = scanTwo.nextLine();
		
		for (int i = 0; i < strTwo.length(); i++) {	// 입력 문자 길이의 인덱스 길이 만큼 반복해서 조건 검사
			
			if (i == 3)	{	// 2번째 문자 = index[1]
				System.out.println(strTwo.charAt(i));
				break;	// if문이 실행되면, 종료 (실행되는 순간 원하는 값을 출력하기 때문에..종료되도 문제 없음)
			}
			scanTwo.close();
			scan.close();
		}
			
	}

}
