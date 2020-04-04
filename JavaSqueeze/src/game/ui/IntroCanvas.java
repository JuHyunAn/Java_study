package game.ui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import game.item.DeveloperButton;
import game.item.ExitButton;
import game.item.Intro;
import game.item.Movable;
import game.item.StartButton;

public class IntroCanvas extends Canvas {
	//인트로 그리는 클래스 +음악(clip사용)
	private StartButton startButton;
	private DeveloperButton developerButton;
	private Intro intro;

	Clip clip;
	private ExitButton exitButton;
	private Movable[] items;
	private int unitIndex;

	private static IntroCanvas canvas;

	public IntroCanvas() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
		canvas = this;
		clip = AudioSystem.getClip();
		unitIndex = 0;
		items = new Movable[100];
		intro = new Intro();
		startButton = new StartButton();
		setSize(intro.getImage().getWidth(null), intro.getImage().getHeight(null));
		developerButton = new DeveloperButton();
		exitButton = new ExitButton();
		
		items[unitIndex++] = intro;
		items[unitIndex++] = startButton;
		items[unitIndex++] = developerButton;
		items[unitIndex++] = exitButton;

		File file = new File("res/Music/IntroMusic.wav");
		AudioInputStream ais = AudioSystem.getAudioInputStream(file);
		clip.open(ais);
		clip.start();

		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				StartButton stb = new StartButton();

				if (startButton.contains(e.getX(), e.getY())) {
					startButton.state(StartButton.STATE_ON);
				} else {
					startButton.state(StartButton.STATE_OFF);
				}

				if (developerButton.contains(e.getX(), e.getY())) {
					developerButton.state(developerButton.STATE_ON);

				} else {
					developerButton.state(developerButton.STATE_OFF);

				}
				if (exitButton.contains(e.getX(), e.getY())) {
					exitButton.state(exitButton.STATE_ON);

				} else {
					exitButton.state(exitButton.STATE_OFF);

				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (startButton.contains(e.getX(), e.getY())) {
					startButton.state(StartButton.STATE_OFF);
					QuizFrame.getInstance().changeCanvas(0);
					clip.close();
				} else {
					startButton.state(StartButton.STATE_OFF);
				}
				if (developerButton.contains(e.getX(), e.getY())) {

					developerButton.state(developerButton.STATE_OFF);
					QuizFrame.getInstance().changeCanvas(6);

				} else {
					developerButton.state(developerButton.STATE_OFF);
				}
				if (exitButton.contains(e.getX(), e.getY())) {
					int result = JOptionPane.showConfirmDialog(QuizFrame.getInstance(), "종료 하려구요?", "종료 버튼",
							JOptionPane.OK_CANCEL_OPTION);

					if (result == 0) {
						clip.close();
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(QuizFrame.getInstance(), "좀 더 공부하자 ^_^", "오예~!",
								JOptionPane.INFORMATION_MESSAGE);
						exitButton.state(exitButton.STATE_OFF);
					}

				} else {
					exitButton.state(exitButton.STATE_OFF);
				}

			}
		});
	}

	public void start() {

		Thread gameThread = new Thread(new Runnable() {
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
		gameThread.start();
	}

	public void musicStart() {
		File file = new File("res/Music/IntroMusic.wav");
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			clip.open(ais);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	protected void update() {

		for (int i = 0; i < unitIndex; i++)
			items[i].update();

	}

	public static IntroCanvas getInstance() {
		return canvas;
	}

	@Override
	public void update(Graphics g) {

		paint(g);
	}

	@Override
	public void paint(Graphics g) {

		Image buf = createImage(this.getWidth(), this.getHeight());
		Graphics gg = buf.getGraphics();

		for (int i = 0; i < unitIndex; i++)
			items[i].draw(gg);

		g.drawImage(buf, 0, 0, this);
	}
}
