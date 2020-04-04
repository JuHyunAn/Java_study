package javaStu;

import java.util.Scanner;

public class Te08Study3 {

	public static void main(String[] args) {
		
		// 3. (왼쪽 정렬) 별을 하나씩 증가시켜 나가기
		for (int i = 0; i < 5; i++) {	// 첫 번째 반복에서 별 1개, 두 번째 반복에서 별 2개...
			
			for (int a = 0; a <= i; a++) {	// 별을 찍는 반복문
				System.out.print("★");
			}
			System.out.println();
		}
		
	}
	
}
