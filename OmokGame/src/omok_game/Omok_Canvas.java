package omok_game;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Omok_Canvas extends Canvas {
	
	public static Omok_Canvas instance;
	
	private Image img;
	private int width;
	private int height;
	private Omok[] omoks;
	private int omokIndex;
	private Omok omok;
	private int top;
	
	public Omok_Canvas() {
		// TODO Auto-generated constructor stub
		instance = this;
		omoks = new Omok[100];	// 모든 멤버가 사용가능하도록 생성자 내에서 멤버로 추가
		omok = new Omok();	// 오목 객체 생성
		omokIndex = 0;
		top = -1;
		
		// 바둑알이 통해 쌓여있다가 바둑판을 클릭하면 해당 위치로 옮겨가도록!
		Random rand = new Random();
		for(int i = 0; i < 99; i++) {
			int x = rand.nextInt(20)+600;	// 마우스가 찍은 곳의 좌표
			int y = rand.nextInt(20)+600;
//			x = (int) (Math.floor(x/40)*40)+20;	// Math.floor는 반 내림
//			y = (int) (Math.floor(y/40)*40)+20;
			omoks[omokIndex++] = new Omok(x, y);
			top++;
		}
		
		
		try {
			img = ImageIO.read(new File("res/image/2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		width = img.getWidth(this);
		height = img.getHeight(this);
		
		this.setSize(img.getWidth(this), img.getHeight(this));
		
		addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				
				x = (int) (Math.floor(x/40)*40)+20;	// Math.floor는 반 내림
				y = (int) (Math.floor(y/40)*40)+20;
				
				try {
					Omok omok = omoks[top];
//					omok.setX(x);
//					omok.setY(y);
					omok.move(x, y);
					
					top--;
				}
				catch (ArrayIndexOutOfBoundsException e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "더 이상 오목을 둘 수 없습니다.");
				}
				
				repaint();	// upgrade -> paint
			}
		});
	}
	
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		paint(g);
	}

	@Override
	public void paint(Graphics g) {	// 바둑돌은 번갈아 가면서 찍혀야 하고..마우스 클릭한 위치에 찍혀야 한다.
		// TODO Auto-generated method stub
		
		// 화면의 깜빡임을 줄이기 위해 기존 화면을 덮을 버퍼를 생성 (기존 화면 크기랑 동일한!)
		Image buff = createImage(this.getWidth(), this.getHeight());
		Graphics bufG = buff.getGraphics();
		
		bufG.drawImage(img, 0, 0, this);
		
		for(int i = 0; i < omokIndex; i++) {
			omoks[i].draw(bufG);
		}
		
		g.drawImage(buff, 0, 0, this);
	}

	public static Omok_Canvas getInstance() {
		return instance;
	}
	
	private void update() {
		// TODO Auto-generated method stub
		for(int i = 0; i < omokIndex; i++) {
			omoks[i].update();
		}
	}

	public void start() {
		Thread gameThread = new Thread(new Runnable() {
			
			// 사용자가 클릭하지 않아도 자동적으로 화면을 갱신하도록
			@Override
			public void run() {
				while(true) {
					
					update();
					repaint();
					
					try {
						Thread.sleep(17);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		gameThread.start();
	}
}
