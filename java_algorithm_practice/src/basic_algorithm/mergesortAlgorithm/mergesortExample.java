/*
 
 분할정복 : 방대한 문제 해결에서 상단에서 분할, 중단에서 정복, 하단에서 조합 하는 형태로 여러 알고리즘의 기본 형태
 장점 - 어려운 문제를 해결할 수 있음
 단점 - 재귀적 함수 호출로 인해 오버헤드 발생, 스택 오버플로우 발생가능성, 과도한 메모리 사용 등
 
 분할정복 종류: 탐색 알고리즘, 정렬 알고리즘, 선택 알고리즘
 탐색 : 이진탐색
 정렬 : 퀵정렬, 합병(병합)정렬, 부분정렬
 선택 : 선형시간 선택
 
 
 그 외의 정렬 알고리즘 : 선택정렬(제자리 정렬 알고리즘), 삽입정렬, 버블정렬, 기수정렬
 ********************************************************************************
 
 
 병합정렬 : 분할정복 방식의 정렬 알고리즘, 
 시간복잡도 : O(nlogn) *밑이 2인 log임
 
 방식
 42 32 24 60 15 (주어진 자료)
 
 [42 32] [24 60] [15] 각각 세트로 만들어서 세트 안의 데이터를 정렬하는 식으로 반복
 [32 42] [24 60] [15]
 
 [32 42 24 60] [15]
 [24 32 42 60] [15]
 
 [24 32 42 60 15]
 [15 24 32 42 60]
 
 15 24 32 42 60
 
 
 
 두 개의 세트를 병합하는 과정
 1. 각각 정렬되어있는 세트의 첫 인덱스에 포인터 설정
 2. 두 포인터의 값을 비교해서 작은 값을 새 배열에 순서대로 넣어준다.
 3. 작은 값의 데이터 포인터를 한 칸 뒤로 넘김
 
  ^         ^
 [1 3 5 7] [2 4 6 8]  [              ]
 
    ^       ^
 [1 3 5 7] [2 4 6 8]  [1             ]
 
    ^         ^
 [1 3 5 7] [2 4 6 8]  [1,2           ]
 
      ^       ^
 [1 3 5 7] [2 4 6 8]  [1,2,3         ]
 
 .....
 
        ^         ^
 [1 3 5 7] [2 4 6 8]  [1,2,3,4,5,6,7,8]
 
 
 */

//Arrays 배열메소드  
//Arrays.copyOf(원본배열, 복사할길이);
//Arrays.copyOfRange(원본배열, 복사시작인덱스(포함), 복사끝인덱스(미포함));


package basic_algorithm.mergesortAlgorithm;

import java.util.Arrays;

public class mergesortExample {
	
	//배열을 매개변수로 받는 mergeSort 함수 생성
	public static int[] mergeSort(int[] arr) {
		
		//매개변수 배열의 길이가 2 미만(=1)이면 배열을 반환
		if(arr.length < 2) {
			return arr;
		}
		
		//중간 인덱스값 생성
		int mid = arr.length/2;
		
		//중간 인덱스로부터 low배열과 high 배열로 나누고 재귀함수를 통해 배열길이 1이 될 때까지 나눈 후 병합정렬 하기
		int[] low_arr = mergeSort(Arrays.copyOfRange(arr, 0, mid)); 
		int[] high_arr = mergeSort(Arrays.copyOfRange(arr, mid, arr.length)); 
		
		/*
		 재귀로 arr 쪼개기
		 								arr
		 		
		 			low										high
		 	low				high					low				high
		 low  high		low		high			low		high	low		high
		 정렬		정렬		정렬		정렬				정렬		정렬		정렬		정렬
		 	low병합	      high병합				  low병합		      high 병합
		 			병합										병합
		 							최종병합
		 
		 */
		
		//병합과정 메소드
		//병합된 데이터 넣을 배열 생성
		int[] mergedArr = new int[arr.length];
		//미들, 로우, 하이 포인터 설정
		int m=0, l=0, h=0;
		
		//각 배열 길이만큼 포인터끼리 비교해서 병합된 배열에 작은 데이터 부터 넣고 포인터는 뒤로 밀기
		while(l < low_arr.length && h < high_arr.length) {
			if(low_arr[l] < high_arr[h]) {
				mergedArr[m++] = low_arr[l++];
			}
			else {
				mergedArr[m++] = high_arr[h++];
			}
		}
		
		//두 배열 중 한 배열의 포인터가 전부 밀린 상황일 때 나머지 배열 포인터 밀면서 배열에 넣기
		while(l < low_arr.length) {
			mergedArr[m++] = low_arr[l++];
		}
		
		//두 배열 중 한 배열의 포인터가 전부 밀린 상황일 때 나머지 배열 포인터 밀면서 배열에 넣기
		while(h < high_arr.length) {
			mergedArr[m++] = high_arr[h++];
		}
		
		return mergedArr;
	}

	public static void main(String[] args) {
	
		int[] arr = {7,6,9,1,2,5,4,3,10};
		
		for(int i :mergeSort(arr)) {
			System.out.print(i + " ");
		}
		
	}

}









