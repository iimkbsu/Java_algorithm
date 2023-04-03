
/*
 문자열 재정렬 문제
 알파벳 대문자 및 숫자로만 구성된 문자열 입력받은 후 알파벳은 오름차순으로 정렬하고 그 뒤에 입력된 모든 숫자를 합하여 출력하시오.
 
 입력 예: K1KA5CB7
 출력 예: ABCKK13
  
 */



package implementation;

import java.util.Arrays;

public class implementationExample4 {
	
	static void rearrange(String s) {
		
		//정규표현식 문자열s에서 0~9까지 문자만 빼서 문자 배열로 저장
		char[] num = s.replaceAll("[^0-9]", "").toCharArray();
		
		//문자 배열 alpha에 A~Z까지 알파벳 대문자만 빼서 문자배열로 바꾼 후 저장
		char[] alpha = s.replaceAll("[^A-Z]", "").toCharArray();
		Arrays.sort(alpha);
		
		int sum = 0;
		
		for(char c : num) {
			int a = c - '0'; //숫자 문자를 int형으로 바꾸는 작업
			sum += a;
		}
		
		String sortedAlpha = new String(alpha);
		//삼항연산자잖아 ㅋㅋ C언어에서 했던건데 그대로 쓸 수 있구만
		//int를 문자열로 바꾸는 방법
		//Integer.toString(바꿀숫자) //NPE 에러처리
		//String.valueOf(바꿀숫자) //null로 반환
		String addedNum = (sum == 0 ? "" : Integer.toString(sum));
		//String addedNum = (sum == 0?"" : String.valueOf(sum));
		
		System.out.println(sortedAlpha + addedNum);
		
		
		
		
	}

	
	
	
	
	public static void main(String[] args) {
	
		rearrange("K1KA5CB7");

	}

}
