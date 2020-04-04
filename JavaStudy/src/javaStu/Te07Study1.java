package javaStu;

import java.util.Scanner;

public class Te07Study1 {

	public static void main(String[] args) {
		
		// 임의의 수 n을 입력하면 그 만큼의 배열 크기를 생성하고, 값을 입력하면 역순으로 출력되는 프로그램
		
		System.out.println("배열의 크기를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int inputNum = scan.nextInt();
		
		System.out.println("역순으로 출력할 값을 입력하세요.");
		String[] numbers = new String[inputNum];

		for (int i = 0; i < inputNum; i++) {
			String str = scan.next();	// numbers 배열에 넣을 다음 str 값을 순차적으로 읽어 줘야하기 때문에 for문 안에 있어야 함!
			numbers[i] = str;
		}
		
		for (int i = inputNum -1; i >= 0; i--) {	// 역순으로 출력해야 하기 때문에 초기 값을 최대 인덱스 값으로 잡음
			System.out.printf("%s ", numbers[i]);
		}
		scan.close();
	}

}