package shooting_game;

import java.awt.Frame;

public class GameFrame extends Frame {
	
	private ShootingCanvas canvas;
	
	public GameFrame() {
		canvas = new ShootingCanvas();
		this.add(canvas); // 프레임 위에 캔바스를 붙인다
	}

}
