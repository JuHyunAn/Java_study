package javaStu;

import java.util.Scanner;

public class Te07Study3 {

	public static void main(String[] args) {
		
		// 이름을 n개 입력한 뒤 숫자를 입력하면, 그 숫자 번째에 해당하는 이름을 출력하고 종료하는 프로그램

		//////////////// 이름을 입력 받고 저장 ////////////////
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		//////////// 숫자 입력 시 해당 번째 이름 출력 ////////////
		System.out.println("숫자를 입력하세요");
		System.out.print("> ");
		int numb = scan.nextInt();
		
		//////////////////// 배열 선언 ////////////////////
		String[] nameS = str.split(" ");	// 띄어쓰기(공백)를 기준으로 문자열을 나눠 배열에 대입함

		// .split("기준") 함수는 특정 기준을 가지고 문자열을 나누고, 각 배열 인덱스에 넣는다!
		
		for (int i = 0; i < str.length(); i++) {
			
			if (numb == i) {
				System.out.println(nameS[i]);
			}
		}
		scan.close();
	}

}
