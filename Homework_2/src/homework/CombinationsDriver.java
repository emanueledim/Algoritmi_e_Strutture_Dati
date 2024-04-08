package homework;

public class CombinationsDriver {

	public static void main(String[] args) {
		
		int n1 = 1;
		int n2 = 3;
		int n3 = 4;
		int n4 = 5;
		
		int[] memo1 = new int[n1+1];
		int[] memo2 = new int[n2+1];
		int[] memo3 = new int[n3+1];
		int[] memo4 = new int[n4+1];
		
		int ris1 = DP(n1, memo1);
		int ris2 = DP(n2, memo2);
		int ris3 = DP(n3, memo3);
		int ris4 = DP(n4, memo4);
		
		System.out.println(ris1);
		System.out.println(ris2);
		System.out.println(ris3);
		System.out.println(ris4);
		return;
	}

	public static int DP(int n, int[] memo) {
		if(memo[n] != 0) {
			return memo[n];
		}
		if(n <= 1) {
			memo[n] = 1;
			return 1;
		}
		int ris  = DP(n-1, memo)+(n-1)*DP(n-2, memo);
		memo[n] = ris;
		return ris;
	}
}
