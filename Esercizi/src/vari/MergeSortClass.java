package vari;

/*
 * 
 * FUNZIONANTE
 * 
 */
public class MergeSortClass {

	public MergeSortClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
//		int[] v = {3,5,7,8,2,7,3,6,11,32,21,54,33};
		
		int[] v = {1,5,3,4,2};
		int n = v.length;
		MergeSort(v, 0, n-1);		
		return;
	}
		

	public static void MergeSort(int[] A, int p, int r) {
		if(p<r) {
			int q = (r+p)/2;
			MergeSort(A, p, q);
			MergeSort(A, q+1, r);
			Merge(A,p,q,r);
		}		
	}
	
	public static void Merge(int[] A, int p, int q, int r) {
		int n1 = q-p+1;
		int n2 = r-q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(int i=0; i<n1; i++) {
			L[i] = A[p+i];
		}
		
		for(int j=0; j<n2; j++) {
			R[j] = A[q+1+j];
		}
		int k=p;
		int i=0;
		int j=0;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}else{
				A[k] = R[j];
				j++;
			}
			
			k++;
		}
		while(i<n1) {
			A[k] = L[i];
			i++;
			k++;
		}
		while(j<n2) {
			A[k] = R[j];
			j++;
			k++;
		}
	}
}
