package javaStu;

import java.util.Scanner;

public class Te09Study3 {

	public static void main(String[] args) throws Exception {
		
		// 3. 세 개의 자연수 A, B, C가 주어질 때, A x B x C의 결과에 각 자리의 숫자가 몇 번씩 쓰였는지 구하라.
		
		// 자연수를 입력할 수 있도록
		Scanner scan = new Scanner(System.in);
		System.out.println("배열 크기를 입력하세요.");
		System.out.print("> ");
		int num = scan.nextInt();
		
		// 배열 생성
		int[] arrayNum = new int[num];
		
		// 배열에 수 넣어서 사용할 수 있도록
		System.out.println("자연수를 입력하세요.");
		System.out.print("> ");
		
		int multi = 1;
		for (int i = 0; i < num; i++) {
			int inputNum = scan.nextInt();
			arrayNum[i] = inputNum;
			multi *= arrayNum[i];
		}
		System.out.printf("입력된 자연수를 모두 곱한 값은 %d입니다.\n", multi);
		
		String multiNum = Integer.toString(multi);
		
//		charAt으로 인덱스 별 문자를 비교하려고 했더니...a는 int형이라서 비교 불가!
//		결국, 비교 가능한 아스키코드로 변환해서 비교하기로!
//		char형으로 변경하여, 숫자 0 ~ 9가 아스키코드로 48 ~ 57인 점을 활용하였다..만 누적해서 프린트 하질 못했다.
		
		for (int a = 48; a <= 57; a++) {
			for (int i = 0; i < multiNum.length(); i++) {
				if ((char)a == multiNum.charAt(i)) {
					int count = 0;
					count++;
					System.out.printf("숫자 %c는 %d번 사용\n", (char)a, count);
				}

			}
			scan.close();
		}

	}
	
}