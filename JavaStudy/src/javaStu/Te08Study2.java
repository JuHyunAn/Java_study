package javaStu;

import java.util.Scanner;

public class Te08Study2 {

	public static void main(String[] args) {
		
		// 2. 알파벳 소문자, 대문자, 숫자 0 ~ 9중 하나를 입력했을 때, 주어진 글자의 아스키 코드 값을 출력하는 프로그램을 작성하시오.

		System.out.println("아스키 코드로 변환할 문자열을 입력하세요.");
		Scanner scan = new Scanner(System.in);
		
		char str = scan.nextLine().charAt(0);
		int strNum = (int)str;	// 입력한 문자의 정수 번호(아스키 번호)를 찾음
		
		System.out.println(strNum);
	}
	
}
