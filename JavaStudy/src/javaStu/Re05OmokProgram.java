package javaStu;

import java.util.Scanner;

public class Re05OmokProgram {

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
		
		// 오목판 크기를 유저가 번호를 입력하여, 선택할 수 있도록 콘솔 인터페이스 구성
		
		int num;	// 유저가 입력한 문자 번호를 정수 번호로 바꾼다음 저장할 변수
		Scanner scan = new Scanner(System.in);
		String str;	// 유저가 입력하는 번호 값을 받을 변수
		
		str = scan.nextLine();
		num = Integer.parseInt(str);
		
		System.out.println("만들고자 하는 오목판 크기를 골라주세요.");
		System.out.println("1. 10*10");
		System.out.println("2. 20*20");
		System.out.println("3. 30*40");
		System.out.println("4. 40*60");
		
		// 선택지 생성
		// <--- 이 부분에서 유저가 선택지를 고르고, 그 값만큼만 오목 크기가 변해서 나오도록 하려면 기존에 만든 오목판 기본 크기가 유동적으로 변동될 수 있도록 해줘야 함!! --->
		if (num == 1) {
			
		}
		
		
		
		// 10*10  오목판 만들기 > 크기를 유동적으로 바꿀 수 있도록 기본틀 보수
		int width = 10;
		int height = 10;
		int x;	// x축
		int y;	// y축
		
		for (y = 0; y < 10; y++) {	// y축 줄 하나에 x축 줄 10개 필요!
			for (x = 0; x < 10; x++) {
				
				if (y == 0 && x == 0) {
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
