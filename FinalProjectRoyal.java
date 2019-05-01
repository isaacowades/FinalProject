
//Rock = 0, Paper = 1, Scissors = 2.

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FinalProjectRoyal {
	public static void main(String[] args) {

		Player player = new Player();
		Opponent opponent = new Opponent();
		Draw draw = new Draw();

		BasicLinkedList<Achievement> achivements = new BasicLinkedList<Achievement>();
		/*
		 * FileReader file; try { file = new FileReader("Achivements.txt"); achivements
		 * = MakeAchivements(file); } catch (FileNotFoundException e1) {
		 * System.out.println("File Not Found"); e1.printStackTrace(); System.exit(0); }
		 */

		// Game Starts Here
		StartUpScreen(player, opponent, achivements, draw);
	}

	private static void StartUpScreen(Player player, Opponent opponent, BasicLinkedList<Achievement> achivements,
			Draw draw) {
		while (true) {
			draw.mainScreen();
			switch (GetPlayerInput()) // Player input: 0.NewGame 1.Achievements 2.Exit
			{
			case 0:
				NewGame(player, opponent, draw);
				break;
			case 1:
				Achievements(player, achivements, draw);
				break;
			default:
				System.exit(0);
				break;
			}
			updateAchievements(player, draw);
		}
	}

	private static void NewGame(Player player, Opponent opponent, Draw draw) {
		int winner = 1;				//-1. no winner 0.tie 1.player 2.opponent
		startup(player, opponent);
		while (winner == 1) { //while player is winning
			if (winner == 0) {player.setLevel(player.getLevel()-1); draw.message("did me");} //if tie, restart at the same level
			setupNewRound(player, opponent);
			draw.newGame();
			winner = -1; 
			while (winner == -1) { //while no winner
				draw.gameRoom(player, opponent);
				draw.opponentOptions(opponent);
				if (opponentTurn(player, opponent)) {
					gameTie();
					winner = 0; //tie
				}
				draw.playerOptions(player);
				if (playerTurn(player, draw)) {
					gameTie();
					winner = 0; //tie
				}
				draw.attack(player, opponent);
				draw.roundWinner(compare(player, opponent, draw));
				if (winner!=0)
					winner = gameWinner(player, opponent);
			}
			draw.matchWinner(winner);
		}
		draw.endGame(player);
	}
	
	
	
	
	
	
	
	
	
	
	
	

	private static int gameWinner(Player player, Opponent opponent) {
		if (player.getHealth() <= 0) {
			player.setTotalWins(player.getTotalWins() + 1);
			player.setTotalGames(player.getTotalGames() + 1);
			return 2; //opponent wins
		}
		if (opponent.getHealth() <= 0) {
			player.setTotalLosses(player.getTotalLosses() + 1);
			player.setTotalGames(player.getTotalGames() + 1);
			return 1;//player wins
		}
		return -1;
	}

	private static int compare(Player player, Opponent opponent, Draw draw) {
		int damage = 0;
		int winner = 0; // 0.tie, 1.player, 2.opponent

		if (player.getCurrentMove() == opponent.getCurrentMove())
			winner = 0; // tie
		if (player.getCurrentMove() == 1) { // player uses rock
			if (opponent.getCurrentMove() == 2)
				winner = 2; // opponent uses paper
			if (opponent.getCurrentMove() == 3)
				winner = 1; // opponent uses scissors
		}
		if (player.getCurrentMove() == 2) { // player uses paper
			if (opponent.getCurrentMove() == 1)
				winner = 1; // opponent uses rock
			if (opponent.getCurrentMove() == 3)
				winner = 2; // opponent uses scissors
		}
		if (player.getCurrentMove() == 3) { // player uses scissors
			if (opponent.getCurrentMove() == 1)
				winner = 2; // opponent uses rock
			if (opponent.getCurrentMove() == 2)
				winner = 1; // opponent uses paper
		}

		switch (winner) {
		case 0: // tie. If tie, then reset combo for all
			opponent.setCombo(0);
			player.setCombo(0);
			return winner;
		case 1: // player wins
			damage = player.getCombo() + 1; // Set damage based on player current combo
			player.setCombo(player.getCombo() + 1); // Increase player combo by 1
			opponent.setCombo(0); // Decrease opponent combo to 0
			opponent.setHealth(opponent.getHealth() - damage); // Decrease opponent health based on damage
			draw.combo(player.getCombo());
			draw.damage(damage);
			return winner;
		case 2: // opponent wins
			damage = opponent.getCombo() + 1; // Set damage based on opponent current combo
			opponent.setCombo(opponent.getCombo() + 1); // Increase opponent combo by 1
			player.setCombo(0); // Decrease player combo by to 0
			player.setHealth(player.getHealth() - damage);// Decrease opponent health based on damage
			draw.combo(opponent.getCombo());
			draw.damage(damage);
			return winner;
		}
		return winner;
	}

	private static int GetPlayerInput() {
		int cleanInput = 0;
		Scanner input = new Scanner(System.in);
		cleanInput = input.nextInt();
		return cleanInput;
	}

	private static void gameTie() {
		// TODO Auto-generated method stub

	}

	private static boolean playerTurn(Player player, Draw draw) {
		if ((player.getActionOneCount() + player.getActionTwoCount()
				+ player.getActionThreeCount()) <= 0)
			return true; // Tie, because player one has no turns left
		while (true) {
			player.setCurrentMove(GetPlayerInput()); // Replace 0 with the method to get player input.
			switch (player.getCurrentMove()) {
			case 1: //Rock
				if (player.getActionOneCount()>0) {
					player.setTotalActionOneCount(player.getTotalActionOneCount()+1);	//Increase total rock plays to +1
					player.setActionOneCount(player.getActionOneCount()-1);				//Decrease Rock moves -1
					return false;														//Return no tie
				}
				else
					draw.message("Cant use rock");
				break; 
			case 2: //paper
				if (player.getActionTwoCount()>0) {
					player.setTotalActionTwoCount(player.getTotalActionTwoCount()+1);
					player.setActionTwoCount(player.getActionTwoCount()-1);
					return false;
				}
				else
					draw.message("Cant use paper");
				break;
			case 3: //scissors
				if (player.getActionThreeCount()>0) {
					player.setTotalActionThreeCount(player.getTotalActionThreeCount()+1);
					player.setActionThreeCount(player.getActionThreeCount()-1);
					return false;
				}
				else
					draw.message("Cant use scissors");
				break;
			default:
				break;
			}
		}
	}

	private static boolean opponentTurn(Player player, Opponent opponent) {
		Random rand = new Random();
		int move = 0;
		int moveOne = player.getTotalActionOneCount(); // rock
		int moveTwo = player.getTotalActionTwoCount(); // paper
		int moveThree = player.getTotalActionThreeCount(); // scissors
		int totalMoves = moveOne + moveTwo + moveThree;

		if (totalMoves == 0)
			move = rand.nextInt(3) + 1;
		else {
			int random = rand.nextInt(totalMoves);
			if (random < moveOne && opponent.getActionTwoCount() > 0) { // rock
				move = 2; // use paper
			} else if (random < (moveOne + moveTwo) && opponent.getActionThreeCount() > 0) { // paper
				move = 3; // use scissors
			} else if (opponent.getActionOneCount() > 0) {
				move = 1; // use rock
			} else
				return (true); // tie!
		}
		if (move==1) opponent.setActionOneCount(opponent.getActionOneCount() - 1);
		if (move==2) opponent.setActionTwoCount(opponent.getActionTwoCount() - 1);
		if (move==3) opponent.setActionThreeCount(opponent.getActionThreeCount() - 1);
		
		opponent.setCurrentMove(move);
		return (false);
	}

	private static void setupNewRound(Player player, Opponent opponent) {
		player.setLevel(player.getLevel() + 1); // LEVEL UP!
		player.quickSetup("player", player.getLevel(), player.getLevel(), 0, 0, player.getLevel(),
				player.getLevel(), player.getLevel());
		opponent.quickSetup("opponent", player.getLevel(), player.getLevel(), 0, 0, player.getLevel(),
				player.getLevel(), player.getLevel());
	}

	private static void startup(Player player, Opponent opponent) {
		player.setTotalActionOneCount(0);
		player.setTotalActionTwoCount(0);
		player.setTotalActionTwoCount(0);
		player.quickSetup("player", 0, 0, 0, 0, 0, 0, 0);
		opponent.quickSetup("opponent", 0, 0, 0, 0, 0, 0, 0);
	}

	private static void updateAchievements(Player player, Draw draw) {
		// TODO Auto-generated method stub

	}

	private static void Achievements(Player player, BasicLinkedList<Achievement> achivements, Draw draw) {
		// TODO Auto-generated method stub
	}

	static BasicLinkedList<Achievement> MakeAchivements(FileReader file) {
		BasicLinkedList<Achievement> achivements = new BasicLinkedList<Achievement>();

		// 0.NameOfAchivement, 1.GamesCount, 2.Levels, 3.Games, 4.Plays, 5.Wins
		// 6.Losses, 7.Add Action, 8.Add buy, 9.Special
		String newCardInfo[] = { " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };
		return achivements;
	}
}
