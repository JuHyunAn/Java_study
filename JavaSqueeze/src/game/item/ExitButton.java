package game.item;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.item.Movable;
//나가기 버튼위치와 크기 
public class ExitButton implements game.item.Movable {

	public static final int STATE_ON = 1;
	public static final int STATE_OFF = 0;
	

	private double x;
	private double y;
	private int width;
	private int height;
	private Image img;
	private Image img2;
	private int stateValue;
	private Cursor cursor;

	public ExitButton() {

		x = 150-5;
		y = 660;
		width = 200;
		height = 70;
		stateValue = STATE_OFF;
		try {
			img = ImageIO.read(new File("res/image/Intro/exiton.png"));
			img2 = ImageIO.read(new File("res/image/Intro/exitoff.png"));
		
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void update() {

	}

	@Override
	public void draw(Graphics g) {
		int x = (int) this.x;
		int y = (int) this.y;
		if (stateValue == STATE_ON) {
			g.drawImage(img2, x, y, x + width, y + height, 0, 0, 617, 227, null);

		} else if (stateValue == STATE_OFF) {

			g.drawImage(img, x, y, x + width, y + height, 0, 0, 617, 227, null);

		}
		

	}

	public boolean contains(int x, int y) {

		if ((this.x < x && x < this.x + width) && (this.y < y && y < this.y + height))
			return true;

		return false;
	}

	public void state(int stateValue) {
		this.stateValue = stateValue;
	}

}
