
/*
 왕실 나이트 문제
 8*8 크기의 체스판이 있고 특정 위치에 나이트 말이 서 있다.
 나이트 말은 L자 형태로만 이동 가능. (수직2칸 이동 후 수평1칸) (수평2칸 이동 후 수직1칸)
 정원을 나갈 수 없음.
 
 나이트의 좌표가 주어졌을 때 나이트가 움직일 수 있는 모든 경우의 수를 카운트 하여 출력
 
  a b c d e f g h
 1x
 2    o
 3  o
 4
 5
 6
 7
 8
 
 입력 예 : a1
 출력 예 : 2
 
 */

package implementation;

public class implementationExample3 {
	
	static void nightmove(String position) {
		
		int column = position.charAt(0) - 'a' + 1;
		int row = position.charAt(1) - '0' + 0;
		
		
		int[] dx = {2,2,-2,-2,1,-1,1,-1};
		int[] dy = {-1,1,-1,1,2,2,-2,-2};
		
		int result = 0;
		
		
		for(int i=0; i<8; i++) {
			
			int nextrow = row + dx[i];
			int nextcol = column + dy[i];
			
			if(nextrow >=1 && nextrow <=8 && nextcol >=1 && nextcol <= 8) {
				result++;
			}
		}
		
		System.out.println(result);
	}

	
	
	
	
	public static void main(String[] args) {
		
		nightmove("a1");

	}

}
