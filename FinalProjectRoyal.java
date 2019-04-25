
//Rock = 0, Paper = 1, Scissors = 2.


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinalProjectRoyal {
	public static void main(String[] args) {
		BasicLinkedList<Achievement> achivements = new BasicLinkedList<Achievement>();
		
		FileReader file;
		try {
			file = new FileReader("Achivements.txt");
			achivements = MakeAchivements(file);
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found");
			e1.printStackTrace();
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
	
	static BasicLinkedList<Achievement> MakeAchivements(FileReader file) {
		BasicLinkedList<Achievement> achivements = new BasicLinkedList<Achievement>();

		// 0.NameOfAchivement, 1.GamesCount, 2.Levels, 3.Games, 4.Plays, 5.Wins
		// 6.Losses, 7.Add Action, 8.Add buy, 9.Special
		String newCardInfo[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
		return cardDeck;
	}
}
