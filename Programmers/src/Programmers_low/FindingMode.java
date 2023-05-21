
/*
 
 최빈값 구하기
 
	문제 설명
	최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

제한사항
	0 < array의 길이 < 100
	0 ≤ array의 원소 < 1000
입출력 예
	array					result
	[1, 2, 3, 3, 3, 4]		3
	[1, 1, 2, 2]			-1
	[1]						1
 
 
 */


package Programmers_low;

import java.util.Arrays;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import java.util.List;
import java.util.ArrayList;


public class FindingMode {
	
	
	//단순 반복문으로 하기
	public static int solution(int[] array) {
		
		int answer = 0;
        int len = array.length;
        
        Arrays.sort(array);
        int max = array[len-1];
        
        int[] counts = new int[max+1];
        for(int i=0; i<len; i++){
            counts[array[i]]++;
        }
        max = counts[0];
        
        for(int j=1; j<counts.length; j++){
            if(max < counts[j]) {
                max = counts[j];
                answer = j;
            }else if(max == counts[j]) answer = -1;
        }
        
        return answer;
	}
	
	
	//Map 사용하기
	public static int solution2(int[] array) {
		int answer = 0;
		
		int maxCount = 0;
		Map<Integer, Integer> myMap = new HashMap<>();
		for(int num : array) {
			int count = myMap.getOrDefault(num, 0) + 1;
			if(count > maxCount) {
				maxCount = count;
				answer = num;
			}else if(count == maxCount) answer = -1;
			myMap.put(num, count);
		}
		
		
		return answer;
	}
	
	//collect(Collectors.groupingBy(->,Collectors.메소드())) 사용하기
	public static int solution3(int[] array) {
		int answer = 0;

		
		List<Map.Entry<Integer, List<Integer>>> myList = new ArrayList<>(
				Arrays.stream(array).boxed().collect(Collectors.groupingBy(num -> num)).entrySet()
				).stream()
				.sorted((num0, num1) -> Integer.compare(num1.getValue().size(), num0.getValue().size()))
				.collect(Collectors.toList());
				
		answer = (myList.size() > 1) && (myList.get(0).getValue().size() - myList.get(1).getValue().size() == 0) ? -1 : myList.get(0).getKey();
		
		return answer;
	}
	
	
	
	public static void main(String[] args) {
		int[] array = {1,2,3,3,3,4};
		System.out.println(solution(array));
		
		int[] ar = {1,1,2,2};
		System.out.println(solution2(ar));
		
		int[] arr = {1};
		System.out.println(solution3(arr));

	}

}
