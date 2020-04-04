package p03_lottoProgram;
//캡슐화 : (구조화o, 함수화o, 객체지향화o, 비상속화o, 상수화o)
import java.util.Scanner;

public class lotto_program {
	
	public static void main (String[] args) {
		
		//로또 프로그램
		// 0. 6자지 로또 생성
		// 1. 메뉴 (1번 - 로또 번호 생성, 2번 - 로또 번호 정렬로 출력, 3번 - 프로그램 종료)
		// 2. 기능 구현 (사용자가 해당 번호를 누르면 그에 맞는 기능이 실행)
		// 3. 코드 캡슐화
		
		lotto_program_func lotto = new lotto_program_func();	// 제일 먼저 해야함! (다른 클래스를 참조하겠다는 선언)
		
		Scanner scan = new Scanner(System.in);
		
		// 변수명 상수화
		final int gen_auto_lotto = 1;
		final int gen_manual_lotto = 2;
		final int print_lotto = 3;
		final int end_program = 4;
		
		boolean loop = true;	// while 반복문 제어용
		int count = 0;	// 예외 처리용

		while (loop) {
			System.out.println();
			System.out.println("<< 로또 생성 프로그램 >>");
			System.out.println("[원하는 번호를 눌러주세요.]");
			System.out.println("1. 로또 번호 자동 생성");
			System.out.println("2. 로또 번호 수동 입력");
			System.out.println("3. 로또 번호 출력");
			System.out.println("4. 프로그램 종료");
			System.out.print("> ");
			int number = scan.nextInt();
		
			
			///////////////////////////////////////// 예외 처리 부분 ///////////////
			if (number == 3) {
				if (count == 0) {
					System.out.println("!!생성된 로또 번호가 없습니다. 다시 돌아갑니다.!!");
					continue;
				}
			}
			if (number == 1 || number == 2) {
				if (count >= 1) {
					System.out.println("!!이미 생성된 번호가 있습니다. 먼저 출력하세요!!");
					continue;
				}
			}
			///////////////////////////////////////// 예외 처리 부분 ///////////////
			
			
			switch (number) {
			
			case gen_auto_lotto:	// 로또 자동 생성
				System.out.println("※ 자동 번호가 생성되었습니다.※");
				lotto.generate();
				count++;
				break;
				
			case gen_manual_lotto:	// 로또 수동 입력
				System.out.println("※ 번호를 직접 입력해주세요.※ ");
				for (int i = 0; i < 6; i++) {
					int input_number = scan.nextInt();
					lotto.getLotto()[i] = input_number;
				}
				count++;
				break;
			
			case print_lotto:	// 로또 정렬 & 출력
				System.out.println("번호 정렬중...");
				lotto.sort();
				
				lotto.delay(); // 2초 카운트 후에 출력되도록 타이머 설정
				
				System.out.println("※ 로또 번호를 출력합니다.※");
				for (int i = 0; i < 6; i++) {
//					int[] nums = lotto.getLotto()	// 새로 변수를 설정하여 보기 편하도록 할 수도 있지만..선택
					System.out.printf("%d ", lotto.getLotto()[i]);
				}
				count = 0;	// 출력과 함께 카운트를 초기화
				System.out.println();
				break;
				
			case end_program:	// 프로그램 종료
				System.out.println("※ 프로그램을 종료합니다.※");
				loop = false;
				break;
				
			default:
				System.out.println("!!유효한 번호를 입력해주세요!!");
				break;
			}
		
		}
		scan.close();
	}
	// 참조 클래스  : OOPstruct__lotto_program_func.java
}
