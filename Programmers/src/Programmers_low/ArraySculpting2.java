package Programmers_low;

import java.util.Arrays;

public class ArraySculpting2 {
	
	 public int[] solution(int[] arr, int[] query) {
		 
	        for (int i = 0; i < query.length; i++) {
	        	
	            if (i % 2 == 0) {
	                arr = Arrays.copyOfRange(arr, 0, query[i]+1);
	            } else {
	                arr = Arrays.copyOfRange(arr, query[i], arr.length);
	            }
	            
	        }
	        int[] answer = arr;
	        
	       
	        
	        return answer;
	    }

	public static void main(String[] args) {
		
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13};
		int[] query = {4,1,2};
		ArraySculpting2 as = new ArraySculpting2();
		as.solution(arr, query);

	}

}
