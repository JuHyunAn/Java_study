package game;

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
	private Cursor cursor;
	private boolean stateValue;
	
	public Button(int x, int y) {
		curX = x;
		curY = y;
		width = 257;
		height = 53;
		cursor = new Cursor(Cursor.HAND_CURSOR);
		try {
			image = ImageIO.read(new File("res/image/next.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		if (stateValue == true) {
			MainCanvas.getInstance().setCursor(cursor);
		}
		else {
			MainCanvas.getInstance().setCursor(null);
		}
	}
	
	public void setState(boolean state) {
		stateValue = state;
	}
	
	public boolean contains(int x, int y) {
		if (x <= curX + width && x >= curX && 
				y <= curY + height && y >= curY) {
			return true;
		}
		return false;
	}
	
	public Image getImage() {
		return image;
	}
}