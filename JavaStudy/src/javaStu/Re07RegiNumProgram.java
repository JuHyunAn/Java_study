package javaStu;

import java.io.IOException;
import java.util.Scanner;

public class Re07RegiNumProgram {

	public static void main(String[] args) throws IOException {
		
		/*
		 * 주민번호 13자리 780222-1076511를 입력받아서,  7802221076511을 출력
		 * 
		 * 1. 주민번호를 입력할 변수 필요
		 * 	- Scanner 필요할듯...
		 * 	- 콘솔에 숫자를 입력할 수 있도록 'System.in'이 필요 
		 * 	- 그렇다면, 문자열로 입력되니까 그 값을 다시 정수로 변환하는 과정이 필요
		 *  - 이렇게 되면, 정수로 변환된 값을 받을 변수가 또 하나 필요하게 됨?
		 * 2. 주민번호를 입력할 유저 인터페이스가 필요
		 * 	- 입력 양식을 간단하게 만들 수 있겠다.
		 * 	- 입력할때 '-'도 포함이 되어야 하는건가? 뭐임?
		 * 3. 출력할때 '-'는 출력하지 않아야 한다.
		 */
	
		System.out.println("		<알림>		");
		System.out.println("주민등록번호 13자리를 입력하세요.");
		// System.out.println("앞자리와 뒷자리는 '-'으로 구분해주세요.");
		System.out.print("13자리 입력 : ");
		
		Scanner scan = new Scanner(System.in);	// 주민 번호 입력 받을 틀
		String str;
		
		str = scan.nextLine();
		
		
		for (int i = 0; i < 14; i++) {
			
			str.charAt(i);

			if (i != 6) {
				System.out.print(str.charAt(i));
			}
			else {
				continue;
			}

		}
		scan.close();
	}
	
}