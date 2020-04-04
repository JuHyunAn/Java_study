package puzzle_game;

import java.awt.Canvas;
import java.awt.Graphics;

public class PuzzleCanvas extends Canvas {
	
	private Puzzle[] puzzles;
	private static PuzzleCanvas canvas; // 전역변수처럼 만든다.
	public PuzzleCanvas() {
		canvas = this;
		puzzles = new Puzzle[6];
		puzzles[0] = new Puzzle(0);
		
	}
	//싱글톤
	public static PuzzleCanvas getInstance() {
		return canvas;
	}
	
	@Override
	public void paint(Graphics g) {
		puzzles[0].draw(g);
	}
}
