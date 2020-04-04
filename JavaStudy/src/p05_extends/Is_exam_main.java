package p05_extends;

public class Is_exam_main {
	
	public static void main(String[] avg) {
		
//		Is_exam_func exam = new Is_exam_func();
		Is_exam_override exam = new Is_exam_override();	// 새로 추가된 과목을 반영하기 위해 func대신 override 클래스를 참조한다.
														// 기존 변수에 영향이 가지 않도록, override 클래스를 func 클래스에 상속시킨다.
														// (= 자식 클래스는 부모 클래스의 기능을 사용 가능하기 때문!)
		
		// 3가지 과목에 각각 75, 80, 93점을 넣어줌
		exam.setSubject1(75);
		exam.setSubject2(80);
		exam.setSubject3(93);
		
		// 나머지 두 과목에 각각 89 90을 넣어줌 -> 총합/평균 식에 추가 필요
//		exam.setSubject4(89);
//		exam.setSubject5(93);
		
		exam.total();
		exam.avg();
		
		// 점수를 출력
		System.out.println("※ 과목 점수");
		System.out.printf("과목1 : %d, 과목2 : %d, 과목3 : %d\n", exam.getSubject1(), exam.getSubject2(), exam.getSubject3());
		System.out.printf("(추가된 과목) 과목4 : %d, 과목5 : %d\n", exam.getSubject4(), exam.getSubject5());
		System.out.println();
		System.out.println("※ 총합 및 평균 점수");
		System.out.printf("총합 : %d\n", exam.total());
		System.out.printf("평균 : %f\n", exam.avg());
	}
	
}

// main 클래스에 override 클래스가 참조되어 있고, override 클래스는 func 클래스에 상속되어 있다.