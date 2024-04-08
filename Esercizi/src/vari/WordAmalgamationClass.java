package vari;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * UVa 642
 * 
 */
public class WordAmalgamationClass {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.next();
		ArrayList<String> dictionary = new ArrayList<>();
		while(!input.equals("XXXXXX")) {
			dictionary.add(input);
			input = scan.next();
		}
		ArrayList<String> scrambleWords = new ArrayList<>();
		input = scan.next();
		while(!input.equals("XXXXXX")) {
			scrambleWords.add(input);
			input = scan.next();
		}
		
		for(int i=0; i<dictionary.size(); i++) {
			String word = dictionary.get(i);
			dictionary.set(i, SortWord(word));
		}
		for(int i=0; i<scrambleWords.size(); i++) {
			String word = scrambleWords.get(i);
			scrambleWords.set(i, SortWord(word));
		}

		for(int i=0; i<scrambleWords.size(); i++) {
			String scramble = scrambleWords.get(i);
			boolean found = false;
			int j=0;
			while(!found && j<dictionary.size()) {
				String word = dictionary.get(j);
				if(scramble.contentEquals(word)) {
					found = true;
				}
				j++;
			}
			if(found) {
				System.out.println(scramble);

				System.out.println("******");
			}else {
				System.out.println("NOT A VALID WORD");
				System.out.println("******");
			}
		}
		return;
	}
	
	public static String SortWord(String word) {
		String orderedWord = "";
		int[] integerWord = new int[word.length()];
		for(int i=0; i<word.length(); i++) {
			integerWord[i] = word.charAt(i);
		}
		MergeSort(integerWord,0,integerWord.length-1);
		for(int i=0; i<word.length(); i++) {
			orderedWord += (char)integerWord[i];
		}
		return orderedWord;
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
		int n1 = q-p+1; //il +1 serve quando q e p coincidono e non fare un array vuoto
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
	
/*
	public static int Hash(String s) {
		return Integer.hashCode(StringToInteger(s));
	}
	
	public static int StringToInteger(String s) {
		int sum = 0;
		for(int i=0; i<s.length(); i++) {
			sum+= (int)s.charAt(i);
		}
		return sum;
	}
	*/
}
