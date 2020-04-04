package javaStu;

import java.util.Scanner;

public class Te06Study2 {

	public static void main(String[] args) {
		
		System.out.println("국,영,수 성적을 차례대로 입력하세요.");
		
		int korS, engS, mathS;
		
		while (true) {
			System.out.print(">> ");
			
			Scanner scan = new Scanner(System.in);
			String kor, eng, math;
			
			kor = scan.next();
			korS = Integer.parseInt(kor);
			eng = scan.next();
			engS = Integer.parseInt(eng);
			math = scan.next();
			mathS = Integer.parseInt(math);
			
			scan.close();
			
			if (korS < 0 || korS > 100) {
				System.out.println("점수를 올바르게 입력하세요.");
				continue;
			}
			else if (engS < 0 || engS > 100) {
				System.out.println("점수를 올바르게 입력하세요.");
				continue;
			}
			else if(mathS < 0 || mathS > 100) {
				System.out.println("점수를 올바르게 입력하세요.");
				continue;
			}
			else {
				break;
			}
		}
		
		int total = korS + engS + mathS;
		
		double avg = (float)total / 3;
		
		System.out.printf("총합은 %d입니다.\n", total);
		System.out.println("");
		System.out.printf("평점은 %f입니다.\n", avg);
		System.out.println("");
		/*
		 * 90 ~ 100점은 A학점
		 * 80점대는 B학점
		 * 70점대는 C학점
		 * 60점대는 D학점
		 * 이하는 F학점
		 */
		
		switch ((int)avg / 10) {
		
		case 10:
			System.out.println("A학점입니다.");
			break;
		case 9:
			System.out.println("A학점입니다.");
			break;
		case 8:
			System.out.println("B학점입니다.");
			break;
		case 7:
			System.out.println("C학점입니다.");
			break;
		case 6:
			System.out.println("D학점입니다.");
			break;
		default:
			System.out.println("F학점입니다. 자퇴신청 페이지로 이동합니다.");
			break;
		}
		
	}
	
}
