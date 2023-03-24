package array_list;

import java.util.ArrayList;
import java.util.Scanner;

public class arraylistExample {
	
	//배열 수 입력 받고 글자를 거꾸로 출력하는 함수
	public static ArrayList<String> solution(int n, String[] s){
		
		ArrayList<String> answer = new ArrayList<>();
		
		//향상된 for문  배열 항목 수 만큼 반복
		for(String str: s) {
			int len = str.length();
			String a = "";
			for(int i=len-1; i>=0; i--) {
				a += str.charAt(i);
			}
			answer.add(a);
		}
		
		return answer;
	}
	
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 배열 길이 입력 : ");
		int n = sc.nextInt();
		String[] s = new String[n];
		
		for(int i=0; i<n; i++) {
			s[i] = sc.next();
		}
		for(String x: arraylistExample.solution(n, s)) {
			System.out.println(x);
		}
		

	}

}
