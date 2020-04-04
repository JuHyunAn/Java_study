package p04_examProgram;

//객체 지향스러운 캡슐
public class Has_exam_main {

	public static void main(String[] args) {
		
		Has_exam_func exam = new Has_exam_func();	// new를 통해 생성자가 Exam을 담아서 
		
		int total = exam.total();
		float avg = exam.avg();
		
		Has_exam_console console = new Has_exam_console();
		
//		객체지향 해석 : exam에.입력한다
//		exam.input();
		
		console.input();
		
		console.print();
	}
	
}
