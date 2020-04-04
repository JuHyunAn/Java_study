package javaStu;

import java.util.Scanner;

public class Te06Study1 {

	public static int total (int subj1, int subj2, int subj3) {	// 과목 3개의 총합을 반환하는 함수!
		return subj1 + subj2 + subj3;
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int subj1, subj2, subj3;
		String subj01, subj02, subj03;
		
		subj01 = scan.next();
		subj1 = Integer.parseInt(subj01);
		
		subj02 = scan.next();
		subj2 = Integer.parseInt(subj02);
		
		subj03 = scan.next();
		subj3 = Integer.parseInt(subj03);
		
		int totalSubj = Te06Study1.total(subj1, subj2, subj3);
		
		System.out.println(totalSubj);
		
		System.out.println((float)totalSubj / 3);
		
		scan.close();
	}
}
