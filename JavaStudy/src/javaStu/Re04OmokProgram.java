package javaStu;

import java.util.Scanner;

public class Re04OmokProgram {

	public static void main(String[] args) {	// 값을 입력 받아 오목판 사이즈 출력하기
		
//		chapter 01.
//		1. 기본 오목판 만들기
//		2. 오목판을 크기를 유저가 선택할 수 있도록 선택지 인터페이스 만들기
//			- 크기를 유동적으로 변동하려면 크기를 책임지는 변수가 있어야 하고, 이것의 증감에 따라 달라지도록 할 수 있을듯?
//			- 유저가 어떻게 선택하게 할 것인가? = 번호를 눌러서
//			- 유저가 선택할 선택지를 만들어야 함
//		3. 유저 인터페이스는 어떠한 함수로 만들 것인지 판단
//			- while? if? switch?...
//		
//		chapter 02.
//		1. 바둑알을 원하는 곳에 입력하여 두기
//		2. 바둑알을 오목판의 x, y좌표를 이용해서 두기
//		3. 유저가 x, y좌표를 입력하면, 해당 좌표에 바둑알이 찍히도록 인터페이스 만들기
//			- x, y좌표를 어떻게 입력하게 할까?
//			- 내가 원하는대로 유저가 x, y를 입력할 수 있도록 어떻게 유도할 것인가?
//		4. 어떤 함수를 이용할 것인가?
//		
//		chapter 03.
//		1. 반복문을 통해서 유효성 검사 진행
//			- 유저가 잘못된 값을 입력하면, 다시 입력하도록 유도
//			- 입력 상에 오류가 없으면, 다음 값을 검사하도록
//		2. 구간 반복을 통해서,
//			- 유저가 선택한 오목판 선택지가 범위를 벗어날 경우, 재선택 하도록 유도하기
//			- (물론, 올바르게 선택하면 문제 없이 빠져나올 수 있게...break, continue 이용해서)
//			- 유저가 두기 원하는 바둑알 위치를 계속 바꿔서 입력 가능하도록 (반복문 특성상, 새로 찍을때마다 바둑판 계속 나옴;)
		
		
		/////////////////// 아래 부터 작성  ///////////////////
		
		int width = 0;
		int height = 0;
		int num;	// 유저가 입력한 문자 번호를 정수 번호로 바꾼다음 저장할 변수
		int ox;	// 바둑알을 둘 x축 좌표
		int oy;	// 바둑알을 둘 y축 좌표
		
		Scanner scan = new Scanner(System.in);
		String str;	// 유저가 입력하는 번호 값을 받을 변수
		String oxDot, oyDot;	// 바둑알 x, y좌표를 받을 변수
		
		// 유저가 번호를 입력하여, 오목판 크기를 선택할 수 있도록 콘솔 인터페이스 구성
		System.out.println("스텝 1) 만들고자 하는 오목판 크기를 선택하세요.");	
		System.out.println("1. 20*10");
		System.out.println("2. 20*20");
		System.out.println("3. 30*40");
		System.out.println("4. 40*60");
		System.out.print("-> ");
		
		while (true) {	// 유저가 1 ~ 4번 이외의 값을 입력할 시, 경고문을 출력하고 -> 다시 입력을 시도하도록 (= 반복하게 한다.)
	
			str = scan.nextLine();
			num = Integer.parseInt(str);
			
			if (num < 1 || num > 4) {
				System.out.println("1번 ~ 4번 중에 선택해주세요!");
				System.out.print("-> ");
			}
			else {
				break;	// while 반복문을 빠져나올 수 있도록
			}
		}
		
		
		System.out.println("");	// 띄어쓰기
		
		
	// 선택지 생성 (switch문 활용)
			switch (num) {
			
			case 1:
				width = 20;
				height = 10;
				System.out.println(">> 1번을 선택하셨습니다. <<");
				break;
				
			case 2:
				width = 20;
				height = 20;
				System.out.println(">> 2번을 선택하셨습니다. <<");
				break;
				
			case 3:
				width = 30;
				height = 40;
				System.out.println(">> 3번을 선택하셨습니다. <<");
				break;
				
			case 4:
				System.out.println(">> 4번을 선택하셨습니다. <<");	// break를 걸어주지 않았기 때문에, default값 까지 실행되어 결과는 합쳤을때와 동일
			
			default:
				width = 40;
				height = 60;
			}
			
			
		System.out.println("");	// 띄어쓰기
		
		
		// 유저가 x, y축 좌표를 입력하면, 해당 위치에 바둑알을 생성시키는 인터페이스 구성
		System.out.println("스텝 2) 바둑알을 둘 위치의 x, y좌표를 입력하세요.");
			
		while (true) {
			System.out.print("(입력) x y : ");
			
			oxDot = scan.next();	// nextLine();을 사용할 경우, 입력한 값을 한줄씩 불러오기 때문에 엔터(줄바꿈)가 들어가게 됨
			ox = Integer.parseInt(oxDot);	// next();를 사용하여, 입력 값을 하나씩 차례대로 불러오도록 해야 띄어쓰기 포함해서 입력 가능
			
			if (ox < 0 || ox > width) {
				System.out.println("x 또는 y축 좌표 값이 허용 범위를 초과하였습니다.");	// ?? 둘중 하나가 맞으면 그만 나와야 하는데..조건을 어떻게 해야할까..
				continue;
			}
			
			oyDot = scan.next();
			oy = Integer.parseInt(oyDot);
			
			if (oy < 0 || oy > height) {
				System.out.println("x 또는 y축 좌표 값이 허용 범위를 초과하였습니다.");	// ?? 둘중 하나가 맞으면 그만 나와야 하는데..조건을 어떻게 해야할까..
				continue;
			}

			
			System.out.println("");	// 띄어쓰기

			
			// 10*10  오목판 만들기 > 크기를 유동적으로 바꿀 수 있도록 기본틀 보수
			int x;	// x축
			int y;	// y축
			
			for (y = 0; y < width; y++) {	// y축 줄 하나에 x축 줄 10개 필요!
				for (x = 0; x < height; x++) {
					
					if (oy == y && ox == x) {
						System.out.print("●");
					}
					else if (y == 0 && x == 0) {
						System.out.print("┌");
					}
					else if (y == 0 && x == (height-1)) {
						System.out.print("┐");
					}
					else if (y == width-1 && x == 0) {
						System.out.print("└");
					}
					else if (y == (width-1) && x == (width-1)) {
						System.out.print("┘");
					}
					else if (y == 0) {
						System.out.print("┬");
					}
					else if (x == (height-1)) {
						System.out.print("┤");
					}
					else if (x == 0) {
						System.out.print("├");
					}
					else if (y == (width-1)) {
						System.out.print("┴");
					}
					else {
						System.out.print("┼");
					}
				
				}
				System.out.println();
			}
			scan.close();
		}

	}

}
