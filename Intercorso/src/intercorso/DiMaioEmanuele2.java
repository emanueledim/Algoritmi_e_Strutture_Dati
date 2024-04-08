package intercorso;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * PROVA INTERCORSO ALGORITMI E STRUTTURE DATI 2022
 * Emanuele Di Maio
 * ESERCIZIO 2
 * 
 * Il linguaggio usato è JAVA compilato con versione 9 (JavaSE-9)
 * HP1: Si è ipotizzato che nella soluzione è ammessa anche la ripetizione degli stessi elementi (ad esempio: [7,7,7] con S=21
 * HP2: Si è ipotizzato che nella soluzione è ammessa anche la stessa sequenza di interi con ordine diverso
 * (ad esempio: [7, 13, 43], [7,43,13], [43,7,13])
 * La complessità temporale è di tipo esponenziale
 */

public class DiMaioEmanuele2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		int n_caso_test = 1;
		while(T-- > 0) {
			int S = scan.nextInt();
			int N = scan.nextInt();
			int P = scan.nextInt();
			
			List<List<Integer>>  all_solutions = new ArrayList<>();
			List<Integer> partial_solution = new ArrayList<>();
			Foo(S,N,P, 0, partial_solution, all_solutions);
			System.out.println("CASO DI TEST "+ n_caso_test);
			n_caso_test++;
			PrintSolutions(all_solutions);
		}
		scan.close();
		return;
	}

	//k = elemento in posizione k del vettore delle soluzioni
	private static void Foo(int S, int N, int P, int k, List<Integer> partial_solution, List<List<Integer>> all_solutions) {
		if(k == N && SolutionEqualsSum(partial_solution, S)) {	//k è uguale a N e la somma degli elementi della soluzione candidata è uguale a S
			List<Integer> buffer_solution = new ArrayList<>(partial_solution);
			all_solutions.add(buffer_solution);
		}else {
			for(int i=P+1; i<=S; i++) {		//Provo ad aggiungere tutti gli elementi che vanno da P+1 a S
				partial_solution.add(k, i);			//Aggiungo l'elemento i in posizione k
				if(isSafe(partial_solution, i, S, N)) {	//Se i è primo e se la somma degli elementi attuali è < S
					Foo(S, N, P, k+1, partial_solution, all_solutions);	//Allora aggiungo l'elemento successivo alla soluzione
				}
				partial_solution.remove(k);	//Undo: rimuovo l'elemento in posizione k appena aggiunto dalla soluzione parziale
			}
		}
	}

	private static boolean isSafe(List<Integer> partial_solution, int i, int S, int N) {
		if(!isPrime(i)) {
			return false; 	// Se il numero i candidato aggiunto non è primo, allora return false
		}
		int solution_sum = 0;
		int length = partial_solution.size();
		for(int j=0; j<length; j++) {
			solution_sum += partial_solution.get(j);
		}
		if(solution_sum > S) {	//Se la somma degli elementi è maggiore di S, allora ritorna falso, altrimenti vero
			return false;
		}
		return true;
		
	}

	private static boolean SolutionEqualsSum(List<Integer> partial_solution, int S) {
		int solution_sum = 0;
		int length = partial_solution.size();
		for(int i=0; i<length; i++) {
			solution_sum += partial_solution.get(i);
		}
		if(solution_sum == S) {	//Se la somma degli elementi è uguale a S ritorna true, altrimenti falso
			return true;
		}
		return false;
	}

	public static boolean isPrime(int number) {
		boolean isPrime = true;
		for(int i=2; i<number-1; i++) {
			if(number%i == 0) {			//è primo se il modulo è sempre diverso da 0 per ogni numero da 2 a number-1
				isPrime = false;
			}
		}
		return isPrime;
	}
	
	public static void PrintSolutions(List<List<Integer>> all_solutions) {
		for(int i=0; i<all_solutions.size(); i++) {
			for(int j=0; j<all_solutions.get(i).size(); j++) {
				System.out.print(all_solutions.get(i).get(j)+ " ");
			}
			System.out.println();
		}
	}
}
