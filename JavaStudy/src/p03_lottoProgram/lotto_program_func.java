package p03_lottoProgram;
//캡슐화 : (구조화o, 함수화o, 객체지향화o, 비상속화o)
import java.util.Random;

public class lotto_program_func {	// 겹치는 변수명이 없어도 한동안은 this를 사용한다!
	
	private int[] lotto;
	
	public lotto_program_func() {
		this.lotto = new int[6];
	}
	
	// 객체 지향화 하면서 함수명 변경 (간단하게 동사형으로)
	
	// 로또 생성 함수
	public void generate() {
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			this.lotto[i] = rand.nextInt(45) + 1;
		}

	}
	
	// 로또 정렬 함수
	public void sort() {
		for (int a = 0; a < 5; a++) {
			for (int i = 0; i < 5-a; i++) {
				if (this.lotto[i] > this.lotto[i+1]) {
					int temp = this.lotto[i];
					this.lotto[i] = this.lotto[i+1];
					this.lotto[i+1] = temp;
				}
			}
		}
	}
	
	public int[] getLotto() {
		return this.lotto;
	}
	
	// 콩통 딜레이 함수
	public void delay() {
		try {
			Thread.sleep(2000);
			} catch (InterruptedException e) {

			}
	}
	
	// 메인 클래스 : OOPstruct__lotto_program.java
}
