package vari;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TripletsClass {
	public static final int TRIPLET = 3;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int SUM = scan.nextInt();
		int[] numbers = new int[N];
		for(int i=0; i<N; i++) {
			numbers[i] = scan.nextInt();
		}
		
		List<List<Integer>> solution = new ArrayList<>();
		List<Integer> candidate = new ArrayList<>();
		Foo(numbers, N, SUM, candidate, 0, solution);
		scan.close();
		return;
	}

	private static void Foo(int[] numbers, int N, int SUM, List<Integer> candidate, int i, List<List<Integer>> solutions) {
		if(i == TRIPLET) {
			List<Integer> buffer = new ArrayList<>(candidate);
			solutions.add(buffer);
		}else {
			for(int k=i; k<N; k++) {
				candidate.add(i,numbers[k]);
				if(isSafe(candidate, SUM)) {
					Foo(numbers, N, SUM, candidate, i+1, solutions);
				}
				candidate.remove(i);
			}
		}
	}

	private static boolean isSafe(List<Integer> candidate, int SUM) {
		int sum = 0;
		for(int i=0; i<candidate.size(); i++) {
			sum+=candidate.get(i);
		}
		if(sum <= SUM) {
			return true;
		}
		return false;
	}
}
