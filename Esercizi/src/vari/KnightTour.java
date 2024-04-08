package vari;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a chessboard, print all sequences of moves of a knight on a
 * chessboard such that the knight visits every square only once.
 * Begin from 0,0
 */
public class KnightTour {

	public static final int N = 8;
	
	public KnightTour() {
	
	}

	public static void main(String[] args) {
		int[][] board = new int[N][N];
		List<List<Integer>> results = new ArrayList<>();
		foo(board, 0, 0, N, N, 1, results);
		return;
	}

	public static void foo(int[][] board, int row, int col, int ROWS, int COLUMS, int count, List<List<Integer>> results) {
/*		if(isFull()) {
			results = new ArrayList<>();
			saveResult();
		}else {
			board[row][col] = count;
			count++;
			if(isValid(board, row, col)) {
				if(row-2 >= 0) {		//Se ho due spazi sopra
					if(col-1 >= 0) {	//Se ho uno spazio a sinistra
						if(board[row-2][col-1] == -1) {	//Se è libera
							foo(board, row-2, col-1, count, results);			//Allora posso muovermi
						}
					}
					if(col+1 < COLUMS) {		//Se ho uno spazio a destra
						if(board[row-2][col+1] == -1) {	//Se è libera
							foo(board, row-2, col+1, count, results);;			//Allora posso muovermi
						}
					}
				}
				if(row-1 >= 0) {		//Se ho due spazi sopra
					if(col+1 < col) {	//Se ho uno spazio a sinistra
						if(board[row-2][col-1] == -1) {	//Se è libera
							canContinue = true;			//Allora posso muovermi
						}
					}
					if(col+1 < col) {		//Se ho uno spazio a destra
						if(board[row-2][col+1] == -1) {	//Se è libera
							canContinue = true;			//Allora posso muovermi
						}
					}
				}
				if(row-2 >= 0) {		//Se ho due spazi sopra
					if(col-1 >= 0) {	//Se ho uno spazio a sinistra
						if(board[row-2][col-1] == -1) {	//Se è libera
							canContinue = true;			//Allora posso muovermi
						}
					}
					if(col+1 < col) {		//Se ho uno spazio a destra
						if(board[row-2][col+1] == -1) {	//Se è libera
							canContinue = true;			//Allora posso muovermi
						}
					}
				}
				if(row-2 >= 0) {		//Se ho due spazi sopra
					if(col-1 >= 0) {	//Se ho uno spazio a sinistra
						if(board[row-2][col-1] == -1) {	//Se è libera
							canContinue = true;			//Allora posso muovermi
						}
					}
					if(col+1 < col) {		//Se ho uno spazio a destra
						if(board[row-2][col+1] == -1) {	//Se è libera
							canContinue = true;			//Allora posso muovermi
						}
					}
				}
			}
			undo
		}
	}
	
	private static boolean isValid(int[][] board, int row, int col) {
		boolean canContinue = false;
		if(row-2 >= 0) {		//Se ho due spazi sopra
			if(col-1 >= 0) {	//Se ho uno spazio a sinistra
				if(board[row-2][col-1] == -1) {	//Se è libera
					canContinue = true;			//Allora posso muovermi
				}
			}
			if(col+1 < col) {		//Se ho uno spazio a destra
				if(board[row-2][col+1] == -1) {	//Se è libera
					canContinue = true;			//Allora posso muovermi
				}
			}
		}
		if() {} //Come sopra, ma variano le condizioni delle altre 6 celle 
		if() {}
		if() {}
		return canContinue;*/
	}

	public static void saveResult(int[][] board) {}
	
	public static boolean isFull(int[][] board) {
		boolean isFull = true;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(board[i][j] == -1) {
					isFull = false;
				}
			}
		}
		return isFull;
	}
}
