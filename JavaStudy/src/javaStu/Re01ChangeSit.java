package javaStu;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Re01ChangeSit {

	 public static void main(String[] args) throws FileNotFoundException {
		
		String[] name = new String[5];
		
		Scanner scan = new Scanner(new FileInputStream("res\name.txt"));
		
		// 명단이 한줄씩 되어 있으니..Line으로 받는다.
		for (int i = 0; scan.hasNextLine(); i++) {
			name[i] = scan.nextLine();
		}
		
		
	}

}
