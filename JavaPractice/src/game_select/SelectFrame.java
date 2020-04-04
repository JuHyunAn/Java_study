package game_select;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import game.TestIntroCanvas;

public class SelectFrame extends Frame {
	
	private static SelectFrame frame;
	private SelectCanvas SelectCanvas;
	
	public SelectFrame() {
		// TODO Auto-generated constructor stub
		frame = this;
		SelectCanvas = new SelectCanvas();
		this.add(SelectCanvas);
		SelectCanvas.start();
		
		// 윈도우 이벤트 사용을 위해, 윈도우 리스너와 어뎁터 키워드를사용
		this.addWindowListener(new WindowAdapter() {

			@Override
			// 창 내에서 화면을 바로 종료할 수 있도록 하자
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// 창 종료 전 안내 문구가 뜨도록 하자
				int result = JOptionPane.showConfirmDialog(SelectFrame.this, "종료하시겠습니까?");
					
				// yes일 때만 종료되도록
				if (result == 0) {
					System.exit(0);
				}
			}
		});
	}

	// 신규 frame을 사용할 수 있도록 getter 생성
	public static SelectFrame getInstance() {
		return frame;
	}
	
	public void changeCanvas(int canvasId) {
		if (canvasId == 2) {
			this.remove(SelectCanvas);
			TestIntroCanvas canvas = new TestIntroCanvas();
			this.add(canvas);
			canvas.start();
			canvas.setFocusable(true);
			canvas.requestFocus();
			this.revalidate();
		}
	}
}
