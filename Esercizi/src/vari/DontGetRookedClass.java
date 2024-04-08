package vari;

import java.util.Scanner;

/*
 * UVa 639
 */
public class DontGetRookedClass {

	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);
		char[][] matrice = new char[4][4];
		for(int row=0; row<4; row++) {
			String buffer = scan.next();
			for(int i = 0; i<4; i++) {
				matrice[row][i] = buffer.charAt(i);
			}
		}*/
		char[][] chessBoard={{'.','X','.','.'},
							{'.','.','.','.'},
							{'X','X','.','.'},
							{'.','.','.','.'}};
		PlaceRook(chessBoard,0,0,0);
		return;
	}
	//NON FUNZIONA
	public static void PlaceRook(char[][] chessBoard, int row, int col, int rook_number) {
		if(row == chessBoard.length-1 && col == chessBoard.length) {
			//Salva soluzione
		}else {
			if(col == chessBoard.length) {	//Reimposta la colonna e imposta la riga a quella successiva
				col = 0;
				row++;
			
			}
			if(isPlaceable(chessBoard, row, col)) {
				rook_number++;
				chessBoard[row][col] = 'R';
				if(isValid(chessBoard, row, col)) {
					PlaceRook(chessBoard, row, col+1, rook_number);
				}
				rook_number--;
				chessBoard[row][col] = '.';
			}else {
				PlaceRook(chessBoard, row,col+1, rook_number);
			}		
		}
	}
	
	private static boolean isValid(char[][] chessBoard, int row, int col) {
		int i=row;
		boolean thereIsWall = false;
		while(i>-1 && !thereIsWall) { //scorro verso l'alto
			if(row != i) {
				if(chessBoard[i][col] == 'X') {
					thereIsWall = true;
				}else if(chessBoard[i][col] == 'R') {
					return false;
				}
			}
			i--;
		}
		
		
		//SCORRO VERSO DESTRA
		thereIsWall = false;
		i=col;
		while(i<chessBoard.length && !thereIsWall) {
			if(col != i) {
				if(chessBoard[row][i] == 'X') {
					thereIsWall = true;
				}else if(chessBoard[row][i] == 'R') {
					return false;
				}
			}
			i++;
		}
		
		//SCORRO VERSO IL BASSO
		i=row;
		thereIsWall = false;
		while(i<chessBoard.length && !thereIsWall) { //scorro verso l'alto
			if(row != i) {
				if(chessBoard[i][col] == 'X') {
					thereIsWall = true;
				}else if(chessBoard[i][col] == 'R') {
					return false;
				}
			}
			i++;
		}
		
		//SCORRO VERSO SINISTRA
		thereIsWall = false;
		i=col;
		while(i>-1 && !thereIsWall) {
			if(col != i) {
				if(chessBoard[row][i] == 'X') {
					thereIsWall = true;
				}else if(chessBoard[row][i] == 'R') {
					return false;
				}
			}
			i--;
		}
		return true;
	}

	private static boolean isPlaceable(char[][] chessBoard, int row, int col) {
		if(chessBoard[row][col] != 'X')
			return true;
		return false;
	}

}
