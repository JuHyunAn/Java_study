package javaStu;

import java.util.Scanner;

public class Te07Study2 {

	public static void main(String[] args) {

		// 임의의 정수가 입력되었을때, 
		// 1. 양수/음수 검사하여 출력
		// 2. 짝수/홀수 검사하여 출력
		// 3. 0도 양수로 인식한다.
		
		Scanner scan = new Scanner(System.in);
		String str;
		
		str = scan.next();
		int num = Integer.parseInt(str);
		
		if (num < 0) {
			System.out.println("minus");	// 음수
		}
		else {
			System.out.println("plus");	// 양수
		}
		
		if (num % 2 == 0) {
			System.out.println("even");	// 짝수
		}
		else {
			System.out.println("odd");	// 홀수
		}
		scan.close();
	}
}