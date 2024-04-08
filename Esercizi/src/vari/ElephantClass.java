package vari;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElephantClass {

	static class Elephant{
		public int weight;
		public int IQ;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Elephant[] elephants = new Elephant[N];
		boolean[] checked = new boolean[N];
		for(int i=0; i<N; i++) {
			checked[i] = false;
			Elephant ele = new Elephant();
			ele.weight = scan.nextInt();
			ele.IQ = scan.nextInt();
			elephants[i] = ele;
		}
		//fare vetrore arraylist
		Foo(elephants, N, checked, 0, null, null);
		scan.close();
	}

	
	public static void Foo(Elephant[] elephants, int N, boolean[] checked, int count, List<Integer> partial_solution, List<List<Integer>> results) {
		if(partial_solution.equals(null)) {
			partial_solution = new ArrayList<Integer>();
		}
		if(areElephantsChecked(checked, N)) {
			//Salvataggio
			return;
		}else {
			for(int i=0; i<N; i++) {
				count++;
				partial_solution.add(i);
				if(isValid(elephants, checked, N, i, partial_solution)) {
					checked[i] = true;
					Foo(elephants, N, checked, count, partial_solution, results);
					checked[i] = false;
				}
				count--;
				partial_solution.remove(i);
			}
		}
	}


	private static boolean isValid(Elephant[] elephants, boolean[] checked, int n, int i, List<Integer> partial_solution) {
		if(checked[i] == true) {	//Se l' elefante è gia stato controllato, ritorna falso
			return false;
		}
		
		int index = partial_solution.size();
		if(index == 1){	//Se ho un solo elefante, è vera
			return true;
		}
		int last_elephant_added_index = partial_solution.get(index-1);
		int previous_elephant = partial_solution.get(index-2);
		
		if(elephants[last_elephant_added_index].weight > elephants[previous_elephant].weight) {
			if(elephants[last_elephant_added_index].IQ < elephants[previous_elephant].IQ) {
				return true;
			}
		}
		return false;
	}


	private static boolean areElephantsChecked(boolean[] checked, int N) {
		boolean allchecked = true;
		for(int i=0; i<N; i++) {
			if(checked[i] == false) {
				allchecked = false;
			}
		}
		return allchecked;
	}
	

}
