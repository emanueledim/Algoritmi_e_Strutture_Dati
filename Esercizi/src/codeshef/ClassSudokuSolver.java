package codeshef;

//https://www.codechef.com/submit/J1

/*

.8....2..
.1....5..
..34..7..
..9.5....
.2...46..
3........
9...2....
.........
......4.7

 */

public class ClassSudokuSolver {

	public ClassSudokuSolver() {
		// TODO Auto-generated constructor stub
	}
	//Come verifico la correttezza?
	public static void main(String[] args) {
/*		char[][] board = {
				{'.','8','.','.','.','.','2','.','.'},
				{'.','1','.','.','.','.','5','.','.'},
				{'.','.','3','4','.','.','7','.','.'},
				{'.','.','9','.','5','.','.','.','.'},
				{'.','2','.','.','.','4','6','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','2','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','4','.','7'}};
*/		
		char[][] board = {
				{'3','.','6','5','.','8','4','.','.'},
				{'5','2','.','.','.','.','.','.','.'},
				{'.','8','7','.','.','.','.','3','1'},
				{'.','.','3','.','1','.','.','8','.'},
				{'9','.','.','8','6','3','.','.','5'},
				{'.','5','.','.','9','.','6','.','.'},
				{'1','3','.','.','.','.','2','5','.'},
				{'.','.','.','.','.','.','.','7','4'},
				{'.','.','5','2','.','6','3','.','.'}};
	/*	char[][] board = new int[][] {
            { '3', '.', '6', '5', 0, 8, 4, 0, 0 },
            { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
            { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
            { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
            { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
            { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
            { 0, 0, 5, 2, 0, 6, 3, 0, 0 }
        };
/*
		char[][] board = {
				{'.','.','4','.','.','.','8','.','.'},
				{'5','.','.','4','6','.','3','9','2'},
				{'6','.','.','7','.','2','.','.','5'},
				{'1','9','.','.','7','4','.','.','.'},
				{'7','.','6','3','.','9','1','.','8'},
				{'.','.','.','8','5','.','.','6','7'},
				{'3','.','.','5','.','7','.','.','1'},
				{'9','1','5','.','8','6','.','.','4'},
				{'.','.','7','.','.','.','2','.','.'}};
*/		Sudoku sudoku = new Sudoku(board);
		SudokuSolver(sudoku, 0, null, 0, 1);
	}
		
	static class Sudoku{
		public char[][] board;

		public Sudoku(){
			board = new char[9][9];
		}
		    
		public Sudoku(char[][] b){
			board = b;
		}

		public boolean isComplete() {
			return false;
		}
	}
	
	//sudoku: oggetto della board, row: riga attuale da tentare, col: colonna attuale da tentare
	//line: linea che si sta tentando, k: riempiemento line, n: numero che si sta inserendo per tentare
	public static void SudokuSolver(Sudoku sudoku, int row, char[] line, int r, int n){
		if(r == 9) {
			sudoku.board[row] = line;
			r = 0;
			row++;
		}
		if(row == 9) {	//Se sono fuori board (righe= 0..8, 9 è out of bounds)
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(sudoku.board[i][j]+" ");
				}
				System.out.println();
			}
	        System.out.println("----------");
	    }else{
			if(r == 0) {
				line = sudoku.board[row];
			}
	    	
	    	if(isFree(line, r)) {
	    		for(int i=1; i<=9; i++) {
		    		line[r] = (char)(i+48);			
				    if(isValid(sudoku, row, line, r)) {
				    	SudokuSolver(sudoku, row, line, r+1, 1);
				    }
				    line[r] = '.';
	    		}
	    	}else {
	    		SudokuSolver(sudoku, row, line, r+1, 1);
	    	}
	    }
	}	

	public static boolean isFree(char[] line, int r) {
		return line[r] == '.';
	}
	
	private static boolean isValid(Sudoku sudoku, int row, char[] line, int r) {
		//Dato un sudoku, verifico se è corretto
		char elem = line[r];
		boolean valid = true;
		sudoku.board[row] = line;
		for(int i=0; i<9; i++) {
			if(i != r) {
				if(sudoku.board[row][i] == elem) {
					valid = false;
				}
			}
		}
		
		for(int i=0; i<9; i++) {
			if(i != row) {
				if(sudoku.board[i][r] == elem) {
					valid = false;
				}
			}
		}
		
		int col_offset = r/3;
		int row_offset = row/3;
		int count=0;
		for(int i=0; i<9; i++) {
				if(sudoku.board[i/3+row_offset*3][i%3+col_offset*3] == elem) {
					count++;
				}
			}
	
		if(count >= 2) {
			valid = false;
		}
		return valid;
	}
}
