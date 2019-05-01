
public class Draw {
	public Draw() {};
	
	public void mainScreen() {
		System.out.println("\n\n\nChoose an option: 0.NewGame 1.Achievements 2.Exit Game");
	}
	
	public void newGame() {
		System.out.println("\n\n\nGAME START!");
	}
	
	public void message(String message) {
		System.out.println(message);
	}
	
	public void combo(int combo) {
		System.out.println("COMBO x" + combo + " DAMAGE!");
	}
	
	public void damage(int damage) {
		System.out.println(damage + " DAMAGE!");
	}
	
	public void gameRoom(Player player, Opponent opponent) {
		System.out.println("Player Health:" + player.getHealth());
		System.out.println("Player Combo:" + player.getCombo());
		
		System.out.println("Opponent Health:" + opponent.getHealth());
		System.out.println("Opponent Combo:" + opponent.getCombo());
	}
	
	public void attack(Player player, Opponent opponent) {
		System.out.print("Player Used: ");
		switch (player.getCurrentMove()) {
		case 1:
			System.out.println("ROCK!");
			break;
		case 2:
			System.out.println("PAPER!");
			break;
		default:
			System.out.println("SCISSORS!");
			break;
			}
		System.out.print("Opponent Used: ");
		switch (opponent.getCurrentMove()) {
		case 1:
			System.out.println("ROCK!");
			break;
		case 2:
			System.out.println("PAPER!");
			break;
		default:
			System.out.println("SCISSORS!");
			break;
			}
	}
	
	public void playerOptions(Player player) {
		System.out.println("Choose: ");
		System.out.println("1. Rock: " + player.getActionOneCount());
		System.out.println("2. Paper: " + player.getActionTwoCount());
		System.out.println("3. Scissors: " + player.getActionThreeCount());
	}
	
	public void opponentOptions(Opponent opponent) {
		System.out.println("Opponent: ");
		System.out.println("1. Rock: " + opponent.getActionOneCount());
		System.out.println("2. Paper: " + opponent.getActionTwoCount());
		System.out.println("3. Scissors: " + opponent.getActionThreeCount());
	}
	
	public void roundWinner(int winner) {
		switch (winner) {
		case 1:
			System.out.println("Player wins this round!\n");
			break;
		case 2:
			System.out.println("Opponent wins this round!\n");
			break;
		default:
			System.out.println("No winner this round, its a Tie!\n");
			break;
			}
	}
	
	public void matchWinner(int winner) {
		System.out.print("Winner: ");
		switch (winner) {
		case 1:
			System.out.println("Player!");
			break;
		case 2:
			System.out.println("Opponent!");
			break;
		default:
			System.out.println("Tie!");
			break;
			}
	}
	
	public void endGame(Player player) {
		System.out.println("You Defeated " + (player.getLevel()-1) + " opponents!");
	}
	
	public void playerAchievements(Player player) {}
	
}
