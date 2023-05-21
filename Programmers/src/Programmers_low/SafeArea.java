
/*
 * 
 	다음 그림과 같이 지뢰가 있는 지역과 지뢰에 인접한 위, 아래, 좌, 우 대각선 칸을 모두 위험지역으로 분류합니다.
 	
 	□□□□□
 	□xxx□
 	□xºx□
 	□xxx□
 	□□□□□

	지뢰는 2차원 배열 board에 1로 표시되어 있고 board에는 지뢰가 매설 된 지역 1과, 지뢰가 없는 지역 0만 존재합니다.
	지뢰가 매설된 지역의 지도 board가 매개변수로 주어질 때, 안전한 지역의 칸 수를 return하도록 solution 함수를 완성해주세요.
 
 제한사항
	board는 n * n 배열입니다.
	1 ≤ n ≤ 100
	지뢰는 1로 표시되어 있습니다.
	board에는 지뢰가 있는 지역 1과 지뢰가 없는 지역 0만 존재합니다.
 
 
 입출력 예
[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 0, 0], [0, 0, 0, 0, 0]]	16

[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 1, 1, 0], [0, 0, 0, 0, 0]]	13

[[1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1], [1, 1, 1, 1, 1, 1]]	0
 
 
 
 */


package Programmers_low;

public class SafeArea {
	
	public static int solution(int[][] board) {
		int answer = 0;
	
		int[][] dArea = new int[board.length][board[0].length];
		
		//00 0-1 01 10 1-1 11 -10 -1-1 -11 (9개 범위)
		
		int[] x = {0, 0, 0, 1, 1, 1, -1, -1, -1};
		int[] y = {0, -1, 1, 0, -1, 1,0, -1, 1,};
		
		int dx = 0;
		int dy = 0;
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				
				if(board[i][j] == 1) {
					
					for(int k=0; k <9; k++) {
						dx = i + x[k];
						dy = j + y[k];
						
						if(dx < dArea.length && dy < dArea.length && dx >= 0 && dy >= 0) {
								dArea[dx][dy] = 1;
						}
					}
				}
			}
		}
		
		int count = 0;
		for(int[] arr : dArea) {
			for(int var : arr) {
				if(var==0) {
					count++;
				}
			}
		}
		answer = count;
		
		
		return answer;
	}

	public static void main(String[] args) {
	
		int[][] d = {{0, 0, 0, 0, 0},{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}};
		
		System.out.println(solution(d));

	}

}






