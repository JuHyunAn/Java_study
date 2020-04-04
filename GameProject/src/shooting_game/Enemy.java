package shooting_game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends Canvas {
	
	private Image enemy;
	private int width;
	private int height;
	
	public Enemy() {
		// TODO Auto-generated constructor stub
		try {
			enemy = ImageIO.read(new File("res/image/alien.gif"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 적군 이미지의 너비와 높이
		width = enemy.getWidth(ShootingCanvas.getInstance()) / 12;	// 이미지 하나의 너비 값 (총 너비:696 / 12개 =) 58
		height = enemy.getHeight(ShootingCanvas.getInstance()) / 5;	// 이미지 하나의 높이 값 (총 높이:210 / 5 =) 42
	}
	
	// 그린다.
	public void draw(Graphics g) {
		g.drawImage(enemy, 192, 0, 256, 64, 
				0, 0, width, height, ShootingCanvas.getInstance());
	}
	
	public void show() {
		
	}
	
	public void move() {
		
	}
	
	public Bullet fire() {
		return null;
	}
	
	public void explode() {
		
	}
	
}
