package vari;

import java.util.*;

/*
 * UVa 644
 * 
 */
public class ImmediateDecodabilityClass {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<String> code = new ArrayList<String>();
		for(int i=0; i<N; i++) {
			code.add(scan.next());
		}
		Map<Integer, String> codeHashed = new HashMap<Integer, String>();
		for(int i=0; i<N; i++) {
			codeHashed.put(code.get(i).hashCode(), code.get(i));
		}
		
		scan.close();
		return;
	}
}
