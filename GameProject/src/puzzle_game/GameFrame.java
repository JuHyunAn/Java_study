package puzzle_game;

import java.awt.Frame;

public class GameFrame extends Frame {
	
	private PuzzleCanvas canvas;
	
	public GameFrame() {
		canvas = new PuzzleCanvas();
		this.add(canvas); // 프레임 위에 캔바스를 붙인다
	}

}
