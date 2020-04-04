package javaStu;

import java.util.Scanner;

public class Te07Study4 {

	public static void main(String[] args) {
		
		// 문제) 임의의 수 n을 입력받아서 n까지 하나씩 출력하다가 다시 줄이면서 출력하기
		
		// 1. 수를 입력받을 버퍼 필요 할듯
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		int num = Integer.parseInt(str);
		
		// 2. 하나씩 늘려서 출력하는거 하나
		for (int i = 0; i < num; i++) {
			for (int a = 0; a <= i; a++) {
				System.out.print(a+1);
			}
			System.out.println();
		}
		
		// 하나씩 줄여서 출력하는거 하나 이렇게 하면 끝?
		for (int i = 0; i < num; i++) {
			for (int b = num; b > i; b--) {
				System.out.print(b);
			}
			System.out.println();
		}
		scan.close();
	}

}
