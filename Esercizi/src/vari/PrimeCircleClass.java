package vari;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Restituire tutte le possibili configurazioni di un vettore di dimensione n circolare tale che vengano
 * inseriti i numeri da 1 a n senza ripetizione degli stessi numeri e che la somma degli elementi
 * adiacenti sia un numero primo
 * 
 * FUNZIONANTE
 */

public class PrimeCircleClass {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		List<List<Integer>> solutions = new ArrayList<>();
		int[] solution = new int[N];
		solution[0]=1;
		CreatePrimeCircle(N, 1, solution, solutions);
		return;

	}
	
	public static void CreatePrimeCircle(int N, int i, int[] solution, List<List<Integer>> solutions) {
		if(i == N) {
			SaveSolution(solutions, solution, i);
		}else {
			for(int k=2; k<=N; k++) {
				solution[i] = k;
				if(isValid(solution, k, i)) {
					CreatePrimeCircle(N, i+1, solution, solutions);
				}
				solution[i]=0;
			}
		}
	}

	private static boolean isValid(int[] solution, int k, int i) {
		if(i == 0){
			return true;
		}
		
		for(int j=0; j<i; j++) {
			if(k == solution[j]) {
				return false;
			}
		}
		boolean isSumPrime = true;
		int s = solution[i]+solution[i-1];
		for(int j=2; j<s; j++) {
			if(s%j == 0) {
				return isSumPrime = false;
			}
		}
		if(i == solution.length-1) {
			s = solution[i]+solution[0];
			for(int j=2; j<s; j++) {
				if(s%j == 0) {
					return isSumPrime = false;
				}
			}
		}
		return isSumPrime;
		
	}

	public static void SaveSolution(List<List<Integer>> solutions, int[] solution, int i) {
		solutions.add(new ArrayList<Integer>());
		for(int j=0; j<i; j++) {
			solutions.get(solutions.size()-1).add(solution[j]);
		}
	}
}
