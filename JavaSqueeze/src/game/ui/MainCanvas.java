package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import game.item.Answer;
import game.item.Button;
import game.item.MessageWithLink;
import game.item.Movable;
import game.item.ProcessBar;
import game.item.QuestionManager;

public class MainCanvas extends Canvas {
	private int state = 0;

	private static MainCanvas canvas;
	// 배경 이미지
	private static Image backImage;
	
	//음악
	Clip clip = AudioSystem.getClip();

	// 정답을 보여주는 보기 이미지(초록색)
	private static Image correctImage;
	
	// 오답을 보여주는 보기 이미지(빨간색)
	private static Image incorrectImage;
	
	// 진행률을 표시하는 이미지들을 담아놓은 배열	
	private Image[] barImages;
	
	// next 버튼 이미지
	private Image nextButtonImage;
	private Image nextButtonImage2;

	// home 버튼 이미지
	private Image homeButtonImage;
	
	// 문제, 보기를 관리하는 클래스
	private QuestionManager questionMgr;	
	
	// 문제의 진행률을 알려주는 프로세스 바
	private ProcessBar processBar;
	
	// next 버튼
	private Button nextButton;
	
	// home 버튼
	private Button homeButton;
	
	// Movable 인터페이스를 상속함
	private Movable[] items;
	
	// 문제와 보기를 관리하는 인터페이스 배열
	// 각각 Question 클래스, Answer 클래스로
	private int itemIndex;
	
	// 답 정보를 미리 담아두는 배열
	private int[] answerArray;
	private int questionIndex;
	
	// 버튼의 좌표
	private int nextButtonX;
	private int nextButtonY;
	private int homeButtonX;
	private int homeButtonY;
	
