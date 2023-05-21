
/*
 
 평행
 
 제한사항
	dots의 길이 = 4
	
	dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
	
	0 ≤ x, y ≤ 100
	
	서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
	
	두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
	
	임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.
 
 	
 
 */



package Programmers_low;

public class Parallel {
	
	public static int solution(int[][] dots) {
		int answer = 0;
		
		if((double)(dots[0][0] - dots[1][0]) / (dots[0][1] - dots[1][1]) == 
				(double)(dots[2][0] - dots[3][0]) / (dots[2][1] - dots[3][1]) ) {
			answer = 1;
		}
		if((double)(dots[0][0] - dots[2][0]) / (dots[0][1] - dots[2][1]) == 
				(double)(dots[1][0] - dots[3][0]) / (dots[1][1] - dots[3][1])) {
			answer = 1;
		}
		if((double)(dots[0][0] - dots[3][0]) / (dots[0][1] - dots[3][1]) == 
				(double)(dots[1][0] - dots[2][0]) / (dots[1][1] - dots[2][1])) {
			answer = 1;
		}
		
		return answer;
	}
	

	
	
	public static void main(String[] args) {
		
		int[][] dots = {{0, 0}, {3, 0}, {6, 0}, {10, 0}};
		int answer = solution(dots);
		System.out.println(answer);

	}

}
