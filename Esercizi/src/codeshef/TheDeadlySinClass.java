package codeshef;

import java.util.Scanner;
/*
 * FUNZIONANTE
 * SINS
 */
public class TheDeadlySinClass {

	public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int T = scan.nextInt();
	    while(T-- > 0){
		    int a = scan.nextInt();
		    int b = scan.nextInt();
		    int n = EatChocolates(a,b);
		    System.out.println(n);
	    }
	    scan.close();
	    return;
	}
	
	public static int EatChocolates(int a, int b) {
		if(a < 0 || b < 0)
			return -1;
		
		if(a == b) {
			return a+b;
		}
		
		if(a > b) {
			return EatChocolates(a-b,b);
		}else {
			return EatChocolates(a,b-a);
		}
	}
}
