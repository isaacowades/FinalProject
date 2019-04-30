
//Rock = 0, Paper = 1, Scissors = 2.

import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinalProjectRoyal {
	public static void main(String[] args) {
		
		Player player = new Player();
		Opponent opponent = new Opponent();
		
		BasicLinkedList<Achievement> achivements = new BasicLinkedList<Achievement>();
		/*
		FileReader file;
		try {
			file = new FileReader("Achivements.txt");
			achivements = MakeAchivements(file);
		} catch (FileNotFoundException e1) {
			System.out.println("File Not Found");
			e1.printStackTrace();
			System.exit(0);
		}*/
		
		//Game Starts Here
		StartUpScreen(player, opponent, achivements);
	}
	
	private static void StartUpScreen(Player player, Opponent opponent, BasicLinkedList<Achievement> achivements) {
		int playerInput = 0; //Player input: 1.NewGame 2.Achievements 3.Exit
		
		playerInput = GetPlayerInput();
		
		switch (playerInput)
		{
		case 0:
			NewGame(player, opponent);
			break;
		case 1:
			Achievements(player, achivements);
			break;
		default:
			EndGame();
			break;
		}
		updateAchievements(player);
	}

	private static int GetPlayerInput() {
		return 0;
	}

	private static void NewGame(Player player, Opponent opponent) {
		boolean endGame = false; //Tells when to end the game
		boolean endRound = false; //Tells when to end the game
		boolean tie = false; //Tells when to end the game
		startup(player, opponent);
		while (endGame == false) {
			setupNewRound(player, opponent);
			while (endRound == false)
				if (opponentTurn(player, opponent)) {
					gameTie();
					endRound = true;
					tie = true;
				}
				if (playerTurn(player)) {
					gameTie();
					endRound = true;
					tie = true;
				}
		}
	}
	
	
	
	
	
	
	private static void gameTie() {
		// TODO Auto-generated method stub
		
	}

	private static boolean playerTurn(Player player) {
		boolean tie = false;
		// TODO Auto-generated method stub
		player.setCurrentMove(0); //Replace 0 with the method to get player input.
		return tie;
	}

	private static boolean opponentTurn(Player player, Opponent opponent) {
		Random rand = new Random();
		int move = 0;
		int moveOne = player.getTotalActionOneCount(); // rock 
		int moveTwo = player.getTotalActionTwoCount(); // paper
		int moveThree = player.getTotalActionThreeCount(); // scissors
		int totalMoves = moveOne+moveTwo+moveThree;
		
		if (totalMoves==0)
			move = rand.nextInt(3) + 1;
		else {
			int random = rand.nextInt(totalMoves);
			if (random<moveOne && opponent.getActionTwoCount()>0) { //rock
				move=2; //use paper
				opponent.setActionTwoCount(opponent.getActionTwoCount()-1);
			}
			else if (random<(moveOne+moveTwo) && opponent.getActionThreeCount()>0) { // paper 
				move=3; // use scissors
				opponent.setActionThreeCount(opponent.getActionThreeCount()-1);
			}
			else if (opponent.getActionOneCount()>0){
				move = 1; // use rock
				opponent.setActionOneCount(opponent.getActionOneCount()-1);
			}
			else return (true); //tie!
			}
		opponent.setCurrentMove(move);
		return (false);
	}

	private static void setupNewRound(Player player, Opponent opponent) {
		player.setLevel(player.getLevel()+1); //LEVEL UP!
		player.quickSetup("player", player.getLevel(), 0, 0, player.getLevel()+2, player.getLevel()+2, player.getLevel()+2, player.getLevel()+2);
		opponent.quickSetup("opponent", player.getLevel(), 0, 0, player.getLevel()+2, player.getLevel()+2, player.getLevel()+2, player.getLevel()+2);
	}

	private static void startup(Player player, Opponent opponent) {
		player.setTotalActionOneCount(0);
		player.setTotalActionTwoCount(0);
		player.setTotalActionTwoCount(0);
		player.quickSetup("player", 0, 0, 0, 0, 0, 0, 0);
		opponent.quickSetup("opponent", 0, 0, 0, 0, 0, 0, 0);
	}
	
	private static void updateAchievements(Player player) {
		// TODO Auto-generated method stub
		
	}
	
	private static void Achievements(Player player, BasicLinkedList<Achievement> achivements) {
		// TODO Auto-generated method stub
	}

	private static void EndGame() {
		System.exit(0);
	}
	
	static BasicLinkedList<Achievement> MakeAchivements(FileReader file) {
		BasicLinkedList<Achievement> achivements = new BasicLinkedList<Achievement>();

		// 0.NameOfAchivement, 1.GamesCount, 2.Levels, 3.Games, 4.Plays, 5.Wins
		// 6.Losses, 7.Add Action, 8.Add buy, 9.Special
		String newCardInfo[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
		return achivements;
	}
}
