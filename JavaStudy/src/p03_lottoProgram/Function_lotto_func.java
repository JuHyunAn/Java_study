package p03_lottoProgram;

import java.util.Random;
import java.util.Scanner;

public class Function_lotto_func {
	
	// 6자리 랜덤 로또 번호 생성기
	
	// 메뉴 함수
	public static int inputNum(int[] lotto) {
		Scanner scan = new Scanner(System.in);
		System.out.println("※ 로또 자동 생성 프로그램");
		System.out.println("<실행할 메뉴의 숫자를 입력하세요>");
		System.out.println("1. 로또 생성");
		System.out.println("2. 로또 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print(">> ");
		int selectNum = scan.nextInt();
		
		if (selectNum == 2) {	// 2번을 눌렀는데, 1번을 한번도 탄 적이 없었을 경우에는 다시 while문으로 돌아가도록
			if (lotto[0] == 0) {	// 배열의 경우, 값이 대입되지 않으면 0으로 초기화된다. 즉, 배열 값이 0인 경우에는 while문으로 되돌아가도록
				return 4;	// 4를 리턴받는 이유는, switch-case 구문에 없는 선택지를 넣어서 default로 처리되도록 하기 위해서이다.
			}
			
		}
		return selectNum;	// inputNum 함수는 최종적으로 유저가 입력한 정수형 번호를 저장(return 받고)하며 종료된다.
	}
	
	// 로또 생성 함수
	public static void genLotto(int[] lotto) {
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			lotto[i] = rand.nextInt(45) + 1;
		}
		System.out.println("◆◆◆ 로또 번호가 생성되었습니다.◆◆◆");
	}
	
	// 로또 정렬 함수
	public static void sortLotto(int[] lotto) {
		for (int i = 0; i < 5; i++) {
			for (int a = 0; a < 5; a++) {
				if (lotto[a] > lotto[a+1]) {
					int temp = lotto[a];
					lotto[a] = lotto[a+1];
					lotto[a+1] = temp;
				}
			}
		}
	}
	
	// 로또 출력 함수
	public static void printLotto(int[] lotto) {
		System.out.println("◆◆◆ 로또 번호를 출력합니다.◆◆◆");
		System.out.print(">> ");
		for (int i = 0; i < 6; i++) {
			System.out.printf("%d ", lotto[i]);
		}

	}

}
