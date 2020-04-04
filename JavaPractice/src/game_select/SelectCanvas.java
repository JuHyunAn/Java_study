package game_select;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import game_Intro.GameFrame;

public class SelectCanvas extends Canvas {
	
	private static SelectCanvas canvas;	// 캔버스 사용을 위해 전역변수로 싱글 톤
	
	private Showable2[] items;	// 인터페이스 생성
	private int unitIndex = 0;
	private SelectBackground backImage;	// 캔버스에 표현하고자 하는 객체를 참조
	private SelectButton selectButton;
	private SelectButton2 selectButton2;
	private SelectButton3 selectButton3;
	private SelectButton4 selectButton4;
	private Cursor cursor, cursor2;
	
	// 선언된 객체 실체화
	public SelectCanvas() {
		// TODO Auto-generated constructor stub
		canvas = this;	// 여기서 다시 new를 해주면, 위 싱글 톤 해준 변수와 다르게 생성되기 때문에 this를 써서 자신임을 명시
		backImage = new SelectBackground();
		selectButton = new SelectButton();
		selectButton2 = new SelectButton2();
		selectButton3 = new SelectButton3();
		selectButton4 = new SelectButton4();
		cursor = new Cursor(Cursor.HAND_CURSOR);
		cursor2 = new Cursor(Cursor.DEFAULT_CURSOR);
		

		// 인터페이스에 추가될 객체의 수 만큼 배열 크기를 설정 (추후를 생각하여 여유롭게 설정)
		items = new Showable2[100];
		
		// 인터페이스에 객체를 대입하여 적용
		items[unitIndex++] = backImage;
		// 버튼을 배열에 추가
		items[unitIndex++] = selectButton;
		items[unitIndex++] = selectButton2;
		items[unitIndex++] = selectButton3;
		items[unitIndex++] = selectButton4;
		
		// 마우스 올렸을 때 
		// 중복되는게 많아서 나중에 정리할 수 있으면 정리해야 될 것 같다...
		this.addMouseListener(new MouseAdapter() {
			
			// 마우스 클릭 이벤트 생성 (클릭 시, 버튼 이미지 변경 + 다음 페이지로 이동되도록)
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (selectButton.contains(e.getX(), e.getY())) {
					// Frame에 있는 페이지 이동 연결
					SelectFrame.getInstance().changeCanvas(2);
				}
				if (selectButton2.contains(e.getX(), e.getY())) {
				}
				if (selectButton3.contains(e.getX(), e.getY())) {
				}
				if (selectButton4.contains(e.getX(), e.getY())) {
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (selectButton.contains(e.getX(), e.getY())) {
					selectButton.setStateValue(selectButton.STATE_CLICK);
				}
				if (selectButton2.contains(e.getX(), e.getY())) {
					selectButton2.setStateValue(selectButton2.STATE_CLICK);
				}
				if (selectButton3.contains(e.getX(), e.getY())) {
					selectButton3.setStateValue(selectButton3.STATE_CLICK);
				}
				if (selectButton4.contains(e.getX(), e.getY())) {
					selectButton4.setStateValue(selectButton4.STATE_CLICK);
				}
				setCursor(cursor);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if (selectButton.contains(e.getX(), e.getY())) {
					selectButton.setStateValue(selectButton.STATE_ON);
				}
				if (selectButton2.contains(e.getX(), e.getY())) {
					selectButton2.setStateValue(selectButton2.STATE_ON);
				}
				if (selectButton3.contains(e.getX(), e.getY())) {
					selectButton3.setStateValue(selectButton3.STATE_ON);
				}
				if (selectButton4.contains(e.getX(), e.getY())) {
					selectButton4.setStateValue(selectButton4.STATE_ON);
				}
			}
		});
		
		// 마우스를 버튼 위로 이동 시켰을때
		this.addMouseMotionListener(new MouseAdapter() {
			
			// 마우스 무브 이벤트 생성 (마우스를 해당 영역에 올렸을 때 색이 바뀌도록)
			
			////// 움직일때마다 커서가 반복되서 바뀌네..? 고민이 필요한거 같다. //////
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if (selectButton.contains(e.getX(), e.getY())) {
					selectButton.setStateValue(selectButton.STATE_ON);
					setCursor(cursor);
				}
				else {
					selectButton.setStateValue(selectButton.STATE_OFF);
					setCursor(cursor2);
				}
			
				if (selectButton2.contains(e.getX(), e.getY())) {
					selectButton2.setStateValue(selectButton2.STATE_ON);
					setCursor(cursor);
				}
				else {
					selectButton2.setStateValue(selectButton2.STATE_OFF);
					setCursor(cursor2);
				}
				///////
				if (selectButton3.contains(e.getX(), e.getY())) {
					selectButton3.setStateValue(selectButton3.STATE_ON);
					setCursor(cursor);
				}
				else {
					selectButton3.setStateValue(selectButton3.STATE_OFF);
					setCursor(cursor2);
				}
				///////
				if (selectButton4.contains(e.getX(), e.getY())) {
					selectButton4.setStateValue(selectButton4.STATE_ON);
					setCursor(cursor);
				}
				else {
					selectButton4.setStateValue(selectButton4.STATE_OFF);
					setCursor(cursor2);
				}
			}
		});
	}
	
	public void start() {
		// TODO Auto-generated method stub
		Thread gameThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {		// 반복 갱신
//					this.repaint();	// 쓴다면, 클래스 명을 붙여서 어디 this인지를 확실히 해줘야 함
					buttonUpdate();		// 단위 백터의 움직임
					repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 		}
			}});
		gameThread.start();	// 쓰레드 시작
	}
	
	public void buttonUpdate() {
		// TODO Auto-generated method stub
		for(int i = 0; i < unitIndex; i++) {
			items[i].update();
		}
	}
	
	// 다른 클래스에서 캔버스를 사용할 수 있도록 getter 사용!
	public static SelectCanvas getInstance() {
		return canvas;
	}
	
	/////////////////////////////////////////////////
	@Override
	public void update(Graphics g) {
		
		paint(g);
	}
	/////////////////////////////////////////////////
	
	// 실제로 캔버스에 출력되도록
	// 타 클래스에서 로드, 업데이트, 드로우 된 것을 캔버스에서 페인트 한다.
	@Override
	public void paint(Graphics g) {
		// 이미지 빈거 하나 생성
		Image buff = createImage(this.getWidth(), getHeight());
		Graphics gg = buff.getGraphics();
		
		// 배열에 넣은 객체를 버퍼에 그린다.
		for(int i = 0; i < unitIndex; i++) {
			items[i].draw(gg);
		}
		g.drawImage(buff, 0, 0, this);
	}
	
}
