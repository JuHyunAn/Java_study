package javaStu;

import java.util.Scanner;

public class Te09Study2 {

	public static void main(String[] args) {
		
		// 2. 9개의 서로 다른 자연수가 주어졌을 때 이들 중 최소값과 최대값을 찾고 그 최대값이 몇 번째 수인지 구하라.
		
		// 크기가 9인 배열을 생성
		int[] arrayNum = new int[9];
		
		// 9개의 자연수를 입력할 수 있도록 ~
		System.out.println("9개의 자연수를 입력하세요.");
		Scanner scan = new Scanner (System.in);
		
		// 입력한 수가 배열에 들어갈 수 있도록 반복해서 읽은 다음 넣어주자!
		for (int i = 0; i < 9; i++) {
			int num = scan.nextInt();
			arrayNum[i] = num;
		}
		
		// 배열에 넣은 값 중 맨 왼쪽에 최소값을 기준으로 정렬되도록
		for (int a = 0; a < 8; a++) {
			for (int i = 0; i < 8; i++) {
				if (arrayNum[i] > arrayNum[i+1]) {
					int temp = arrayNum[i];
					arrayNum[i] = arrayNum[i+1];
					arrayNum[i+1] = temp;
				}
		
			}

		}
		scan.close();
		
		System.out.println("정렬된 값을 출력합니다.");
		for (int i = 0; i < 9; i++) {
			System.out.printf("%d ", arrayNum[i]);
		}
		System.out.println();
		System.out.printf("최대값은 %d이고, %d번째 위치한 값입니다.\n", arrayNum[8], 8);
	}
	
}