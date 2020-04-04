package game;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Test {

	public static void main(String[] args) throws IOException {
		FileReader fileReader = new FileReader(new File("p1.txt"));
		BufferedReader reader = new BufferedReader(fileReader);
		String string;
		Image img;
		while((string = reader.readLine()) != null) {
			System.out.println(string);
			if (string.contains(".jpg")) {
				img = ImageIO.read(new File(string));
				
			}
			else {
				System.out.println();
			}
		}
	}
}