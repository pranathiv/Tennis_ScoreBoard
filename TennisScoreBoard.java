/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class TennisScoreBoard {
	
	private int teamPoints[];
	private int teamGames[];
	private int teamSets[];

	public TennisScoreBoard(){
		teamPoints = new int[2];
		teamGames = new int[2];
		teamSets = new int[2];
		teamPoints[0] = 0;
		teamPoints[1] = 0;
		teamGames[0] = 0;
		teamGames[1] = 0;
		teamSets[0] = 0;
		teamSets[1] = 0;
	}

	public static String readInput(){
		Scanner s = new Scanner(System.in);
		String line;
		try {
		    line = s.nextLine();
		} catch(NoSuchElementException e){
		    line = "";
		}
		return line;
	}

	private boolean addPoint(int i){
		teamPoints[i]++;
		if( (teamPoints[i] == 4 && teamPoints[1-i] < 3) || (teamPoints[i] == 5  && teamPoints[1-i] == 3) ){
			boolean won = addGame(i);
			teamPoints[0] = 0;
			teamPoints[1] = 0;
			if (won){
			    print();
				return true;
			}
		} else if( teamPoints[i] == 4 && teamPoints[1-i] == 4 ){
			teamPoints[0] = 3;
			teamPoints[1] = 3;
		}
		print();
		return false;
	}

	public boolean addGame(int team)
	{
		teamGames[team]++;
		if((teamGames[team] >= 6)&& ((teamGames[team] - teamGames[1-team] >= 2) || (teamGames[team] == 7)))
		{
		    teamGames[0] = 0;
			teamGames[1] = 0;
			if(addSet(team)){
				return true;
			}
		}
		return false;
	}


	private boolean addSet(int i){
		teamSets[i]++;
		return teamSets[i] > 1;
	}

	public void parseScores(String points){
		for(int i=0; i<points.length(); i++){
			char pointWin = points.charAt(i);
			boolean won = addPoint((pointWin == 'A' || pointWin == 'a')?0:1);
			if(won){
			    System.out.println((pointWin == 'A' || pointWin == 'a')?"T1 Wins":"T2 Wins");
			    return;
			}
		}
	}

	private String checkReturnPoints(int points)
	{
		StringBuilder returnValue = new StringBuilder("");

		switch(points) {
		case 0:
		  returnValue.append("0");
		  break;
		  
		case 1:
		  returnValue.append("15");
		  break;

		case 2:
		  returnValue.append("30");
		  break;

		case 3:
		  returnValue.append("40");
		  break;

		case 4:
		  returnValue.append("A");
		  break; 

		case 5:
		  break;
		}

		  return returnValue.toString();
	}


	public void print(){
		System.out.println("\nT\tP\tG\tS");
		String team1Pts = checkReturnPoints(teamPoints[0]);
		String team2Pts = checkReturnPoints(teamPoints[1]);

		if(team1Pts.equals("A")){
			team2Pts = " ";
		}
		if(team2Pts.equals("A")){
			team1Pts = " ";
		}

		System.out.println("T1\t" + team1Pts + "\t" + teamGames[0] + "\t" + teamSets[0]);
		System.out.println("T2\t" + team2Pts + "\t" + teamGames[1] + "\t" + teamSets[1]);
	}

	public static void main(String[] args){
		TennisScoreBoard scoreboard = new TennisScoreBoard();
		String inputString = readInput();
		scoreboard.parseScores(inputString);
		//scoreboard.print();
	}

}