package Programmers_low;

//배열에서 7의 개수 구하기

import java.util.Arrays;

public class SevenCount {

	public static void main(String[] args) {

		int s = solution(new int[] {7, 77, 17});
		System.out.println(s);
		
	}
	
	
	
	public static int solution(int[] array) {
		int answer = 0;
		
		String str = Arrays.toString(array);
		
		String[] strArray = str.split("");
		for(int i=0; i<strArray.length; i++) {
	
			if(strArray[i].equals("7")) {
				answer++;
			}
		}
		
		return answer;
	}

}
