
package intercorso;

import java.util.Scanner;
/* Scritto in JAVA
 * 
 * PROVA INTERCORSO ALGORITMI E STRUTTURE DATI 2022
 * Emanuele Di Maio
 * ESERCIZIO 1
 * 
 * Per la complessità temporale:
 * Nel caso Divide: partiziona il vettore finché indice di inizio (p) e fine (r) coincidono: 2 rami dell'albero
 * e di conseguenza la sua altezza è logN, inoltre viene effettuato un controllo per ogni elemento del vettore
 * quando si arriva alla foglia: N. La complessità è quindi N logN
 * Es.
 * K = 1
 * p=0, r=3
 * 				   2 3 1 6	Partiziono
 * 				  /      \
 * 				2 3		1 6		 Partiziono 
 * 				/ \	    /  \
 * 			   2   3   1    6		Su questo livello p ed r coincidono (passo base) e richiamo la CountNumber
 */
public class DiMaioEmanuele1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while(T-- > 0) {
			int K = scan.nextInt();
			int N = scan.nextInt();
			int[] array = new int[N];
			for(int i=0; i<N; i++) {
				array[i] = scan.nextInt();
			}
			System.out.println(Count(array,0,N-1,K));
		}
		scan.close();
		return;

	}

	private static int Count(int[] array, int p, int r, int K) {
		int count1=0;		
		int count2=0;
		if(p == r) {		//Passo base: arrivo alla foglia dell'albero
			return CountNumber(array, p, K); //Ritorno il conteggio appena effettuato nella foglia
		}
		if(p<r) {				//Divide
			int q = (p+r)/2;
			count1 += Count(array, p, q, K);	//Chiamata ramo sinistro albero	
			count2 += Count(array, q+1, r, K);  //Chiamata ramo destro albero
		}
		return count1+count2;	//Impera: risalgo l'albero ritornando il conteggio
	}
	
	public static int CountNumber(int[] A, int p, int K) {	//Funzione richiamata sulla foglia
		int count = 0;
		if(A[p] == K) {		//Verifico che la foglia sia uguale a K
			count++;		//Incremento il conteggio se è uguale, altrimenti restituisco 0 (non l'ho contato)
		}
		return count;
	}

}