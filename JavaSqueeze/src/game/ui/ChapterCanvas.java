package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import game.item.Button;

public class ChapterCanvas extends Canvas {
	private static ChapterCanvas canvas;
	private int state = 0;
	private Button[] chapterButton;
	private Button[] chapterButtonOff;
	Clip clip = AudioSystem.getClip();
	private Image backImage;

	private int chapterCount;

	public ChapterCanvas() throws UnsupportedAudioFileException, LineUnavailableException {

		canvas = this;
		chapterCount = 4;
		chapterButton = new Button[chapterCount];
		chapterButtonOff = new Button[4];

		try {
			backImage = ImageIO.read(new File("res/image/chapter/chapter_bg.jpg"));
			
			// 챕터 선택 버튼 이미지 불러오기
			String path = "res/image/chapter/chapter_bt";
			for (int i = 0; i < chapterCount; ++i) {
				StringBuilder sb = new StringBuilder(path);
				sb.append(i + 1);
				sb.append(".png");
				Button button = new Button();
				Image image = ImageIO.read(new File(sb.toString()));
				button.setImage(image);
				chapterButton[i] = button;
			}
			path = "res/image/chapter/chapter_btoff";
			for (int i = 0; i < chapterCount; ++i) {
				StringBuilder sb = new StringBuilder(path);
				sb.append(i + 1);
				sb.append(".png");
				Button button = new Button();
				Image image2 = ImageIO.read(new File(sb.toString()));
				button.setImage(image2);
				chapterButtonOff[i] = button;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		setSize(backImage.getWidth(this), backImage.getHeight(this));
		
		// 각 챕터 이미지 위치 설정하기
		chapterButton[0].setPostion(40, 160);
		chapterButton[1].setPostion(260, 160);
		chapterButton[2].setPostion(40, 460);
		chapterButton[3].setPostion(260, 460);
		
		addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if (chapterButton[0].contains(e.getX(), e.getY())) {
					state = 1;

				}
				if (chapterButton[1].contains(e.getX(), e.getY())) {
					state = 2;

				}
				if (chapterButton[2].contains(e.getX(), e.getY())) {
					state = 3;

				}
				if (chapterButton[3].contains(e.getX(), e.getY())) {
					state = 4;

				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				state = 0;
				for (int i = 0; i < chapterCount; ++i) {
					int x = e.getX();
					int y = e.getY();
					if (chapterButton[i].contains(x, y)) {
						clip.close();
						QuizFrame.getInstance().changeCanvas(i + 1);
					}
				}
			}
		});
	}
	
	public void start() {
		File file = new File("res/Music/chapterMusic.wav");
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					update();
					repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	public void update() {
		
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
		
		// 챕터 이미지
		for (int i = 0; i < chapterCount; ++i) {
			if(i==state-1)
				gg.drawImage(chapterButtonOff[i].getImage(), chapterButton[i].getX(), chapterButton[i].getY(), this);
			else	
			gg.drawImage(chapterButton[i].getImage(), chapterButton[i].getX(), chapterButton[i].getY(), this);
		}
		g.drawImage(buf, 0, 0, this);
	}
}
