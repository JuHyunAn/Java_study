package p01_calcProgram;

public class Calc_func {
	
	public int plus(int num1, int num2) {
		return num1 + num2;
	}
	
	public int minus(int num1, int num2) {
		return Math.abs(num1 - num2);
	}
	
	public int multi(int num1, int num2) {
		return num1 * num2;
	}
	
	public float divide(float num1, float num2) {
		if (num2 == 0) {
			System.out.println("연산 불능(0으로 나눌 수 없습니다.)");
			return 0;
		}
		return num1 / num2;
	}

}

