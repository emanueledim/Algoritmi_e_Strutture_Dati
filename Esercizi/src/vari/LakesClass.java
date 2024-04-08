package vari;

/*
 * UVa 722
 */
public class LakesClass {

	public static final int[] DIRECTIONS_ROW = {-1, 0, 1, 0};
	public static final int[] DIRECTIONS_COL = {0, 1, 0, -1};
	public static final int DIRECTIONS = 4;
	
	public static void main(String[] args) {
		
	}

	public static class PairInt{
		public int R;
		public int C;
		public PairInt(int r, int c) {
			R=r;
			C=c;
		}
	}
	
	public static void AreaLake(int[][] region, int ROWS, int COLUMS, PairInt prev_cell, PairInt[] solution, int r) {
		if(false) {
			
		}else {
			for(int i=0; i<DIRECTIONS; i++) {
				int next_row = prev_cell.R+DIRECTIONS_ROW[i];
				int next_col = prev_cell.R+DIRECTIONS_COL[i];
				PairInt actual_cell = new PairInt(next_row, next_col);
				solution[r++] = actual_cell;
				if(isValid(region, solution, r)) {
					AreaLake(region, ROWS, COLUMS, actual_cell, solution, r);
				}
				solution[r--] = null;
			}
		}
	}

	private static boolean isValid(int[][] region, PairInt[] solution, int r) {
		if(region[solution[r-1].R][solution[r-1].C] == 1) {
			return false;
		}
		return true;
	}
}
