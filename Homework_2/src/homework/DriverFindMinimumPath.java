package homework;

import java.util.ArrayList;
import java.util.List;

public class DriverFindMinimumPath {

	public static void main(String[] args) {
		int[][] M1 = {{1,1,1,0,1,1,1,0,1,1,1},
					  {1,1,1,1,1,1,1,1,1,1,1},
					  {1,1,1,1,1,1,1,1,1,1,1}};
		
		int[][] M2 = {{1,1,0,1,1,1,1,0,1},
					  {1,1,1,1,1,0,1,1,1},
					  {1,1,1,1,1,1,1,1,1},
					  {1,1,1,1,1,1,1,1,1},
					  {1,1,0,1,1,1,1,1,1}};
		
		int[][] M3 = {{1,1,1,1,1,0,1,1,1,1,1,1},
					  {1,1,1,1,1,1,1,1,1,1,1,1},
					  {1,1,0,1,1,1,1,1,0,1,1,1},
					  {1,1,1,1,1,1,1,1,1,1,1,1}};
		int ris;
		ris = FindMinimumPath(M1, M1.length, M1[0].length);
		System.out.println(ris);
		ris = FindMinimumPath(M2, M2.length, M2[0].length);
		System.out.println(ris);
		ris = FindMinimumPath(M3, M3.length, M3[0].length);
		System.out.println(ris);
		return;
	}
	
	public static int FindMinimumPath(int[][] M, int ROWS, int COLUMS) {
		int[][] alreadyPassed = new int[M.length][M[0].length];		
		List<Integer> path_counter = new ArrayList<>();
		for(int i=0; i<ROWS; i++) {
			for(int k=0; k<alreadyPassed.length; k++) {
				for(int n=0; n<alreadyPassed.length; n++) {
					alreadyPassed[k][n] = 0;
				}
			}
			FindMinimumPathFromFirstCol(M, alreadyPassed, i, 0, M.length, M[0].length, path_counter, 0);
		}
		return FindMin(path_counter);
	}
	

	public static void FindMinimumPathFromFirstCol(int[][] M, int[][] alreadyPassed, int row, int col, int ROWS, int COLUMS, List<Integer> path, int minimum_path) {
		if(col == COLUMS-1) {	//Se arrivo a una colonna finale ho trovato la soluzione
			minimum_path++;							//Incremento il percorso minimo (ultimo elemento)
			path.add(minimum_path);					//Salvo il risultato in path (vettore di interi)
		}else {
			minimum_path++;							//Incremento il conteggio del percorso
			alreadyPassed[row][col] = 1;			//Segno come attraversata la cella corrispondente
			if(isValid(M, row, col, ROWS, COLUMS, path, minimum_path)) {			//Se l'elemento in posizione row e col non è adiacente a uno 0 e se non sono venuto da sopra
				if(row > 0) {														//se non è la prima riga
					if(alreadyPassed[row-1][col] == 0) {							//e Se non ho ancora attraversato la riga sopra: vai alla cella di sopra
						FindMinimumPathFromFirstCol(M, alreadyPassed, row-1, col, ROWS, COLUMS, path, minimum_path);
						alreadyPassed[row-1][col] = 0;			//Segna come libero (non attraversato) la cella sopra}
					}
				}
				if(col < COLUMS-1) {
					if(alreadyPassed[row][col+1] == 0) {
						FindMinimumPathFromFirstCol(M, alreadyPassed, row, col+1, ROWS, COLUMS, path, minimum_path);
						alreadyPassed[row][col+1] = 0;
					}
					
				}
				if(row < ROWS-1) {
					if(alreadyPassed[row+1][col] == 0) {
						FindMinimumPathFromFirstCol(M, alreadyPassed, row+1, col, ROWS, COLUMS, path, minimum_path);
						alreadyPassed[row+1][col] = 0;
					}
				}
				if(col > 0) {
					if(alreadyPassed[row][col-1] == 0) {
						FindMinimumPathFromFirstCol(M, alreadyPassed, row, col-1, ROWS, COLUMS, path, minimum_path);
						alreadyPassed[row][col-1] = 0;
					}
				}
			}else {
				minimum_path--;
			}
		}
	}
	
	public static int FindMin(List<Integer> v) {
		if(v.size() == 0) return -1;
		int min = v.get(0);
		for(int i=0; i<v.size(); i++) {
			if(min > v.get(i)) {
				min = v.get(i);
			}
		}
		return min;
	}
	
	private static boolean isValid(int[][] M, int row, int col, int ROWS, int COLUMS, List<Integer> path,  int minimum_path) {
		if(row > 0) {							//Se non è la prima riga
			if(M[row-1][col] == 0) {			//Se la cella sopra è uno zero
				return false;					//Allora ritorna falso
			}
		}
		if(col < COLUMS-1) {					//Se non è l'ultima colonna
			if(M[row][col+1] == 0) {			//Se la colonna di destra è uno zero
				return false;					//allora ritorna falso
			}
		}
		if(row < ROWS-1) {						//Se non è l'ultima riga
			if(M[row+1][col] == 0) {			//Se la riga sotto è uno zero
				return false;					//allora ritorna falso
			}
		}
		if(col > 0) {							//Se non è la prima colonna
			if(M[row][col-1] == 0) {			//Se la colonna di sinistra è uno zero
				return false;					//allora ritorna falso
			}
		}
		return true;						//Ritorno vero se supera tutte le condizioni
	}
}
