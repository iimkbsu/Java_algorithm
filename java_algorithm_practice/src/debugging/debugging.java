package debugging;

import java.util.Scanner;
import java.util.logging.*;

public class debugging {
	
	/*
	 로그기록 남기기
	 import java.util.logging.*
	 Logger log = Logger.getGlobal();
	 
	 
	 디버깅 = 반드시 해야 하는 절차
	 디버깅 하는 법
	 1. 코드에서 디버깅 하고자 하는 줄에 중단점 설정 (여러개도 가능) (breakpoint = 좌측 라인 더블클릭)
	 2. IDE의 디버깅 기능을 실행(1줄씩, 중단점까지 모두 가능), 추적할 변수값도 지정가능. (variable, expression)
	 3. 변수값 이외에도 원하는 수식을 입력해 논리 오류 파악도 가능
	 
	 */
	

	
	public static void main(String[] args) {
		
		//배열에서 주어진 범위의 합을 구하는 프로그램
		
		//Logger log = Logger.getGlobal();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("테스트 케이스 수 = ");
		int testcase = sc.nextInt();
		long A[] = new long[100001];
		long S[] = new long[100001];
		
		//정수 최대값(4byte)에 0~1사이의 랜덤수를 곱하여 S[] 배열에 순서대로 더하면서 저장
		for(int i=1; i<100000; i++) {
			A[i] = (int)(Math.random()*Integer.MAX_VALUE);
			S[i] = S[i-1] + A[i];
			//log.info("info log");
			
		}
		
		// 입력해준 테스트케이스 수만큼 테스트 반복, S[] 배열에서 원하는 인덱스번호 넣어주고 두 배열의 값을 빼준 후 answer에 합하여 대입
		for(int j=1; j<testcase; j++) {
			System.out.print("쿼리 수 = ");
			int query = sc.nextInt();
			long answer = 0;
			
			for(int i=0; i<query; i++) {
				System.out.print("시작 = ");
				int start = sc.nextInt();
				System.out.print("끝 = ");
				int end = sc.nextInt();
				answer += S[end] - S[start -1];
				System.out.println(testcase + " " + answer);
			}
		}

	}

}
