package game.ui;

import java.awt.Canvas;
import java.awt.Frame;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class QuizFrame extends Frame {
	private static QuizFrame frame;

	private MainCanvas mainCanvas;
	private ChapterCanvas chapterCanvas;
	private IntroCanvas introCanvas;
	private DeveloperCanvas developerCanvas;

	public QuizFrame() throws UnsupportedAudioFileException, LineUnavailableException {

		frame = this;
		mainCanvas = new MainCanvas();
		chapterCanvas = new ChapterCanvas();
		developerCanvas = new DeveloperCanvas();
		try {
			introCanvas = new IntroCanvas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		introCanvas.setFocusable(true);
		add(introCanvas);
		pack();
		introCanvas.start();
	}
	
	public static QuizFrame getInstance() {
		return frame;
	}
	
	public void changeCanvas(int step) {
		Canvas canvas;
		switch(step) {
		case 0:
			remove(introCanvas);
			add(chapterCanvas);
			canvas = chapterCanvas;
			chapterCanvas.start();
			break;
		case 1:
		case 2:
		case 3:
		case 4:
			mainCanvas.init(step);
			remove(chapterCanvas);
			add(mainCanvas);
			canvas = mainCanvas;
			mainCanvas.start();
			break;
		case 5:
			remove(mainCanvas);
			add(introCanvas);
			canvas = introCanvas;
			introCanvas.musicStart();
			break;
		case 6:
			remove(introCanvas);
			add(developerCanvas);
			canvas = developerCanvas;
			break;
		default: // 7
			remove(developerCanvas);
			add(introCanvas);
			canvas = introCanvas;
		}
		canvas.revalidate();		
	}
}