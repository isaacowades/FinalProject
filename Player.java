
class Player extends Character {
	
	private int TotalActionOneCount = 0;	//Rock
	private int TotalActionTwoCount = 0;	//Paper
	private int TotalActionThreeCount = 0;	//Scissors
	
	//Achivement Variables
	private int totalMoves = 0;
	private int totalGames = 0;	
	private int totalWins = 0;
	private int totalLosses = 0;
	private int totalStreakCombo = 0;
	//Chains
	private int MaxStreakWins = 0;
	private int MaxStreakLosses = 0;
	private int MaxStreakCombo = 0;
	
	public Player() {}
	
	public int getTotalActionOneCount() {
		return TotalActionOneCount;
	}
	public void setTotalActionOneCount(int totalActionOneCount) {
		TotalActionOneCount = totalActionOneCount;
	}
	public int getTotalActionTwoCount() {
		return TotalActionTwoCount;
	}
	public void setTotalActionTwoCount(int totalActionTwoCount) {
		TotalActionTwoCount = totalActionTwoCount;
	}
	public int getTotalActionThreeCount() {
		return TotalActionThreeCount;
	}
	public void setTotalActionThreeCount(int totalActionThreeCount) {
		TotalActionThreeCount = totalActionThreeCount;
	}
}