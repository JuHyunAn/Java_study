package game.item;

import java.awt.Graphics;
import java.awt.Image;

import game.ui.MainCanvas;

public class Question implements Movable {
	private Image image;
	
	private int posX;
	private int posY;
	private int newWidth = 430;
	private int newHeight = 600;

	public Question(int x, int y, Image img) {		
		posX = x;
		posY = y;
		image = img;
		setImageSize();
	}
	
	public void set(int x, int y, Image img) {
		posX = x;
		posY = y;
		image = img;
		setImageSize();
	}
	
	// 문제의 이미지 크기가 제각각이라 일정한 가로 크기로
	// 비율 유지하면서 리사이징
	private void setImageSize() {
		int width  = image.getWidth(null);
		int height = image.getHeight(null);
		double ratio  = (double)newWidth / width;
		double w = width * ratio;
		double h = height * ratio;
		
		image = image.getScaledInstance((int)w, (int)h, Image.SCALE_SMOOTH);		
	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image, posX, posY, MainCanvas.getInstance());
	}
}