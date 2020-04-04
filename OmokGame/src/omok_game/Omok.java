package omok_game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Omok {
	
	private static final int WHITE;
	private static final int BLACK;
	private int color;
	private static Image imgBlack;
	private static Image imgWhite;
	// 오목 이미지의 너비/높이
	private int width = 38;
	private int height = 38;
	// 오목의 좌표
	private double x;
	private double y;
	private double dx, dy;
	private double vx, vy;
	private int speed;
	
	private static int turn;
//	private boolean isBlackTurn;
	
	static {
		turn = 1;	// 기본 white, turn이 1이면 black
		WHITE = 1;
		BLACK = 2;
		try {
			imgBlack = ImageIO.read(new File("res/image/1.png"));
			imgWhite = ImageIO.read(new File("res/image/3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Omok() {
		// TODO Auto-generated constructor stub
		this(0, 0);
	}

	public Omok(int x, int y) {
		// TODO Auto-generated constructor stub
//		isBlackTurn = !isBlackTurn;
		turn++;
		turn %= 2;
		this.x = x;
		this.y = y;
		speed = 3;
		
		this.color = WHITE;
		if(turn == 1) {
			this.color = BLACK;
		}
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		int offsetX = width / 2;
		int offsetY = height / 2;

		// 휜백돌이 번갈아 가면서 찍히도록 하자
		Image img = imgBlack;
		
		if (color == WHITE) {
			img = imgWhite;
		}
		
		int x = (int) this.x-offsetX;
		int y = (int) this.y-offsetY;
		
		g.drawImage(img, x-offsetX, y-offsetY, Omok_Canvas.getInstance());
	}

	public void setX(int x) {
		// TODO Auto-generated method stub
		this.x = x;
		
	}

	public void setY(int y) {
		// TODO Auto-generated method stub
		this.y = y;
	}

	public void update() {
		// TODO Auto-generated method stub
	    if((x-speed <= x && x <= dx+speed) && (dx-speed <= y && y <=dy+speed)) {
	         vx = 0;
	         vy = 0;
	      }
		
		this.x += vx;
		this.y += vy;
		
	}

	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		this.dx = dx;
		this.dy = dy;
		double w = dx-x;
		double h = dy-y;
		double d = (float)Math.sqrt(w*w + h*h); //sqrt 루트
		vx = w/d;
		vy = h/d;
	}
	
}
