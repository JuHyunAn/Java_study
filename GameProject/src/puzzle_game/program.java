package puzzle_game;
import java.awt.Frame;

public class program {
	public static void main(String[] arg) {
		Frame frame = new GameFrame();
		frame.setVisible(true); // 이게 페인트를 참조 gameframe에서 
		frame.setSize(900, 800);
	}
}