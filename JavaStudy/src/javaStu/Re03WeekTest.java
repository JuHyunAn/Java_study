package javaStu;

public class Re03WeekTest {

	public static void main(String[] args) {
		
		int[] num = new int[10];
		
		for (int i = 0; i < 10; i++) {
			num[i] += i;
			System.out.printf("num[%d] = %d\n", i, num[i]);
		}
		
//		for (int i = 0; i < 10; i++) {
//			System.out.printf("%d ", i + 1);	// 1 2 3 4 5 6 7 8 9 10 (i에 1만 더하면..1씩 늘어나는 숫자가 됨);
//		}
	}

}
