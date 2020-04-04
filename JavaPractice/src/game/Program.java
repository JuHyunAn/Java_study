package game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class Program {

	public static void main(String[] args) {
		Frame frame = new QuizFrame();
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "이대로 안녕?");
				if (result == 0) {
					System.exit(0);
				}
			}
		});
	}
}