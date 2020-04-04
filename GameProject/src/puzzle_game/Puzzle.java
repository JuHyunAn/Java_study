package puzzle_game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Puzzle{
	private Image img;
	private int puzzleWidth;
	private int puzzleHeight;
	private int index;
	
	public Puzzle(int index)  {
		//1.이미지가 로드 될때까지 기다려 주도록하는 방법
		//Toolkit tk = Toolkit.getDefaultToolkit();
		//img = tk.getImage("res/images/bada.jpg");
		//MediaTracker mt = new MediaTracker(this);
		//mt.addImage(img, 1);
		//mt.waitForAll();
		
		//2. img = ImageIO.read(new File("res/image/bada.jpg")); 이걸 서라운드해서 
		this.index = index;
		
		try {
			img = ImageIO.read(new File("res/image/bada.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		puzzleWidth = img.getWidth(PuzzleCanvas.getInstance())/3;
		puzzleHeight = img.getHeight(PuzzleCanvas.getInstance())/2;
	}
	
	public void draw(Graphics g) {
		g.drawImage(img,
				0, 0, puzzleWidth, puzzleHeight,
				0, 0, puzzleWidth, puzzleHeight, 
				PuzzleCanvas.getInstance());
	}

}
