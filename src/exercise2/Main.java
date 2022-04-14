package exercise2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		boolean inGame = true;
		while(inGame) {
			System.out.println("\nWhat game would you like to play?");
        	System.out.println("1 : Rock-Paper-Scissors");
        	System.out.println("2 : Tic-Tac-Toe");
        	System.out.println("3 : Quit");
        	String game = sc.nextLine(); //reads string.
        	
        	switch(game) {
        		case "1" : RPS(sc); break;
        		case "2" : TTT(sc); break;
        		case "3" : inGame = false; break;
        	}
		}
	}
	
	public static void TTT(Scanner sc) {
		boolean playing = true;
		while(playing) {
			boolean playingX = true;
			boolean playingO = true;
			System.out.print("Play X? [Y] ");
			if(!sc.nextLine().equalsIgnoreCase("Y"))
				playingX = false;
			System.out.print("Play O? [Y] ");
			if(!sc.nextLine().equalsIgnoreCase("Y"))
				playingO = false;
			new TicTacToe(playingX, playingO, sc);
			
			System.out.print("\n\n Play Again? [Y] ");
			if(!sc.nextLine().equalsIgnoreCase("Y"))
				playing = false;
		}
	}
	
	public static void RPS(Scanner sc) {
		boolean playing = true;
		//RPS score
		int playerCounter = 0;
		int CPUcounter = 0;
		while(playing) { //while playing
			//sim a round against the CPU
			switch(rockPaperScissors.roundAgainstCPU(sc)) {
				case 0 : break; //If tie do nothing
				case -1 : CPUcounter++; break; //if CPU wins increment score
				case 1 : playerCounter++; break; //if player wins increment score
			}
			//End-Game info-dump
			System.out.println("\nPlayer wins : "+playerCounter+" | Computer wins : "+CPUcounter);
			System.out.print("Play Again? [Y] ");
			//Press "Y" to play again
			if(!sc.nextLine().equalsIgnoreCase("Y"))
				playing = false;
		}
		
	}

}
