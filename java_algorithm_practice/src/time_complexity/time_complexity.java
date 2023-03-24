package time_complexity;

public class time_complexity {
	
	/*
	 시간복잡도 = 연산 횟수 (1억 번 연산 = 1초)
	 
	 빅-오메가 = 최선의 연산 횟수
	 빅-세타 = 평균 연산 횟수
	 빅-오 = 최악의 연산 횟수
	 
	 */
	public static void bigO_n_1() {
		//1~100 사이의 랜덤값
		int findNum = (int)(Math.random() * 100);
		int count = 0;
		
		//빅-오메가 = 1, 빅-세타 = 50, 빅-오 = 100
		for(int i = 0; i < 100; i++) {
			count++;
			if(i == findNum) {
				System.out.println(i);
				System.out.println("counts = " + count);
				break;
			}
		}
	}
	
	//시간복잡도 n
	public static void bigO_n_2() {
		int n = 100000;
		int count = 0;
		for(int i = 0; i < n; i++) {
			count++;
		}
		System.out.println("count = " + count);
	}
	
	//시간복잡도 n (n 외의 상수는 중요하지 않음)
	public static void bigO_3n() {
		int n = 100000;
		int count = 0;
		for(int i = 0; i< n; i++) {
			count++;
		}
		for(int i = 0; i< n; i++) {
			count++;
		}
		for(int i = 0; i< n; i++) {
			count++;
		}
		System.out.println("count = " + count);
	}
	
	//시간복잡도 n^2
	public static void bigO_n2(){
		int n = 100000;
		long count = 0;
		//중첩 반복문 = 연산횟수 기준
		for(int i = 0; i < n; i++) {
			for(int j = 0; j <n; j++) {
				count++;
			}
		}
		System.out.println("count = " +count);
	}
	
	
	
	public static void main(String[] args) {
		bigO_n_1();
		System.out.println();
		bigO_n_2();
		System.out.println();
		bigO_3n();
		System.out.println();
		bigO_n2();
		
	}
	
	
	/*
	 시간복잡도 (빅-오 표기)
	 O(1) = 일정한 복잡도 (스택)
	 O(log n) = 로그 복잡도 (이진 트리)
	 O(n) = 선형 복잡도 (반복, 버블정렬(최선))
	 O(n log n) = 선형로그 복잡도 (퀵정렬, 병합정렬, 힙정렬)
	 O(n^2) = 2차 복잡도 (퀵정렬(최악), 중첩반복, 삽입정렬, 버블정렬, 선택정렬)
	 O(2^n) = 기하급수 복잡도 (피보나치 수열)
	 O(n!) 
	 */

}
