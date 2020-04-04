package game;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;

public class Answer implements Movable {

	private int imageX;
	private int imageY;
	private double stringX;
	private double stringY;
	private Image image;
	private String answer;
	private int width;
	private int height;
	private Cursor cursor;
	private boolean stateValue;
	private int index;
	
	public Answer(Image image, String answer, int index) {
		this.answer = answer;
		this.image = image;
		width = image.getWidth(null);
		height = image.getHeight(null);
		this.index = index;
	}
	
	public void setPostion(int x, int y) {
		imageX = x;
		imageY = y;
	}
	
	public void setState(boolean state) {
		stateValue = state;
	}
	
	public void set(String answer, Image image) {
		this.answer = answer;
		this.image = image;	
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public boolean contains(int x, int y) {
		if (x <= imageX + width && x >= imageX && 
				y <= imageY + height && y >= imageY) {
			return true;
		}
		return false;
	}
	
	public int getIndex() {
		return index;
	}
	
	@Override
	public void update() {
		stringX = imageX + (double)image.getWidth(null) / 2 - answer.length() * 5;//(double)MainCanvas.getFontSize() / 2;
		stringY = imageY + (double)image.getHeight(null) / 2 + (double)MainCanvas.getFontSize() / 2;
		
		if (stateValue == true) {
			MainCanvas.getInstance().setCursor(cursor);
		}
		else {
			MainCanvas.getInstance().setCursor(null);
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, imageX, imageY, MainCanvas.getInstance());
		g.drawString(answer, (int)stringX, (int)stringY);
 	}
}