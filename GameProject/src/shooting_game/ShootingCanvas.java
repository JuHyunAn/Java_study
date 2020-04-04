package shooting_game;

import java.awt.Canvas;
import java.awt.Graphics;

public class ShootingCanvas extends Canvas {
	
	// 캔버스에 표현하고자 하는 개체 선언
	private Fighter fighter;
	private Enemy enemy;
	
	private static ShootingCanvas canvas; // 전역변수처럼 만든다.
	public ShootingCanvas() {
		canvas = this;
		// 개체를 실체화
		fighter = new Fighter();
		enemy = new Enemy();
	}
	
	// 캔버스를 리턴해서 캔버스를 사용할 수 있도록
	public static ShootingCanvas getInstance() {
		return canvas;
	}
	
	@Override
	// 실제로 캔버스 위에 출력될 수 있도록
	public void paint(Graphics g) {
		fighter.draw(g);
		enemy.draw(g);
	}
}
