package homework;

import java.util.HashMap;
import java.util.Map;

public class Homework3 {

	public static void main(String[] args){
		String s1 = "ATOTX";
		String s2 = "GGADZAA";
		String s3 = "ICABFZX";
		
		Map<String, Integer> memo1 = new HashMap<String, Integer>();
		Map<String, Integer> memo2 = new HashMap<String, Integer>();
		Map<String, Integer> memo3 = new HashMap<String, Integer>();
		
		int ris1 = CalcolaMaxPalindromo(s1, s1.length(), memo1);
		int ris2 = CalcolaMaxPalindromo(s2, s2.length(), memo2);
		int ris3 = CalcolaMaxPalindromo(s3, s3.length(), memo3);
		
		System.out.println(ris1);
		System.out.println(ris2);
		System.out.println(ris3);
		return;
	}

	private static int CalcolaMaxPalindromo(String s, int length, Map<String, Integer> memo) {
		int max = 0;					
		if(memo.containsKey(s)) {	//Se è nella memo
			return memo.get(s);		//prendi la lunghezza della sottostringa palindroma giù calcolata
		}
		if(length == 0) {			//Se la lunghezza della sottostringa è nulla
			memo.put("", 0);		
			return 0;				//ritorna 0
		}
		if(length == 1) {			//Se la sottostringa è pari a 1
			memo.put(s, 1);
			return 1;				//è palindroma, ritorna lunghezza 1
		}
		
		if(isExternPalindrome(s, length)) {	//Se i caratteri esterni sono uguali
			 max += 2 + CalcolaMaxPalindromo(s.substring(1,length-1), length-2, memo);	//conta 2 e calcola la stringa palindroma sulla sottostringa privata dei caratteri esterni
		}else {
			//Calcola il massimo tra le sottostringhe private del carattere iniziale e il carattere finale
			max = Math.max(CalcolaMaxPalindromo(s.substring(1, length), length-1, memo), CalcolaMaxPalindromo(s.substring(0, length-1), length-1, memo));
		}
		memo.put(s, max);	//Memoizza il risultato
		return max;
	}

	private static boolean isExternPalindrome(String s, int length) {
		boolean is_palindrome = false;
		if(s.charAt(0) == s.charAt(length-1)) {
			is_palindrome = true;
		}
		return is_palindrome;
	}
}
