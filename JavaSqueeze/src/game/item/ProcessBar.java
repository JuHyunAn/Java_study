package game.item;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ProcessBar {
	private Image[] images;
	
	public ProcessBar(int step) {
		String path = "res/image/background/";		
		switch(step) {
		case 1:
			path += "step01/";
			break;
		case 2:
			path += "step02/";
			break;
		case 3:
			path += "step03/";
			break;
		case 4:
			path += "step04/";
			break;
		}
		int length = QuestionManager.QUESTION_COUNT;
		images = new Image[length];
		for (int i = 0; i < length; ++i) {
			StringBuilder sb = new StringBuilder(path);
			sb.append("bg_step");
			sb.append(step);
			sb.append("_bar");
			sb.append(i+1);
			sb.append(".jpg");
			try {
				images[i] = ImageIO.read(new File(sb.toString()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	public Image[] getImages() {
		return images;
	}
}
