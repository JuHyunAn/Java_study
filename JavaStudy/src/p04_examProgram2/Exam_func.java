package p04_examProgram2;

public class Exam_func {
	
	private int subject1;	// 과목1
	private int subject2;	// 과목2
	private int subject3;	// 과목3
	private int total;
	private float avg;
	private int subject1_total = 0;
	private int subject2_total = 0;
	private int subject3_total = 0;
	private float subject1_avg = 0;
	private float subject2_avg = 0;
	private float subject3_avg = 0;
	
	static final int score_input = 1;
	static final int score_print = 2;
	static final int program_end = 3;
	
	///////////////// 배열 선언 ///////////////////
	// 배열을 func에서 새롭게 선언
	Exam_func[] exams;
	
	public Exam_func() {
		// TODO Auto-generated constructor stub
		exams = new Exam_func[3];	// constructor내에서 배열 크기를 설정 (= 생성자 때문!)
	}
	
	// exams 배열에 대한 getter
	public Exam_func[] getExams() {
		return exams;
	}
	// exams 배열에 대한 setter
	public void setExams(Exam_func[] exams) {
		this.exams = exams;
	}
	////////////////////////////////////////////
	
	// 학생 별 총합과 평군을 저장
	public void studentScore() {
		for(int i = 0; i < 3; i++) {
			exams[i].total = exams[i].subject1 + exams[i].subject2 + exams[i].subject3;
			exams[i].avg = (float)exams[i].total / 3;
		}
	}
	
	// 과목 별 총합을 저장
	public void subjectTotal() {
		for(int i = 0; i < 3; i++) {
			this.subject1_total += exams[i].subject1;
			this.subject2_total += exams[i].subject2;
			this.subject3_total += exams[i].subject3;
		}
	}
	
	// 과목 별 평균을 저장
	public void subjectAvg() {
		this.subject1_avg = (float)this.subject1_avg / 3;
		this.subject2_avg = (float)this.subject2_avg / 3;
		this.subject3_avg = (float)this.subject3_avg / 3;
	}

	public int getSubject1() {
		return subject1;
	}

	public void setSubject1(int subject1) {
		this.subject1 = subject1;
	}

	public int getSubject2() {
		return subject2;
	}

	public void setSubject2(int subject2) {
		this.subject2 = subject2;
	}

	public int getSubject3() {
		return subject3;
	}

	public void setSubject3(int subject3) {
		this.subject3 = subject3;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getAvg() {
		return avg;
	}

	public void setAvg(float avg) {
		this.avg = avg;
	}

	
}