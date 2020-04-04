package javaStu;

import java.util.Random;

public class Re02LottoProgram {	// 배열

	public static void main(String[] args) {
		
		Random rand = new Random();
										// Random객체에서 nextInt함수는 0포함해서 
		int[] lotto = new int[6];	// lotto라는 정수형 배열을 만들고, 6개의 정수가 들어갈 수 있도록
		
		// 로또 번호를 생성
		for (int i = 0; i < 6; i++) {
			// 0 <= n < 45이기 때문에 45개를 가지려면 +1 해줘야함 (나올 수 있는 최대 값은 45가 맞음)
			lotto[i] = rand.nextInt(45) + 1;
		}
		// 로또 번호를 출력
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		
		System.out.println("");
		
		/*
		// 0번째 값과 1번째 값의 자리를 변경
		int temp = lotto[0];	// 0번 값을 미리 다른 곳에 저장
		lotto[0] = lotto[1];	// 1번 값을 0번 값에 그냥 대입하면, 1번 값이 덮어씌어져서 사라지게됨
		lotto[1] = temp;	// 별도로 저장해두었던 0번 값을 다시 1번에 대입
		*/
		
		/*
		// 0번째 값이 1번째 값보다 크면 둘의 자리를 바꿔 출력
		if (lotto[1] < lotto[0]) {
			int temp = lotto[0];
			lotto[0] = lotto[1];
			lotto[1] = temp;
		}
		
		for (int i = 0; i <6; i++) {	// if문이 적용된 상태에서의 6자리 출력 (= 기존 6자리 출력과 비교)
			System.out.printf("%d ", lotto[i]);
		}
		
		System.out.println("");
		
		// 1번째 값이 2번째 값보다 크면 둘의 자리를 변경
		if (lotto[2] < lotto[1]) {
			int temp = lotto[1];
			lotto[1] = lotto[2];
			lotto[2] = temp;
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		*/
		
//		// 랜덤 값 6개가 나오는 로또 만들기 (로또 최대 값은 45)
//		Random rand = new Random();
		
		for (int a = 0; a < 5; a++) {	// 5번 검증하여, 5자리가 오름차순으로 정렬되도록
			for (int i = 0; i < 5; i++) {	// 5회를 한 번 돌때마다 옆으로 큰 수를 보냄
				
				if (lotto[i+1] < lotto[i]) {
					int temp = lotto[i];
					lotto[i] = lotto[i+1];
					lotto[i+1] = temp;
				}
			}
		}
		
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
		}
		
	}

}

