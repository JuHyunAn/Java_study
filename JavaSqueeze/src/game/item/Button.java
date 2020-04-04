package game.item;

import java.awt.Cursor;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Button {
	private Image image;
	
	private int curX;
	private int curY;
	private int width;
	private int height;
	
	private boolean stateValue;

	public Button() {
		curX = 0;
		curY = 0;
	}

	public Button(int x, int y) {
		curX = x;
		curY = y;		
	}

	public void update() {
	}

	public void setState(boolean state) {
		stateValue = state;
	}

	public boolean contains(int x, int y) {
		if (x <= curX + width && x >= curX && y <= curY + height && y >= curY) {
			return true;
		}
		return false;
	}

	public void setImage(Image image) {
		this.image = image;
		width = image.getWidth(null);
		height = image.getHeight(null);
	}
	
	public Image getImage() {
		return image;
	}

	public void setPostion(int x, int y) {
		curX = x;
		curY = y;
	}

	public int getX() {
		return curX;
	}

	public int getY() {
		return curY;
	}
}