package vari;

/*
 * 
 * FUNZIONANTE
 * 
 */
public class QuicksortClass {

	public QuicksortClass() {
	}

	public static void main(String[] args) {
		int[] A = {6,2,5,1,3,8,4,9};
		int n = A.length;
		Quicksort(A, 0, n-1);        //PARTO DA N-1 PER EVITARE OVERFLOW
		return;

	}

	public static void Quicksort(int[] A, int p, int r) {
		if(p < r) {
			int q = Partition(A, p, r);
			Quicksort(A, p, q-1);
			Quicksort(A, q+1, r);
		}
	}
	
	private static int Partition(int[] A, int p, int r) {
		int pivot = A[r]; 				//Assegno come ultimo elemento il pivot
		int i = p-1;
		for(int j = p; j<r; j++) {
			if(A[j] <= pivot) {
				i++;
				int tmp = A[i];
				A[i] = A[j];
				A[j] = tmp;
			}
		}
		int tmp = A[i+1];
		A[i+1] = A[r];
		A[r] = tmp;
		return i+1;
	}
}
