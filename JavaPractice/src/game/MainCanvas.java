package game;

import java.awt.Canvas;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainCanvas extends Canvas {
	private static MainCanvas canvas;
	
	// 문제, 보기를 관리하는 클래스
	private static QuestionManager questionMgr;
	
	// 배경 이미지
	private static Image backImage;
	
	// 정답을 보여주는 보기 이미지(초록색)
	private static Image correctImage;
	
	// 오답을 보여주는 보기 이미지(빨간색)
	private static Image incorrectImage;
	
	// 기본 버튼 이미지
	private Image buttonImage;

	// 문제의 진행률을 알려주는 프로세스 바를
	private ProcessBar processBar;
	
	// 진행률을 표시하는 이미지들을 담아놓은 배열
	private Image[] barImages;
	
	// 문제와 보기를 관리하는 인터페이스 배열
	// 각각 Question 클래스, Answer 클래스로
	// Movable 인터페이스를 상속함
	private Movable[] items;
	private int itemIndex;
	
	// 답 정보를 미리 담아두는 배열
	private int[] answerArray;
	private int questionIndex;
	
	// 폰트 정보 저장
	private static Font font;
	
	// next 버튼
	private Button nextButton;
	
	// next 버튼의 위치를 잡는 좌표
	private int buttonX;
	private int buttonY;
	
	// 진행률의 위치를 잡는 좌표
	private int barX;
	private int barY;

	static {
		try {
			backImage = ImageIO.read(new File("res/image/bg.jpg"));
			correctImage = ImageIO.read(new File("res/image/correct.jpg"));
			incorrectImage = ImageIO.read(new File("res/image/incorrect.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MainCanvas(int step) {
		buttonX = 122;
		buttonY = 700;
		barX = 5;
		barY = 5;
		questionIndex = 1;
		canvas = this;

		// ProcessBar 객체를 생성하면 이미지를 자동으로 만들고
		// 이미지 배열을 getter로 얻어낸다
		processBar = new ProcessBar(step);
		barImages = processBar.getImages();
		// 캔버스 사이즈 설정
		setSize(backImage.getWidth(this), backImage.getHeight(this));

		// 보기에 적용되는 폰트
		nextButton = new Button(buttonX, buttonY);
		font = new Font("메이플스토리", Font.BOLD, 14);
		setFont(font);
		// setCursor(new Cursor(Cursor.HAND_CURSOR));

		// 문제와 보기들을 관리하는 매니저 클래스
		questionMgr = new QuestionManager(step);
		
		// 답안지 정보
		answerArray = questionMgr.getAnswerArray();
		
		// 문제와 보기 
		items = questionMgr.getItems();
		
		// next 버튼 이미지
		buttonImage = nextButton.getImage();

//		addMouseMotionListener(new MouseAdapter() {
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				if (nextButton.contains(e.getX(), e.getY())) {
//					nextButton.setState(true);
//				}
//				else {
//					nextButton.setState(false);
//				}			
//				
////				for (int i = 1; i < QuestionManager.ITEM_COUNT; ++i) {
////					Answer answer = (Answer)items[i];
////					if (answer.contains(e.getX(), e.getY())) {
////						
////					}
////				}
//			}
//		});

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// next 버튼을 클릭하면 다음 페이지로 넘어감
				// 각 페이지 마다 답을 미리 알고 있어야 하므로
				// answerArray 배열에 있는 정보는
				// questionIndex를 이용해 접근한다
				if (nextButton.contains(e.getX(), e.getY())) {
					if (questionIndex < QuestionManager.QUESTION_COUNT) {
						questionMgr.goToNextPage();
						++questionIndex;
					}
					else {
						return;
					}
				}
				
				// items 배열이 1번 요소부터 3번 요소까지가 보기라서 인덱스 1부터 시작
				// 어느 보기를 누르기만 하면 flag를 true로 설정하고
				// 정답은 초록색, 오답은 빨간색으로 보기 이미지 변경
				boolean flag = false;
				for (int i = 1; i < QuestionManager.ITEM_COUNT; ++i) {
					Answer answer = (Answer) items[i];
					if (answer.contains(e.getX(), e.getY())) {
						flag = true;
						break;
					}
				}
				if (flag) {
					for (int i = 1; i < QuestionManager.ITEM_COUNT; ++i) {
						Answer answer = (Answer) items[i];
						if (answer.getIndex() == answerArray[questionIndex]) {
							answer.setImage(correctImage);
						} else {
							answer.setImage(incorrectImage);
						}
					}
				}				
			}
		});
	}

	public static int getFontSize() {
		return font.getSize();
	}

	public static MainCanvas getInstance() {
		return canvas;
	}

	public static Image getImage() {
		return backImage;
	}

	public void start() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(35);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}

	public void update() {
		for (int i = 0; i < itemIndex; ++i) {
			items[i].update();
		}
		nextButton.update();
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		Image buf = createImage(getWidth(), getHeight());
		Graphics gg = buf.getGraphics();
		// 배경
		gg.drawImage(backImage, 0, 0, this);
		
		// 진행률
		gg.drawImage(barImages[questionIndex], barX, barY, this);
		
		// 기본 버튼 이미지
		gg.drawImage(buttonImage, buttonX, buttonY, this);
		for (int i = 0; i < itemIndex; ++i) {
			items[i].draw(gg);
		}
		g.drawImage(buf, 0, 0, this);
	}
}