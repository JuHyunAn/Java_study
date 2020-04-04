package game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

public class TestIntroCanvas extends Canvas {

	
	
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					
				}
			}
		});
	}
	
	public void update() {
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	@Override
	public void paint(Graphics g) {
//		Image buf = createImage(getWidth(), getHeight());
//		Graphics gg = buf.getGraphics();
//		
//		for (int i = 0; i < unitIndex; ++i) {
//			items[i].draw(gg);
//		}
//		
//		g.drawImage(buf, 0, 0, this);
	}
}