	static {
		try {
			correctImage 	= ImageIO.read(new File("res/image/button/correct.jpg"));
			incorrectImage 	= ImageIO.read(new File("res/image/button/incorrect.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public MainCanvas() throws UnsupportedAudioFileException, LineUnavailableException {
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (nextButton.contains(e.getX(), e.getY())) {
					state = 1;
				} else {
					state = 0;
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// next 버튼을 클릭하면 다음 페이지로 넘어감
				// 각 페이지 마다 답을 미리 알고 있어야 하므로
				// answerArray 배열에 답을 넣어놨음
				// 각 문제에 대한 답은 questionIndex를 이용해 접근
				state = 0;

				if (nextButton.contains(e.getX(), e.getY())) {
		               if (questionIndex < QuestionManager.QUESTION_COUNT - 1) {
		                  questionMgr.goToNextPage();
		                  ++questionIndex;
		               } else if (questionIndex == QuestionManager.QUESTION_COUNT - 1) {
		                  int result = JOptionPane.showConfirmDialog(QuizFrame.getInstance(), "마지막 문제입니다.\nYes를 누르면 처음화면으로 돌아갑니다.");		                                 
		                  if(result == 0) {
		                     QuizFrame.getInstance().changeCanvas(5);
		                  }
		               } else {
		                  return;
		               }
		            }
				
				if (homeButton.contains(e.getX(), e.getY())) {
					QuizFrame.getInstance().changeCanvas(5);
					clip.close();
				}
				
				// items 배열이 0번에 Question가 들어있고
				// 1번 요소부터 3번 요소까지가 Answer 객체이기 때문에 
				// 반복문의 인덱스를 1부터 시작
				// 어떤 보기이든 클릭이 되면 flag를 true로 설정하고
				// 정답은 초록색, 오답은 빨간색으로 보기 이미지 변경
				boolean isClicked = false;
				boolean isCorrect = false;
				
				for (int i = 1; i < QuestionManager.ITEM_COUNT; ++i) {
					Answer answer = (Answer) items[i];
					if (answer.contains(e.getX(), e.getY())) {
						isClicked = true;
						if (answer.getIndex() == answerArray[questionIndex]) {
							isCorrect = true;
						}
					}
				}
				
				if (isClicked) {
					Image img;
					for (int i = 1; i < QuestionManager.ITEM_COUNT; ++i) {
						Answer answer = (Answer) items[i];
						if (answer.getIndex() == answerArray[questionIndex]) {
							img = correctImage;
						} else {
							img = incorrectImage;
						}
						answer.setImage(img);
					}
					if (isCorrect) {
						Sound("res/Music/right.wav", false);
					} else {
						Sound("res/Music/warning.wav", false);
					}
					// 정답 보여준 후 해설 문구 띄우는 부분
					String path = questionMgr.getStringPath();
					if (path.contains("http")) {
						StringBuilder link = new StringBuilder("<a href=\"");
						link.append(path);
						link.append("\">");
						link.append(path);
						link.append("</a>");
						JOptionPane.showMessageDialog(null, new MessageWithLink(link.toString()), 
			                     "해설",JOptionPane.INFORMATION_MESSAGE, null);
					} else {
						JOptionPane.showMessageDialog(null,path , 
			                     "해설",JOptionPane.INFORMATION_MESSAGE, null);						
					}

				}				
			}
		});
	}
	
	public void init(int step) {
		nextButtonX = 122;
		nextButtonY = 700;
		homeButtonX = 30;
		homeButtonY = 30;
		questionIndex = 0;
		canvas = this;

		// ProcessBar 객체를 생성하면 이미지를 자동으로 만들고
		// 이미지 배열을 getter로 얻어낸다
		String path = "res/image/background/";
		switch(step) {
		case 1:
			path += "step01/bg_step1.jpg";
			break;
		case 2:
			path += "step02/bg_step2.jpg";
			break;
		case 3:
			path += "step03/bg_step3.jpg";
			break;
		case 4:
			path += "step04/bg_step4.jpg";
			break;
		}
		try {
			backImage  = ImageIO.read(new File(path));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		processBar = new ProcessBar(step);
		barImages = processBar.getImages();
		// 캔버스 사이즈 설정
		setSize(500, 800);

		try {
			nextButtonImage = ImageIO.read(new File("res/image/button/next.png"));
			homeButtonImage = ImageIO.read(new File("res/image/button/home.png"));
			nextButtonImage2 = ImageIO.read(new File("res/image/button/nextoff.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nextButton = new Button(nextButtonX, nextButtonY);
		nextButton.setImage(nextButtonImage);
		homeButton = new Button(homeButtonX, homeButtonY);
		homeButton.setImage(homeButtonImage);
		
//		font = new Font("메이플스토리", Font.BOLD, 14);
//		setFont(font);

		// 문제와 보기들을 관리하는 매니저 클래스
		questionMgr = new QuestionManager(step);
		
		// 답안지 정보
		answerArray = questionMgr.getAnswerArray();
		
		// 문제와 보기 
		items = questionMgr.getItems();
	}

//	public static int getFontSize() {
//		return font.getSize();
//	}

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
		for (int i = 0; i < QuestionManager.ITEM_COUNT; ++i) {
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
		gg.drawImage(backImage, 0, 60, this);
		
		// 진행률
		gg.drawImage(barImages[questionIndex], 0, 0, this);
		
		// 홈 버튼
		gg.drawImage(homeButtonImage, homeButtonX, homeButtonY, this);
		
		// 기본 버튼 이미지
		if (state == 0) {
			gg.drawImage(nextButtonImage, nextButtonX, nextButtonY, this);
		} else if (state == 1) {
			gg.drawImage(nextButtonImage2, nextButtonX, nextButtonY, this);
		}
		for (int i = 0; i < QuestionManager.ITEM_COUNT; ++i) {
			items[i].draw(gg);
		}
		g.drawImage(buf, 0, 0, this);
	}

	public void Sound(String file, boolean Loop) {

		// 사운드 재생용 메소드
		// 메인 클래스에 추가로 메소드를 하나 더 만들었습니다.
		// 사운드 파일을 받아들여 해당 사운드를 재생시킨다.
		Clip clip;
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(file)));
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
			if (Loop) {
				clip.loop(-1);				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}