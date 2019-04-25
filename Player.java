
class Player extends Character {
	
	private int TotalActionCount = 0;		//ALL
	private int TotalActionOneCount = 0;	//Rock
	private int TotalactionTwoCount = 0;	//Paper
	private int TotalactionThreeCount = 0;	//Scissors
	
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
	
	public void setTotalActionCount(int totalActionCount) {
		TotalActionCount = totalActionCount;
	}
	public int getTotalActionOneCount() {
		return TotalActionOneCount;
	}
	public void setTotalActionOneCount(int totalActionOneCount) {
		TotalActionOneCount = totalActionOneCount;
	}
	public int getTotalactionTwoCount() {
		return TotalactionTwoCount;
	}
	public void setTotalactionTwoCount(int totalactionTwoCount) {
		TotalactionTwoCount = totalactionTwoCount;
	}
	public int getTotalactionThreeCount() {
		return TotalactionThreeCount;
	}
	public void setTotalactionThreeCount(int totalactionThreeCount) {
		TotalactionThreeCount = totalactionThreeCount;
	}
}