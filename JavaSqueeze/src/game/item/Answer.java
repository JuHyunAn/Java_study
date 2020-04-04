package game.item;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;

import game.ui.MainCanvas;

public class Answer implements Movable {
	private Image boxImage;
	private Image answerImage;
	private String answerString;
	
	private int imageX;
	private int imageY;
	private double answerX;
	private double answerY;
	private int width;
	private int height;
	private int index;
	
	private boolean stateValue;
	private boolean isFirstChapter;
	
	public Answer(Image image, String answer, int index) {
		answerString = answer;
		boxImage = image;
		width = image.getWidth(null);
		height = image.getHeight(null);
		isFirstChapter = false;
		this.index = index;
	}
	
	public Answer(Image image, Image answer, int index) {
		answerImage = answer;
		boxImage = image;
		width = image.getWidth(null);
		height = image.getHeight(null);
		isFirstChapter = true;
		this.index = index;
	}
	
	public void setPostion(int x, int y) {
		imageX = x;
		imageY = y;
	}
	
	public void setState(boolean state) {
		stateValue = state;
	}
	
	public void set(Image answer, Image image) {
		answerImage = answer;
		boxImage = image;	
	}
	
	public void set(String answer, Image image) {
		answerString = answer;
		boxImage = image;	
	}
	
	public Image getImage() {
		return boxImage;
	}
	
	public void setImage(Image image) {
		this.boxImage = image;
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
		if (isFirstChapter) {
			answerX = imageX + (double)width / 2 - answerImage.getWidth(null) / 2;
			answerY = imageY;
		}
		else {
			answerX = MainCanvas.getImage().getWidth(null) / (double)2 - (double)answerString.length() * 10 / 2;
			answerY = imageY + height - 20;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(boxImage, imageX, imageY, MainCanvas.getInstance());
		if (isFirstChapter) {
			g.drawImage(answerImage, (int)answerX, (int)answerY, MainCanvas.getInstance());			
		} else {
			g.drawString(answerString, (int)answerX, (int)answerY);
		}
 	}
}