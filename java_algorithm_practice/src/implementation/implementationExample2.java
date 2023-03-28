
/*
 시각 문제
 정수 (0 <= N <= 23)이 입력되면 (시간:분:초) 00:00:00 부터 N:59:59 까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 카운트 하는 프로그램을 작성
 
 예:
 00:03:33
 13:01:55
 는 세어야 하는 시각
 
 22:11:56
 는 세지 말아야 할 시각
 
 */



package implementation;

public class implementationExample2 {
	
	static void timecount(int n) {
		
		int count=0;
		
		for(int h=0; h<=n; h++) {
			for(int m=0; m<60; m++) {
				for(int s=0; s<60; s++) {
					if(h % 10 == 3 || m % 10 == 3 || m /10 == 3 || s % 10 == 3 || s /10 == 3) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
	

	public static void main(String[] args) {
		timecount(5);

	}

}
