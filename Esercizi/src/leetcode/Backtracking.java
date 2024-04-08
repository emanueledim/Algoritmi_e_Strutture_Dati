package leetcode;

import java.util.ArrayList;
import java.util.List;

// Esercizio numero:  1863. Sum of All Subset XOR Totals

public class Backtracking {

	public static void main(String[] args) {
		int[] testcase = {5,1,6,7,2,3,9};
		int a = subsetXORSum(testcase);

	}
	
	public static int subsetXORSum(int[] nums) {
			        
	    return 0;
	}
	    
/*	Funzionante ma fuori traccia. Va fatto con il backtracking tutto
 * 	public static List<List<Integer>> createSubsets(int[] v, int sizegroup){
		List<List<Integer>> subsets = new ArrayList<>();
	    int skip = -1;
	    boolean end = false;
	    int i=0;
	    int row = -1;
	    
	    while(i <v.length-2){
	    	row++;
	    	skip++;
	    	subsets.add(new ArrayList<>(sizegroup));
			subsets.get(row).add(v[i]);
			for(int j=1; j<sizegroup; j++){
				subsets.get(row).add(v[i+skip+j]);
				if(i+skip+j == v.length-1){
					end = true;
				}
			}
			if(end){
				i++;
				end = false;
				skip = -1;
			}
		}
		return subsets;
	}*/
}
