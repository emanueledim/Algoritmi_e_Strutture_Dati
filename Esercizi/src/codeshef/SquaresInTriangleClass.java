package codeshef;

import java.util.Scanner;

/*
 * FUNZIONANTE
 * TRISQ
 */
public class SquaresInTriangleClass {

	public static final int S = 2;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int B = scan.nextInt();
		int n = FitSquareInTriangle(B,0);
		System.out.println(n);
		scan.close();
		return;
	}

	
	public static int FitSquareInTriangle(int B, int nsquares) {
		if(B < 4) {
			return nsquares;
		}else {
			nsquares += (B/2)-1;
			nsquares = FitSquareInTriangle(B-S, nsquares);
		}
		return nsquares;
	}
	
	/* Non funzionante
	public static int FitSquareInTriangle(int B, int nsquares) {
		if(B < 4) {
			return nsquares;
		}else {
			nsquares += 1;
			nsquares = FitSquareInTriangle(B-S, nsquares);
			nsquares = FitSquareInTriangle(B-S, nsquares);
		}
		return nsquares;
	}*/
}
