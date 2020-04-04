package game.item;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.ui.MainCanvas;

// 문제와 보기를 한 번에 관리하는 매니저 클래스로
// 각 출력 위치를 여기에서 잡아준다
public class QuestionManager {

	public static final int ITEM_COUNT = 4;
	public static final int QUESTION_COUNT = 20;

	private final int DISTANCE = 70;
	private final int ANSWER_FIRST_Y = 420;

	// 이미지 출력을 위한 경로 저장
	private String path;
	private FileReader fileReader;
	private BufferedReader reader;

	private FileReader fileReader2;
	private BufferedReader reader2;

	// 문제, 보기 이미지
	private Image questionImg;
	private Image answerBoxImg;

	private Movable[] items;

	private int[] answerArray;

	private int questionX;
	private int questionY;
	private int answerX;
	private int answerY;
	private int pageCount;
	private int chapter;

	private String quStringPath2;

	public QuestionManager(int chapter) {
		String step="";
		this.chapter = chapter;
		switch(chapter) {
		case 1:
			step = "step01/";
			break;
		case 2:
			step = "step02/";
			break;
		case 3:
			step = "step03/";
			break;
		case 4:
			step = "step04/";
			break;			
		}
		
		int itemIndex = 0;
		
		// 페이지를 체크하기 위함
		pageCount = 0;
		questionX = 30;
		questionY = 200;
		
		answerArray = new int[QUESTION_COUNT];
		
		try {
			path = "res/";
			StringBuilder chapterPath = new StringBuilder(path);			
			
			// res/step01/ 등으로 경로 설정됨
			path = chapterPath.append(step).toString();
			
			// 각 챕터의 문제 불러오기(problem.txt)
			fileReader = new FileReader(new File(path + "problem.txt"));
			fileReader2 = new FileReader(new File(path + "explanation.txt"));

			// problem.txt의 내용을 readLine()으로 파일을 한 줄씩 읽는다
			reader = new BufferedReader(fileReader);
			String questImgPath= reader.readLine();
			
			// 해설 텍스트 파일을 읽어서 저장
			reader2 = new BufferedReader(fileReader2);
			quStringPath2 = reader2.readLine();

			// 문제 이미지
			questionImg = ImageIO.read(new File(path + questImgPath));
			answerBoxImg = ImageIO.read(new File("res/image/button/answer.jpg"));
		
			items = new Movable[ITEM_COUNT];
			items[itemIndex++] = new Question(questionX, questionY, questionImg);			
			
			// 세 개의 보기 설정
			String answerImagePath;
			String answerString;
			Image answerImage;
			while (itemIndex < ITEM_COUNT) {
				Answer answer;
				if (chapter == 1) {
					answerImagePath = path + reader.readLine(); 
					answerImage = ImageIO.read(new File(answerImagePath));
					answer = new Answer(answerBoxImg, answerImage, itemIndex);
				} else {
					answerString = reader.readLine(); 
					answer = new Answer(answerBoxImg, answerString, itemIndex);
				}
				answerX = MainCanvas.getImage().getWidth(MainCanvas.getInstance()) / 2
						- answer.getImage().getWidth(MainCanvas.getInstance()) / 2;
				answerY = ANSWER_FIRST_Y + DISTANCE * itemIndex;
				answer.setPostion(answerX, answerY);
				items[itemIndex++] = answer;			
			}
			
			// 문제의 답 설정
			int answerIndex = 0;
			FileReader answerReader = new FileReader(new File(path + "answer.txt"));
			BufferedReader answerBufReader = new BufferedReader(answerReader);
			while(answerIndex < QUESTION_COUNT) {
				answerArray[answerIndex++] = Integer.parseInt(answerBufReader.readLine());
			}
			++pageCount;
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 
	public String getStringPath() {
		return quStringPath2;
	}

	// next 버튼을 누르면 호출되는 함수
	public void goToNextPage() {
		if (pageCount++ < QUESTION_COUNT) {
			try {
				quStringPath2 = reader2.readLine();
				String questImgPath;
				int itemIndex = 0;
				questImgPath = reader.readLine();
				questionImg = ImageIO.read(new File(path + questImgPath));
				Question question = (Question) items[itemIndex++];
				question.set(questionX, questionY, questionImg);
				
				String answerImagePath;
				String answerString;
				while (itemIndex < ITEM_COUNT) {
					Answer answer = (Answer)items[itemIndex];
					if (chapter == 1) {
						answerImagePath = path + reader.readLine();
						Image answerImage = ImageIO.read(new File(answerImagePath));
						answer.set(answerImage, answerBoxImg);
					}
					else {
						answerString = reader.readLine();
						answer.set(answerString, answerBoxImg);
					}
					++itemIndex;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Movable[] getItems() {
		return items;
	}

	public int[] getAnswerArray() {
		return answerArray;
	}
}