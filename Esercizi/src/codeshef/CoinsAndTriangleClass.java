package codeshef;

import java.util.Scanner;
/*
 * 
 * Dovrebbe essere corretto
 */
public class CoinsAndTriangleClass {

	public CoinsAndTriangleClass() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		while(T-- > 0) {
			int input = scan.nextInt();
			int i = 1;
			int l = 0;
			while(input >= i){
			    input = input-i;
			    i++;
			    l++;
			}
			System.out.println(l);
		}
		scan.close();
		return;
	}

}
