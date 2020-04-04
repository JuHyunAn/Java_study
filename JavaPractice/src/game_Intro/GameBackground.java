package game_Intro;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameBackground implements Showable {	// 인터페이스에 연결

	// 이미지 로드 (ImageIO 키워드를 사용하자!)
	private Image img;
	private int imgWidth;	// 이미지의 크기를 나타낼 변수
	private int imgHeight;


	// 생성자 내에서 이미지를 생성
	public GameBackground() {
		// TODO Auto-generated constructor stub
		try {
			img = ImageIO.read(new File("res/image/green.jpg"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imgWidth = img.getWidth(IntroCanvas.getInstance());
		imgHeight = img.getHeight(IntroCanvas.getInstance());
	}

	// read -> update -> repaint -> paint
	public void draw(Graphics g) {
		g.drawImage(img, 0, 0, 500, 800, IntroCanvas.getInstance());
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
