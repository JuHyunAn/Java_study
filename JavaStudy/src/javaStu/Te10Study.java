package javaStu;
import java.util.Scanner;

public class Te10Study {

	public static void main(String[] args) {
		
		// 1. 양의 정수 10개를 입력 받고 정수 n(1 ~ 9까지)를 입력하면, 입력한 10개의 정수 중 정수 n의 배수만 골라서 출력  
		Scanner scan = new Scanner(System.in);
		System.out.println("자연수 10개를 입력하세요.");
		System.out.print("> ");
		
		int[] nums = new int[10];
		for (int i = 0; i < 10; i++) {
			int num = scan.nextInt();
			nums[i] = num;
		}

		System.out.println("배수를 표시할 자연수를 입력하세요 (2 ~ 9사이)");
		
		while(true) {
			System.out.print("> ");
			int num2 = scan.nextInt();
			System.out.printf("%d의 배수 : ", num2);
			
			if (num2 == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			else if (num2 < 2 || num2 > 9) {
				System.out.println("2에서 9사이의 값을 입력해주세요!");
				continue;
			}
			
			for (int i = 0; i < 10; i++) {
				if (nums[i] % num2 == 0) {
					System.out.printf("%d ", nums[i]);
					continue;
				}
			}
			System.out.println();
		}
	
	}

}
