package javaStu;

public class Te02Study {

	public static void main(String[] args) {

		// 1 부터 10까지 곱하기

		
		// while문 사용
		int x = 1; // 1 ~ 10까지의 정수를 받을 변수
		
		// 곱셈의 경우, 0을 받으면 값이 초기화 되기 때문에 기본값을 1로 둔다.
		int mult = 1; // 곱한 값을 받을 변수

		while (x <= 10) {
			mult *= x;
			x++;
		}
		System.out.println(mult); // 3628800
		
		
		System.out.println("");	// 띄어쓰기
		
		
		// for문 사용
		int mult2 = 1;
		
		for (int x2 = 1; x2 <= 10; x2++) {
			
			mult2 *= x2;
		}
		System.out.println(mult2);	// 3628800
	}

}
