package game_select;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game_Intro.Showable;

public class SelectButton4 implements Showable2 {
	
	public static final int STATE_CLICK = 2;	// 버튼 클릭
	public static final int STATE_ON = 1;	// 마우스 올렸을때
	public static final int STATE_OFF = 0;	// 마우스 땟을때
	private int width;
	private int height;
	private double x;
	private double y;
	private int stateValue;
	private Image buttonImg1;
	private Image buttonImg2;
	private Image buttonImg3;
	
	public SelectButton4() {
		// TODO Auto-generated constructor stub
		// 버튼 클릭, 버튼 on-off 상태 설정
		stateValue = STATE_OFF;
		
		try {
				buttonImg1 = ImageIO.read(new File("res/image/chapter_bt3.png"));
				buttonImg2 = ImageIO.read(new File("res/image/chapter_bt3_2.png"));
				buttonImg3 = ImageIO.read(new File("res/image/chapter_bt3_3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 이미지가 위치할 캔버스의 좌상단 x, y좌표
		x = 40;
		y = 428;
		// 이미지의 너비와 높이
		width = 203;
		height = 271;
	}
	
	// 버튼의 인식 범위 설정
	public boolean contains(int x, int y) {

	      if ((this.x < x && x < this.x + width) && (this.y < y && y < this.y + height))
	         return true;

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
