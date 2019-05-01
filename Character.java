
abstract class  Character {
	private String playerName = "Default";
	private int health = 0;
	private int level = 0;
	private int combo = 0;
	private int currentMove = 0;
	private int actionOneCount = 0;		//Rock
	private int actionTwoCount = 0;		//Paper
	private int actionThreeCount = 0;	//Scissors
	
	public Character() {};
	
	public void quickSetup(String playerName,int health, int level, int combo, int currentMove, int actionOneCount, int actionTwoCount, int actionThreeCount) {
		this.playerName = playerName;
		this.health = health;
		this.level = level;
		this.combo = combo;
		this.currentMove = currentMove;
		this.actionOneCount = actionOneCount;
		this.actionTwoCount = actionTwoCount;
		this.actionThreeCount = actionThreeCount;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getActionOneCount() {
		return actionOneCount;
	}
	public void setActionOneCount(int actionOneCount) {
		this.actionOneCount = actionOneCount;
	}
	public int getActionTwoCount() {
		return actionTwoCount;
	}
	public void setActionTwoCount(int actionTwoCount) {
		this.actionTwoCount = actionTwoCount;
	}
	public int getActionThreeCount() {
		return actionThreeCount;
	}
	public void setActionThreeCount(int actionThreeCount) {
		this.actionThreeCount = actionThreeCount;
	}
	public int getCurrentMove() {
		return currentMove;
	}
	public void setCurrentMove(int currentMove) {
		this.currentMove = currentMove;
	}
	public int getCombo() {
		return combo;
	}
	public void setCombo(int combo) {
		this.combo = combo;
	}
	
	
}
