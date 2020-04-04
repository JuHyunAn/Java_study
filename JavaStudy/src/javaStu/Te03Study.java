package javaStu;

public class Te03Study {

	public static void main(String[] args) {

		// 1/2 + 2/3 + 3/4 + ... + 9/10 의 합 구하기
		
//		연산을 논리적으로 구성해 나가는 단계 연습!
//		0. 나누기 값을 더하는 것 (= 나누기 값은 최대 소수점이 나오기 문에 실수로 사용)
//		1. 분모가 분자보다 +1 크기 (= 분자를 기준으로 +1 하면 될듯)
//		2. 분자의 최대 범위는 9
//		3. 모든 값들의 합을 담을 변수 필요
//		4. 분모, 분자 모두 계속 증가시켜주는 방법을 사용한다면, 반복문을 이용하는게 간편
//		5. while, for문 모두 사용 가능
		
		
		// while문 사용
		double total = 0;	// 나누기 값을 누적해서 합해 갈 변수
		int div = 1;	// 첫 나누기에서 분자의 시작점
		
		while (div < 10) {
			total += (double)div / (div + 1);
			div++;
		}
		System.out.println(total); // 7.071031746031746

		
		System.out.println("");	// 띄어쓰기
		
		
		// for문 사용
		double total2 = 0;
		
		for (int div2 = 1; div2 < 10; div2++) {
			total2 += (double)div2 / (div2 + 1);
		}
		System.out.println(total2);	// 7.071031746031746
	}

}
