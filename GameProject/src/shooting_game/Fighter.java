package shooting_game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fighter {
	
	private Image myfight; // 이미지 필요
	private int curX;
	private int curY;
	private int width;
	private int height;
	
	public Fighter() {
		// TODO Auto-generated constructor stub
		try {
			myfight = ImageIO.read(new File("res/image/figher1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 파이터 이미지의 너비와 높이
		width = myfight.getWidth(ShootingCanvas.getInstance());	// 64
		height = myfight.getHeight(ShootingCanvas.getInstance());	// 64
	}
		
	// 그린다.
	public void draw(Graphics g) {
		g.drawImage(myfight,
				width*3, height*8, width*4, height*9,
				0, 0, width, height, ShootingCanvas.getInstance());
	}

	// 나타난다.
	public void show() {
		
	}
	
	// 움직인다.
	public void move(int x, int y) {
		
	}
	// 발사한다.
	public void explode() {
		
	}
}
