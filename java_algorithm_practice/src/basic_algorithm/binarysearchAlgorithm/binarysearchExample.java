/*
 
 분할정복 : 방대한 문제 해결에서 상단에서 분할, 중단에서 정복, 하단에서 조합 하는 형태로 여러 알고리즘의 기본 형태
 장점 - 어려운 문제를 해결할 수 있음
 단점 - 재귀적 함수 호출로 인해 오버헤드 발생, 스택 오버플로우 발생가능성, 과도한 메모리 사용 등
 
 분할정복 종류: 탐색 알고리즘, 정렬 알고리즘, 선택 알고리즘
 탐색 : 이진탐색
 정렬 : 퀵정렬, 합병(병합)정렬, 부분정렬
 선택 : 선형시간 선택
 
 
 그 외의 정렬 알고리즘 : 선택정렬, 삽입정렬, 버블정렬, 기수정렬
 ********************************************************************************
 
 이진탐색 : 정렬돼 있는 데이터에서 원하는 값을 찾는 탐색 알고리즘
 
 방법 : 졍렬돼 있는 데이터의 중앙값과 탐색하고자 하는 값을 비교하면서 비교 데이터 크기를 절반씩 줄이기
 특징 : 중앙값, 탐색데이터 거의 반씩 축소 
 시간복잡도 : O(logN)
 
 (코딩이 간단하고 시간복잡도가 준수하여 대부분의 데이터 탐색 과정에서 사용 됨)
 
 과정 (오름차순으로 정렬된 데이터에서 탐색하는 경우)
 1. 정렬되어 있는 데이터셋의 중앙값 선택 (중앙값 : 배열의 중간에 위치한 값, 평균값: 배열 값들을 모두 더해 배열 수로 나눈 값)
 2. 중앙값 > 타깃 데이터일 때 중앙값 기준으로 왼쪽 데이터셋 선택 (탐색할 데이터 반 줄음)
 3. 중앙값 < 타깃 데이터일 때 중앙값 기준으로 오른쪽 데이터셋 선택 (탐색할 데이터 반 줄음)
 4. 1~3 반복 후 중앙값 == 타깃일 때 종료
 
 
 
 
  
 */

package basic_algorithm.binarysearchAlgorithm;

import java.util.Arrays;

public class binarysearchExample {
	
	
	//재귀로 구현
	static boolean binarySearch_recursion(int[] arr, int n, int low, int high) {
		
		
		if(low > high) {
			System.out.println("매개변수가 잘못 입력되었습니다");
			return false;
		}
		
		int mid = (low + high) /2;
		
		if(arr[mid] < n) {
			return binarySearch_recursion(arr, n, mid + 1, high);
		}else if(arr[mid] > n) {
			return binarySearch_recursion(arr, n, low, mid -1);
		}else {
			return true;
		}	
	}
	
	
	//반복문으로 구현
	static boolean binarySearch_loop(int[] arr, int n) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		
		while(left <= right) {
			mid = (left + right)/2;
			
			if(arr[mid] < n) {
				left = mid + 1;
			}else if(arr[mid] > n) {
				right = mid - 1;
			}else {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		
		System.out.println(binarysearchExample.binarySearch_recursion(arr, 3, 1, 15));
		System.out.println(binarysearchExample.binarySearch_loop(arr, 3));
		
		//Arrays.binarySearch() 메소드 사용 (return: 타깃값의 인덱스 번호)
		System.out.println(Arrays.binarySearch(arr, 14));
	
	}

}





