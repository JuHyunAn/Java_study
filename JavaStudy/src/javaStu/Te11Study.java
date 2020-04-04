package javaStu;

import java.util.Scanner;

public class Te11Study {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 문제) 영어 단어를 입력했을 때, 가장 많이 사용된 알파벳을 출력하는 프로그램 구현
		// 1. 대소문자를 가리지 않음
		// 2. 가장 많이 사용된 알파벳에 대소문자가 같이 있을 경우, 대문자로 출력
		// 3. 가장 많이 사용된 알파벳의 수가 동일할 경우, ?(물음표)를 출력
		
		Scanner scan = new Scanner(System.in);
		// 단어를 입력 받을 변수
		String alphabet = scan.nextLine();
		
		// 영문 대문자 저장할 배열 변수 (65 ~ 90)
		int[] upperNum = new int[26];
		
		// 영문 소문자 저장할 배열 변수 (97 ~ 122)
		int[] lowerNum = new int[26];
		
		// charAt으로 잘린 글자를 아스키 코드 번호로 저장
		int[] nums = new int[alphabet.length()];
		
		int count1 = 1;
		int count2 = 1;

		for (int i = 0; i < alphabet.length(); i++) {
			// 입력 받은 단어를 한 글자씩 잘라서 읽음
			nums[i] = alphabet.charAt(i);
			
			// 대/소문자에 따라 서로 다른 변수에 저장
			if (nums[i] >= 65 && nums[i] <= 90) {
				upperNum[i] = nums[i];
			}
			if (nums[i] >= 97 && nums[i] <= 122) {
				lowerNum[i] = nums[i];
			}
		}
	}
}
