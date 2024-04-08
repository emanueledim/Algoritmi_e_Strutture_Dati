package vari;

import java.util.Scanner;

/*
 * CORRETTO
 * UVa 10036
 * 
 */

public class DivisibilityClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();

		while(M-- > 0) {
			int N = scan.nextInt();
			int K = scan.nextInt();
			int[] numbers = new int[N];
			for(int i=0; i<N; i++) {
				numbers[i] = scan.nextInt();
			}
			if(isSumSubDivisible(numbers, 0, 0, N, K, 0)) {
				System.out.println("Divisible");
			}else {
				System.out.println("Not Divisible");
			}
		}
		scan.close();
	}
	

	private static boolean isSumSubDivisible(int[] numbers, int i, int acc, int N, int K, int op) {
		if(i == N) {
			return isDivisible(acc, K);
		}else {
			acc = doOperation(acc, numbers[i], op);
			boolean a;
			a = isSumSubDivisible(numbers, i+1, acc, N, K, 0);
			if(a) return a;	//Returna piu velocemente
			a = isSumSubDivisible(numbers, i+1, acc, N, K, 1);
			return a;
		}
	}

	public static boolean isDivisible(int acc, int K) {
		if(acc%K == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int doOperation(int acc, int number, int op) {
		if(op == 0) {
			return acc+number;
		}
		return acc-number;
	}
}
