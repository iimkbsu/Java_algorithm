/*
 구현(implementation) 문제
  : 풀이를 떠올리기는 쉽지만 이 걸 소스코드로 옮겨서 구현하기 어려운 문제들
  
 유형
 1. 간단한 알고리즘 but 코드가 지나치게 길어짐
 2. 실수(float, double)연산과 특정 소수점 자릿수까지 출력하는 문제
 3. 문자열 처리
 4. 라이브러리 사용해야 하는 문제 
 5. 2차원 배열 문제 (캐릭터 이동, 퍼즐 등)
 
 
 */


//2차원 배열 좌표에서 특정 키를 눌렀을 때 상하좌우 이동하여 최종 도착점의 좌표를 출력하는 프로그램
//(1,1)~(N,N) 크기의 2차원 평면좌표, 이동횟수 100이하
//입력: 1 =< N <= 100  R R R U D D(공백기준으로 입력받음)
// 출력: 3 4(공백기준으로 구분하여 출력)


package implementation;

import java.util.Arrays;

public class implementationExample {
	
	static int[] RLUD(int N, String move) {
		String[] mymove = move.split(" "); //RRRUDD
		int[][] map = new int[N][N];
		
		//RLUD 이동방법
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		String[] rlud = {"R","L","U","D"};
		
		//초기위치 (1,1)
		int curx = 1, cury =1;
		
		//이동거리
		int x =0, y=0;
		
		//들어온 RLUD 문자열을 길이만큼 반복할 때
		for(int i=0; i<mymove.length; i++) {
			// rlud 이동방법이 담긴 배열과 비교
			for(int j=0; j<rlud.length; j++) {
				
				//들어온 문자열과 이동방법과 같으면 이동좌표에 최근위치좌표 + 이동방법을 넣어줌
				if(mymove[i].equals(rlud[j])) {
					x = curx + dx[j];
					y = cury + dy[j];
				}
				
				//조건식. 이동좌표 x 또는 y가 1보다 작거나 N 보다 크면 맵 탈출하므로 최근좌표에 초기화 하지말고 continue
				if(x < 1 || y < 1 || x > N || y > N) {
					continue;
				}else {
					curx = x;
					cury = y;	
				}
			}
		}
		System.out.println((curx) + " " + (cury));
		int[] result = {curx, cury};
		return result;
		
				
		
	}

	public static void main(String[] args) {
		int n = 5;
		String move = "R R R R R R R R R U D U D D D";
		RLUD(n, move);

	}

}
