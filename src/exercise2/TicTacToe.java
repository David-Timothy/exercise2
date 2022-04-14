package exercise2;

import java.util.Scanner;

public class TicTacToe {
	char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
	boolean Xplayer = true;
	boolean Oplayer = true;
	
	public TicTacToe(boolean xplayer, boolean oplayer, Scanner sc) {
		super();
		Xplayer = xplayer;
		Oplayer = oplayer;
		while(round(sc)) {System.out.println("");}
	}

	public void displayBoard() {
		System.out.println("|"+board[0][0]+"|"+board[0][1]+"|"+board[0][2]+"|");
		System.out.println("|"+board[1][0]+"|"+board[1][1]+"|"+board[1][2]+"|");
		System.out.println("|"+board[2][0]+"|"+board[2][1]+"|"+board[2][2]+"|");
	}
	
	public boolean round(Scanner sc) {
		if(Xturn(sc)) {
			this.displayBoard();
			System.out.println("X wins");
			return false;
		}
		this.displayBoard();
		if(tie()) {
			System.out.println("Tie");
			return false;
		}
		if(Oturn(sc)) {
			this.displayBoard();
			System.out.println("O wins");
			return false;
		}
		this.displayBoard();
		if(tie()) {
			System.out.println("Tie");
			return false;
		}
		return true;
	}
	
	/**X takes a turn
	 * @param sc
	 * Scanner
	 * @return
	 * True if X wins, otherwsie : false
	 */
	public boolean Xturn(Scanner sc) {
		return Xplayer ? playerTurn('X', sc) : cpuTurn('X');
	}
	/**O takes a turn
	 * @param sc
	 * Scanner
	 * @return
	 * True if O wins, otherwise : false
	 */
	public boolean Oturn(Scanner sc) {
		return Oplayer ? playerTurn('O', sc) : cpuTurn('O');
	}
	/**
	 * Places a piece
	 * @param player
	 * 'X' or 'O'
	 * @param row
	 * @param collumn
	 * @return true if valid space, false if invalid
	 */
	public boolean place(char player, int row, int collumn) {
		if(board[row][collumn] == ' ') {
			board[row][collumn] = player;
			return true;
		} else return false;
	}
	/**
	 * place a piece
	 * @param player
	 * 'X' or 'O'
	 * @param place
	 * @return true is valid space, false if invalid
	 */
	public boolean place(char player, int place) {
		return place(player, Math.floorDiv(place, 3), place % 3);
	}
	/**
	 * Check if a player has won
	 * @param player
	 * player we are checking
	 * @return true if they won
	 */
	public boolean checkWins(char player) {
		//Check rows
		for(int i = 0; i < 3; i++) {
			int inRow = 0;
			for(int j = 0; j < 3; j++)
				if(board[i][j] == player)
					inRow++;
			if(inRow == 3) return true;
		}
		//Check Collumns
		for(int i = 0; i < 3; i++) {
			int inCollumn = 0;
			for(int j = 0; j < 3; j++)
				if(board[j][i] == player)
					inCollumn++;
			if(inCollumn == 3) return true;
		}
		//Check diagonals
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
			return true;
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player)
			return true;
		return false;
	}
	
	/**
	 * @param player
	 * 'X' or 'O'
	 * @param sc
	 * Scanner for input
	 * @return True if the player won
	 */
	public boolean playerTurn(char player, Scanner sc) {
		System.out.println("Where will you place your "+player);
		int choice;
		//Ask player for thier choice
			 choice = Integer.parseInt(sc.next());
		while (!place(player, choice)) { //Ask again if they pick an invalid space
			System.out.println("Peice allready there");
			choice = Integer.parseInt(sc.next());
		}
		return checkWins(player);
	}
	
	/**
	 * @param cpu
	 * CPU piece
	 * @return True if the CPU wins
	 */
	public boolean cpuTurn(char cpu) {
		int choice;
		choice = (int) (Math.ceil(Math.random()*9))-1;
		while(!place(cpu, choice))
			choice = (int) (Math.ceil(Math.random()*9))-1;
		return checkWins(cpu);
	}
	
	/**
	 * @return True if the board is tied
	 */
	public boolean tie() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++)
				if(board[i][j] == ' ')
					return false;
		}
		return true;
	}
}
