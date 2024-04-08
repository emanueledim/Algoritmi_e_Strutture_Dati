package vari;

/*
 * Geeks for Geeks DP - Medium - 18
 * FUNZIONANTE ma senza Memo
 */
public class SumPartition {

	public static void main(String[] args) {
		int[] a1 = {5,155}; //Throwing corretto
		int[] a2 = {1,5,11,5}; 
		int[] a3 = {1,5,3}; 
		int[] a4 = {1,5,3,3,8}; 
		int[] a5 = {11,5,1,5};
		
		int s=0;
		for(int i=0; i<a5.length; i++)
			s+= a5[i];
		if(s%2 != 0) {
			System.out.println(s%2 == 0);
		}else{
			boolean ris = Sum(s/2, 0, a5);
			System.out.println(ris);
		}
		return;
	}
	
	public static boolean Sum(int s, int i, int[] A){
		if(s == 0) return true;
		if(s < 0) return false;

		if(A[i] > s && i<A.length-1) {
			return Sum(s-A[i+1], i+2, A);
		}
		return Sum(s-A[i], i+1, A);
	}
}
