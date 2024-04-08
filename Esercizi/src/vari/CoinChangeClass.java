package vari;

import java.util.Scanner;

public class CoinChangeClass {

	public CoinChangeClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		ChangeCoin(money,50,0);
		return;

	}

	public static int ChangeCoin(int money, int maxcents, int count) {
		if(maxcents == 0) {
			return count;
		}
		int ris = money/maxcents;
		if(ris > 0) {
			count++;
		}
		return ChangeCoin(money, maxcents/2, count);
	}
}
