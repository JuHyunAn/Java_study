package game;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import game.ui.QuizFrame;

public class Program {

	public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException {
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