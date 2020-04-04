package game;

import java.awt.Frame;

public class QuizFrame extends Frame {
	private static QuizFrame frame;
	
	private 
	
	MainCanvas mainCanvas;
	public QuizFrame() {
		frame = this;
		mainCanvas = new MainCanvas(1);
		mainCanvas.setFocusable(true);
		add(mainCanvas);
		pack();
		mainCanvas.start();
	}
	
	public void changeCanvas(int step) {
		//mainCanvas = new MainCanvas(step);
//		// 프레임에 추가한다
//		add(mainCanvas);
//		
//		// 게임 화면에서 '그리기'동작을 위한 스레드(별도의 실행흐름)를 만든다
//		mainCanvas.start();
//		
//		// 화면을 강제로 새로 그리게 만들어야 바뀐 캔버스가 나타난다
//		revalidate();
//		
//		// 게임 화면에 포커스를 주는 건데  Canvas가 가지고 있는
//		// setFocusable(true)가 먹히지 않아서 다음 함수를 사용
//		mainCanvas.requestFocus();
	}
}