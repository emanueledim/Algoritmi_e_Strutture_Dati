package codeshef;

import java.util.Scanner;

public class ChefAndShopClass {

	public static class Orange{
		public int cost;
		public int weigth;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		while(T-- > 0) {
			int n = scan.nextInt();
			int k = scan.nextInt();
			Orange[] oranges = new Orange[n];
			for(int i=0; i<n; i++) {
				oranges[i] = new Orange();
				oranges[i].cost = scan.nextInt();
				oranges[i].weigth = scan.nextInt();
			}
			int ris = BuyOranges(oranges, k, 0);
			System.out.println(ris);
		}
		
		scan.close();
		return;
	}

	private static int BuyOranges(Orange[] oranges, int k, int i) {
		if(i == oranges.length) {
			return 0;
		}
		if(oranges[i].cost > k) {
			return BuyOranges(oranges, k, i+1);
		}
		int skipped = BuyOranges(oranges, k, i+1);
		int picked = oranges[i].weigth + BuyOranges(oranges,k-oranges[i].cost, i+1);
		return Math.max(skipped, picked);
	}	
}
