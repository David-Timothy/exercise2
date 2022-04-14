package exercise2;

import java.util.Scanner;

public enum rockPaperScissors {
	Rock, Paper, Scissors;
	
	static rockPaperScissors select(int selector) {
		System.out.println(selector);
		switch(selector) {
			case 1 :
				return Rock;
			case 2 :
				return Paper;
			case 3 :
				return Scissors;
		}
		return null;
	}
	
	static rockPaperScissors randomChoice() {
		return select((int) Math.ceil(Math.random()*3));
	}
	
	static rockPaperScissors playerChoice(Scanner sc) {
		return select (
		Integer.parseInt(sc.nextLine()) //reads string.
				);
	}
	
	boolean winsAgainst(rockPaperScissors otherChoice) {
		switch (this) {
		case Paper:
			return otherChoice == Rock;
		case Rock:
			return otherChoice == Scissors;
		case Scissors:
			return otherChoice == Paper;
		default:
			return false;
		}
	};
	
	public static int roundAgainstCPU(Scanner sc) {
		System.out.println("\n\nPick your move");
        System.out.println("1 : Rock");
        System.out.println("2 : Paper");
        System.out.println("3 : Scissors");
        rockPaperScissors player = playerChoice(sc);
        rockPaperScissors cpu = randomChoice();
        System.out.println("\nPlayer chose : "+player+" | Computer chose : "+cpu);
        if(player.winsAgainst(cpu)) {
        	System.out.println("Player Wins");
        	return 1;
        } else if (cpu.winsAgainst(player)) {
        	System.out.println("Computer Wins");
        	return -1;
        } else {
        	System.out.println("Tie");
        	return 0;
        }
	}
}
