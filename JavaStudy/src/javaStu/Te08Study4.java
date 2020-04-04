package javaStu;

import java.util.Scanner;

public class Te08Study4 {

	public static void main(String[] args) {
		
		// 4. 임의의 문자열을 입력 받아 역순으로 출력하기
		
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		for (int i = str.length()-1; i >= 0; i--) {
			
			System.out.print(str.charAt(i));
		}
		scan.close();
	}
	
}