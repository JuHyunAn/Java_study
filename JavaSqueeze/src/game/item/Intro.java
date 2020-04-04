package game.item;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.ui.IntroCanvas;

//인트로 이미지가지고있는 클래스
public class Intro implements game.item.Movable {
	private static Intro canvas;
	private Image img;
	private static Image img2;
	private static Image img3;
	private int width;
	private int height;
	private double x;
	private double y;
	private int imgIndex;

	static {
		try {
			img2 = ImageIO.read(new File("res/image/Intro/IntroChar.png"));
			img3 = ImageIO.read(new File("res/image/Intro/Intro_title.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Intro() {
		x = 180;
		y = 300;
		width = 20;
		height = 76;
		imgIndex = 0;
		canvas = this;
		
		try {
			img = ImageIO.read(new File("res/image/Intro/IntroBack.jpg"));

		} catch (IOException e) {

			System.out.println("이미지가없음");
		}		
	}
	
	public Image getImage() {
		return img;
	}

	public void draw(Graphics g) {
		g.drawImage(img, 0, 0, 500, 800, 0, 0, 500, 800, IntroCanvas.getInstance());
		g.drawImage(img3, 20,70,IntroCanvas.getInstance());
		//g.drawImage(img2, 180, 300, 300, 400, imgIndex * 20, 0, imgIndex * 20 + 20, 76, IntroCanvas.getInstance());
		g.drawImage(img2, 60, 210, 430, 460, imgIndex * 433, 0, imgIndex * 433 +433, 291, IntroCanvas.getInstance());
		imgIndex++;
		if (imgIndex == 23)
			imgIndex = 0;

	}

	public void update() {

	}
}