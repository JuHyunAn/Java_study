package javaStu;

import java.util.Scanner;

public class Te09Study1 {

	public static void main(String[] args) {
		
		// 5. n개의 정수가 임의로 주어질 때 최대값과 최소값을 구하라.
		
		Scanner scan = new Scanner(System.in);
		
		// 배열의 크기를 입력할 변수
		System.out.println("생성할 배열의 크기를 입력하세요.");
		int num = scan.nextInt();
		
		int[] arrayNum = new int[num];	// 배열의 생성
		
		System.out.println("배열에 넣을 정수를 차례대로 입력하세요.");
		
		for (int i = 0; i < num; i++) {
			// ******** 중요! ******** //
			int number = scan.nextInt();	// number변수가 입력된 값을 읽어서 차례대로 담을 수 있도록 반복해줘야 함!
			arrayNum[i] = number;			// nextInt(); 자체가 1회 '실행'될 때 마다 다음 정수를 불러오는 것이기 때문에 입력한 값을 전부 불러오려면 그 만큼 계속 실행시켜줘야 함!
		}

		// 최소값을 왼쪽, 최대값을 오른쪽으로 이동시킴
		System.out.println("왼쪽에서 부터 최소값으로 정렬합니다.");
		for (int a = 0; a < num-1; a++) {		// 배열 보다 
			for (int i = 0; i < num-1; i++) {	// 배열 크기 만큼 검사하게 되면, 마지막 배열 값이 초과하게 되기 때문에 총 배열의 -1 만큼만 반복
				
				if (arrayNum[i] > arrayNum[i+1]) {
					int temp = arrayNum[i];
					arrayNum[i] = arrayNum[i+1];
					arrayNum[i+1] = temp;
				}
		
			}
		
		}

		for (int i = 0; i < num; i++) {
			System.out.printf("%d ", arrayNum[i]);
		}
		
		System.out.println();
		System.out.printf("최소값은 %d입니다.\n", arrayNum[0]);
		System.out.printf("최대값은 %d입니다.\n", arrayNum[num-1]);
		
		scan.close();
	}
	
}