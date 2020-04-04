package javaStu;

import java.util.Scanner;

public class Re06SwitchProgram {

	public static void main(String[] args) {
		
		System.out.println("20 * 20 오목판");
		
		/*
		어떤 바둑판 크기를 원하십니까?
		1. (20 * 20)
		2. (40 * 20)
		3. (60 * 30)
		> ... 
		*/
		
		int width = 0;	// 너비
		int height = 0;	// 높이

		int ox = 0;
		int oy = 0;
		
		Scanner scan = new Scanner(System.in);	// 콘솔에 입력을 받아야 하기 때문에 Scanner 함수 생성
		String size;
		String oxdot;
		String oydot;
		
		int num;
		while (true) {
			// 바둑판 선택 인터페이스
			System.out.println("어떤 바둑판 크기를 원하십니까?");
			System.out.println("1. (20 * 20)");
			System.out.println("2. (40 * 20)");
			System.out.println("3. (60 * 30)");
			System.out.print("> ");
			
			size = scan.nextLine();
			num = Integer.parseInt(size);
			
			if (num < 1 || num > 3) {
				System.out.println("알맞은 번호를 입력해주십시요.");
			}
			else {
				break;
			}
		}
		
		switch (num) {	// switch문에서 바둑판 크기가 입력되기 때문에 해당 구문을 사용하지 않는다면, 바둑판이 출력되지 않음!!!
		
		case 1:
			width = 20;
			height = 20;
			System.out.println("1번을 입력하였습니다.");
			break;
			
		case 2:
			width = 40;
			height = 20;
			System.out.println("2번을 입력하였습니다.");
			break;
			
		case 3:
			// width = 20;
			// height = 20;
			System.out.println("3번을 입력하였습니다.");
			// break;
			
		default:
			width = 60;
			height = 30;
			// System.out.println("입력하지 않았습니다.");
		}
		
		while (true) {
			// 바둑 위치 입력 인터페이스
			System.out.println("바둑알을 둘 x, y 좌표를 입력해주세요");
			System.out.print("x sp y ");
			System.out.print("= ");
			
			oxdot = scan.next();
			ox = Integer.parseInt(oxdot);
			
			if (ox == -1) {	// ox가 -1일때 종료되는 것이 아니라, 다시 처음으로 올라가서 검사하도록 = break로 빠져나가지 않고!
				System.out.println("Bye~");
				scan.close();	// scan을 닫는 시점이 반복문이 돌아갈 필요가 없는 경우 = break가 실행되기 직전
				break;
			}
			
			oydot = scan.next();
			oy = Integer.parseInt(oydot);
			
			if (ox < 1 || ox > width) {
				System.out.println("다시 입력하세요.");
				continue;	// continue가 실행되면, 다시 while문 처음으로 되돌아간다.
			}
			
			
			int x;
			int y;
			
			for (y = 0; y < height; y++) {
				for (x = 0; x < width; x++) {
					
					if (ox == x && oy == y) {
						System.out.print("●");
					}
					else if (y == 0 && x == 0) {
						System.out.print("┌");
					}
					else if (y == 0 && x == width-1) {
						System.out.print("┐");
					}
					else if (y == height-1 && x == 0) {
						System.out.print("└");
					}
					else if (y == height-1 && x == width-1) {
						System.out.print("┘");
					}
					else if (y == 0) {	// y는 어차피 20번만 반복되기 때문에, 0으로 잡아도 칸수는 제한됨
						System.out.print("┬");	// 첫 & 끝 부분까지 'ㅜ'가 나오지 않는 이유는 상위 else if문에서 벌써 '┌', '┐'가 실행되었기 때문에
					}
					else if (y == 19) {
						System.out.print("┴");
					}
					else if (x == 0) {
						System.out.print("├");
					}
					else if (y < height-1 && x == width-1) {
						System.out.print("┤");
					}
					else {
						System.out.print("┼");
					}
				}
				System.out.println();
			}
		}
	}
}