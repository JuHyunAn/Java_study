package p04_examProgram;

// 객체 지향스러운 캡슐
public class Has_exam_func {

	// 캡슐화
	// 아래 변수들을 해당 클래스 내에서만 수정(=활용)가능하도록 private 사용
	private int kor;
	private int eng;
	private int math;
	private int total;
	private float avg;
	
	
	/////////////////////// 생성자 활용 /////////////////////// 
	
	// Exam 생성자를 통해서 여기서 this.변수에 값을  줄 수도 있다.
	
//	public Exam() {	// 생성자(Exam)를 여기서 한 번이라도 선언하면, 컴파일러가 더 이상 자동으로 main함수에서 초기화를 해주지 않는다.
//		this.kor = 0;
//		this.eng = 0;
//		this.math = 0;
//	}
	
	// 생성자 오버로드
	public Has_exam_func(int kor, int eng, int math) {	// 값을 담을 수 있는 '오버로드' 함수
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public Has_exam_func() {
		this(40, 50, 60);
//		Exam(10, 20, 30);	// Exam은 생성자의 이름이 아니므로, Exam을 지칭할 수 없다!,
	}						//  그러므로 자기 자신임을 this (클래스가 생성자와 동일하므로)로 표기한다!

	//////////////////////////////////////////////////// 

	// 인스턴스 함수 (인스턴스 메서드)
//	public void print() {
//		System.out.printf("국어 성적 : %d\n", this.kor);	// 출력문은 다시 밖으로 빼두자
//		System.out.printf("영어 성적 : %d\n", this.eng);
//		System.out.printf("수학 성적 : %d\n", this.math);
//	}
	
	// 국, 영, 수에 10을 넣기 위해 넣을 수 있는 init 함수를 생성
	public void init (int kor, int eng, int math) {
		this.kor = kor;	// init 함수에 넣을 3가지 정수를 순서대로, 여기에 있는(this) 변수에 각각 넣어주겠다!
		this.eng = eng;
		this.math = math;
	}
	
	// 값을 변경 할때 오버로드 함수는 남아 있어야 한다.
	// 오버로드 함수가 남아있는 상태에서 해당 함수에 바로 값을 넣을 수 있게 되는 것
	public void init () {
		this.init(0, 0, 0);
	}

	public int total() {
		return this.kor + this.eng + this.math;
	}

	public float avg() {
		return this.total / 3.0f;
	}

//	public void input() {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("국어 성적 입력 :");
//		this.kor = scan.nextInt();
//		System.out.println("영어 성적 입력 :");
//		this.eng = scan.nextInt();
//		System.out.println("수학 성적 입력 :");
//		this.math = scan.nextInt();
//	}

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
	
