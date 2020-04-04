package game.ui;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DeveloperCanvas extends Canvas {
	private static Image img;
	private static Image img2;
	private int x;
	private int y;
	private int width;
	private int height;

	private static DeveloperCanvas canvas;

	public DeveloperCanvas() {

		x = 50;
		y = 40;
		width = 31;
		height = 28;
		try {
			img = ImageIO.read(new File("res/image/developer/DeveloperBack.jpg"));
			img2 = ImageIO.read(new File("res/image/developer/home.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (contains(e.getX(), e.getY())) {
					QuizFrame.getInstance().changeCanvas(7);
					System.out.println("5");
				}

			}
		});
		// TODO Auto-generated constructor stub
	}

	public boolean contains(int x, int y) {
		if ((this.x < x && x < this.x + width) && (this.y < y && y < this.y + height))
			return true;

		return false;
	}

	public static DeveloperCanvas getInstance() {
		return canvas;
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(img, 0, 0, this);
		g.drawImage(img2, x, y, x + width, y + height, 0, 0, 31, 28, null);
	}
}
