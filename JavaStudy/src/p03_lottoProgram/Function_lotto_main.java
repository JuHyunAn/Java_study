package p03_lottoProgram;
// 캡슐화 : (구조화o, 함수화o, 객체지향화x, 비상속화x)
public class Function_lotto_main {
	
		// ※ 6자리 숫자를 출력하는 로또 프로그램
		// 1. 로또의 숫자는 랜덤으로 6자리를 갖음
		// 2. UI - 메뉴 중 1번 누르면 로또 배열 생성, 2번 누르면 출력, 3번 누르면 종료
		// 3. 로또 번호는 오른쪽에 큰 값이 가도록 정렬하여 출력된다.
		// 4. 예외 처리 (1번 안누르고 2번 바로 누르면 다시 되돌아 가도록)
	
	public static void main(String[] args) {	// top-down 방식
		
		// 실질적인 코드를 작성하지 않고 함수명과 일부 변수 명 등으로 윤곽만 잡아 나간뒤 후에 함수를 작성
		
		// 로또 배열 생성
		int[] lotto = new int[6];

		// 예외 처리를 위해 반복문 사용
		while (true) {
			
			// 버튼 입력하는 메뉴 생성
			int buttonNum = Function_lotto_func.inputNum(lotto);	// 메뉴 함수에서 예외 처리 까지 하도록 하자
			
			if (buttonNum == 3) {
				System.out.println("※ 프로그램을 종료합니다.");	// 종료 부분에 대한 예외처리 (아래 함수에서 별도로 처리가 힘듬...함수는 반복문이 아니기 때문에 break가 걸리지 않는다.)
				break;
			}
			
			// 메뉴 선택에 따른 기능 구현
			switch (buttonNum) {
			
			case 1:	// 로또 생성
				System.out.println();	// 띄어쓰기
				Function_lotto_func.genLotto(lotto);
				System.out.println();	// 띄어쓰기
				break;
				
			case 2:	// 로또 출력
				System.out.println();	// 띄어쓰기
				Function_lotto_func.sortLotto(lotto);// 출력 전에 정렬
				Function_lotto_func.printLotto(lotto);
				System.out.println();	// 띄어쓰기
				System.out.println();
				break;
			
			case 3:	// 프로그램 종료
				break;
			
			default:
				System.out.println();	// 띄어쓰기
				System.out.println("◆◆◆ 로또 번호를 먼저 생성해주세요! 메뉴로 되돌아 갑니다.◆◆◆ ");
				System.out.println();	// 띄어쓰기
				break;
			}

		}
		
	}

}
