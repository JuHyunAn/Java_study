package p02_extendsReuse;

// 객체 지향스러운 캡슐
public class Re_exam_func {

	// 캡슐화
	// 아래 변수들을 해당 클래스 내에서만 수정(=활용)가능하도록 private 사용
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;
	
	// 국, 영, 수에 10을 넣기 위해 넣을 수 있는 init 함수를 생성
	public void init (int kor, int eng, int math) {
		this.kor = kor;	// init 함수에 넣을 3가지 정수를 순서대로, 여기에 있는(this) 변수에 각각 넣어주겠다!
		this.eng = eng;
		this.math = math;
	}
	
	public void init () {
		this.init(0, 0, 0);
	}

	public int total() {
		return this.kor + this.eng + this.math;
	}

	public float avg() {
		return (float)this.total / 3;
	}

	/////////////////////////// 게터 ///////////////////////////
	public int getKor() {
		return this.kor;
	}
	
	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getTotal() {
		return total;
	}

	public float getAvg() {
		return avg;
	}
	
	/////////////////////////// 세터 ///////////////////////////
	// set을 그냥 사용하면 괄호 안에 네이밍이 달라질 수 있으니, 바꿔줘야 함!
	public void setKor(int kor) {
		this.kor = kor;
	}

	public final void setEng(int eng) {
		this.eng = eng;
	}

	public final void setMath(int math) {
		this.math = math;
	}

	public final void setTotal(int total) {
		this.total = total;
	}

	public final void setAvg(float avg) {
		this.avg = avg;
	}
	
}
	
