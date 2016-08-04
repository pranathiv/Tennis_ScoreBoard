public class TennisScoreBoard {
	
	private int team1Points;
	private int team2Points;
	private int team1Games;
	private int team2Games;
	private int team1Sets;
	private int team2Sets;

	public TennisScoreBoard();

	public String readInput(){
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}

	public void parseScores(String points){

	}

	public void print();

	public static void main(String[] args){
		TennisScoreBoard scoreboard = new TennisScoreBoard();
		String inputString = readInput();
		scoreboard.parseScores(inputString);
		scoreboard.print();
	}

}