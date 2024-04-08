package vari;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shoemaker {

	static class Job{
		public int id;
		public int day;
		public int fine;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		List<List<Job>> TestCases = new ArrayList<>();
		
		while(T-- > 0) {
			int N = scan.nextInt();
			TestCases.add(new ArrayList<Job>(N));
			for(int i=0; i<N; i++) {
				Job job = new Job();
				job.id = i+1;
				job.day = scan.nextInt();
				job.fine = scan.nextInt();
				TestCases.get(T).add(job);
			}
		}
		
		
/*		for(int i=0; i<v.size()-1; i++) {
			if(CompareJob(v.get(i), v.get(i+1))){
				Swap(v, i, i+1);
			}
		}
*/		
		return;
	}

	public static void Swap(List<Job> v, int i, int j) {
		Job tmp = v.get(i);
		v.set(i, v.get(j));
		v.set(j, tmp);
	}
	public static boolean CompareJob(Job J1, Job J2) {
		return (J1.day * J2.fine) > (J2.day * J1.fine);
	}
	
}
