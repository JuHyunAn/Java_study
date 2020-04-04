package omok_game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Omok_Frame extends Frame {
	
	private Omok_Canvas canvas;
	
	public Omok_Frame() {
		// TODO Auto-generated constructor stub
		canvas = new Omok_Canvas();
		add(canvas);	// 캔버스를 프레임에 추가
		pack();	// 프레임을 이미지 크기에 맞춰줌
		canvas.start();
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				int result = JOptionPane.showConfirmDialog(Omok_Frame.this, "종료하자");
				
				System.out.println(result);
				
				// yes를 누를 경우에만 종료되도록 예외처리
				if (result == 0) {
					System.exit(0);
				}
				
			}
		});
	}
	
}
