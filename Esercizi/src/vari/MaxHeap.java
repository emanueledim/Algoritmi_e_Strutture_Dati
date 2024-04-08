package vari;

/*
 * 
 * NON FUNZIONANTE
 * 
 */
public class MaxHeap {

	public static int[] A;
	public static int n;
	
	public MaxHeap(int r) {
		A = new int[r];
		for(int i=0; i<r; i++) {
			A[i] = 0;
		}
	}

	public static int Parent(int i) {	//Padre del nodo i-esimo
		return i/2;
	}
	
	public static int Left(int i) {
		return i*2;	
	}
		
	public static int Right(int i) {
		return i*+1;
	}
//	Come trattare A[0]?
	public static void MaxHeapify(int i, int n) {	//Faccio l'heapify su un nodo i per ristabiire l'ordine
		int l = Left(i);
		int r = Right(i);
		int max;
		if(l < n && get(l) > get(i)) {
			max = l;
		}else {
			max = i;
		}
		
		if(r < n && get(r) > get(max)) {
			max = r;
		}
		
		if(max != i) {
			Scambia(i, max);
			MaxHeapify(max, n);
		}
	}
	
	public static void BuildMaxHeap() {
		for(int i=n/2; i>=0; i--) {
			MaxHeapify(i, n);
		}
	}
	                           
	                           
	public static void Heapsort() {
		BuildMaxHeap();
		for(int i=n; i>=1; i--) {
			Scambia(1,i);
			n--;
			MaxHeapify(1, n);
		}
	}
	
	
	public static void Scambia(int a, int b) {
		int tmp = get(a);
		A[a-1] = get(b);
		A[b-1] = tmp;
	}

	public static int HeapMaximum() {
		return get(1);
	}
	
	public static int ExtractMax() {
		if(n<1) {
			return Integer.MIN_VALUE;
		}
		int max = get(1);
		A[0] = get(n);
		n--;
		MaxHeapify(1, n);
		return max;
	}
	
	public static void IncreaseKey(int i, int key) {
		if(key < A[i]) {
			return;
		}
		A[i] = key;
		while(i>0 && A[Parent(i)] < A[i]) {
			Scambia(i, Parent(i));
			i = Parent(i);
		}
	}
	
	public static void MaxHeapInsert(int key) {
		n = n+1;
		int[] B = new int[n+5];
		for(int i=0; i<n-1; i++) {
			B[i] = A[i];
		}
		B[n-1] = Integer.MIN_VALUE;
		A = B;
		IncreaseKey(n-1, key);
	}
	
	public static int get(int i) {
		if(i == 0) return -1;
		return A[i-1];
	}
}
