package homework;

public class MaxSubmatrixDriver {

	public static void main(String[] args) {
		int[][] M1 = {{1,0,0},{1,0,0},{1,0,1}};
		int[][] M2 = {{1,0,0,1},{1,0,0,0},{1,0,0,0},{1,1,1,1}};
		int[][] M3 = {{1,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,1,1}};

		int z1 = FindMaxSubmatrix(M1, M1.length, M1[0].length);
		int z2 = FindMaxSubmatrix(M2, M2.length, M2[0].length);
		int z3 = FindMaxSubmatrix(M3, M3.length, M3[0].length);

		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
		return;
	}
	
	public static int FindMaxSubmatrix(int[][] M, int ROWS, int COLS) {
		int[][] A = new int[ROWS][COLS];
		if(M[0][0] == 1) {
			A[0][0] = 0;
		}
		if(M[0][0] == 0) {
			A[0][0] = 1;
		}
		for(int i=0; i<ROWS; i++) {
			if(M[i][0] == 1) {
				A[i][0] = 0;
			}else {
				A[i][0] = 1;
			}
		}
		for(int i=0; i<COLS; i++) {
			if(M[0][i] == 1) {
				A[0][i] = 0;
			}else {
				A[0][i] = 1;
			}
		}
		for(int i=1; i<ROWS; i++){
			for(int j=1; j<COLS; j++) {
				if(M[i][j] == 0) {
					if(A[i-1][j] != 0 && A[i][j-1] != 0) {
						A[i][j] = Math.min(A[i-1][j], A[i][j-1])+1;
					}else {
						A[i][j] = 1;
					}
				}else {
					A[i][j] = 0;
				}
			}
		}
		
		int max = A[0][0];
		for(int i=0; i<ROWS; i++) {
			for(int j=0; j<COLS; j++) {
				if(max < A[i][j]) {
					max = A[i][j];
				}
			}
		}
		
		return max*max;
	}
}
