package javaStu;

public class Te01Study {

	public static void main(String[] args) {
		
		// 1 ~ 100 까지의 정수 중 짝수 값들의 합을 출력하는 프로그램을 만들어라
		
		int x;	// 1 ~ 100 까지의 정수를 담을 변수
		int total = 0;	// 짝수들의 합을 담을 변수
		
		/*
		while (x <= 100) {

			if (x % 2 == 0) {
				total += x;
			}
			x++;
		}
		System.out.println(total);	// while문이 전체 종료된 다음에 total값을 구한다!!
		*/
		
		for (x = 1; x <= 100; x++) {
			
			if (x % 2 == 0) {
				total += x;
			}
			
		}
		System.out.println(total);	// for문이 전체 종료된 다음 total값을 구한다!!
	}

}
