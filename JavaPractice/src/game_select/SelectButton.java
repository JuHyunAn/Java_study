package game_select;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game_Intro.Showable;

public class SelectButton implements Showable2 {	// 팽귄 버튼
	
	public static final int STATE_CLICK = 2;	// 버튼 클릭
	public static final int STATE_ON = 1;	// 마우스 올렸을때
	public static final int STATE_OFF = 0;	// 마우스 땟을때
	private int width;
	private int height;
	private double x, y;
	private double x1, y1;
	private int stateValue;
	private Image buttonImg1, buttonImg2, buttonImg3;	// 팽귄 버튼
	
	public SelectButton() {
		// TODO Auto-generated constructor stub
		// 버튼 클릭, 버튼 on-off 상태 설정
		stateValue = STATE_OFF;
		
		try {
				buttonImg1 = ImageIO.read(new File("res/image/chapter_bt1.png"));
				buttonImg2 = ImageIO.read(new File("res/image/chapter_bt1_2.png"));
				buttonImg3 = ImageIO.read(new File("res/image/chapter_bt1_3.png"));
				
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		x = 40;
		y = 140;
		width = 203;
		height = 271;
	}
	
	// 버튼의 인식 범위 설정
	public boolean contains(int x, int y) {
		// 팽귄 버튼
		if ((this.x < x && x < this.x + width) && (this.y < y && y < this.y + height)) {
			return true;
	      }
		return false;
	}
	
	public void setStateValue(int stateValue) {
		this.stateValue = stateValue;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int x = (int) this.x;
		int y = (int) this.y;

		// 앞쪽이 캔버스 상의 위치, 뒤쪽이 버튼 이미지의 크기
		// 팽귄 버튼
		if (stateValue == STATE_ON) {
			g.drawImage(buttonImg2, x, y, x+width, y+height, 0, 0, width, height, null);
		}
		else if (stateValue == STATE_OFF) {
			g.drawImage(buttonImg1, x, y, x+width, y+height, 0, 0, width, height, null);
		}
		else if (stateValue == STATE_CLICK) {
			g.drawImage(buttonImg3, x, y, x+width, y+height, 0, 0, width, height, null);
		}

	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

}
