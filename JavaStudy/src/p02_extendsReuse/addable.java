package p02_extendsReuse;

public interface addable {
	
	// console 클래스에 데이터를 직접 추가하지 않기 위해, 별도로 input과 print 함수를 마련
	void input(Re_exam_func exam);

	void print(Re_exam_func exam);
	
}
