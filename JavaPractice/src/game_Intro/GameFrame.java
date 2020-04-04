package game_Intro;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import game_select.SelectCanvas;

public class GameFrame extends Frame {
	
	private static GameFrame frame;
	private IntroCanvas introCanvas;
	
	public GameFrame() {
		// TODO Auto-generated constructor stub
		frame = this;
		introCanvas = new IntroCanvas();
		this.add(introCanvas);
		introCanvas.start();
		
		// 윈도우 이벤트 사용을 위해, 윈도우 리스너와 어뎁터 키워드를사용
		this.addWindowListener(new WindowAdapter() {

			@Override
			// 창 내에서 화면을 바로 종료할 수 있도록 하자
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// 창 종료 전 안내 문구가 뜨도록 하자
				int result = JOptionPane.showConfirmDialog(GameFrame.this, "종료하시겠습니까?");
					
				// yes일 때만 종료되도록
				if (result == 0) {
					System.exit(0);
				}
			}
		});
	}

	// 신규 frame을 사용할 수 있도록 getter 생성
	public static GameFrame getInstance() {
		return frame;
	}
	
	// 버튼 클릭 시, 다른 캔버스로 이동되도록 신규 캔버스 생성
	public void changeCanvas(int canvasId) {
		if (canvasId == 1) {
			this.remove(introCanvas);
			SelectCanvas canvas = new SelectCanvas();
			this.add(canvas);
			canvas.start();
			canvas.setFocusable(true);
			canvas.requestFocus();
			this.revalidate();
		}
	}
}
