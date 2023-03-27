/*
 
 탐욕 알고리즘 :  각 선택이 최선이라면 전부 모여서 전체 선택도 최선이 될 거라고 가정하는 알고리즘
 
 특징 : 최선의 선택이 모여도 전체가 최선의 선택이라는 보장은 없음! (백트래킹을 통해 앞에서 추가 점검 하지 않고 조건에 맞게 선택 되었다면 최선이라 가정하고 그냥 넘어감)
 
 		(B) 
   10↗	     1↘
 (A) 1→ (C) 150→ (E)
   100↘	   300↗
 		(D)
 		
 위의 경우 
 실제 최적은 A→B→E (10+1)
 그리디 알고리즘 적용 A→C→E (1+150)
 
 
 
 활용 : (활동 선택 문제) 동전 개수 최솟값 구하기, 카드 정렬하기, 여러 수를 묶어서 최대 수 도출하기, 자리 배정, 최솟값을 만드는 괄호 배치 찾기 등
 
 과정
 1. 해 선택 : 현재 상태에서 가장 최선이라고 생각되는 해를 선택
 2. 적절성 검사 : 현재 선택한 해가 제약조건에서 벗어나지 않는지 검사
 3. 해 검사 : 현재까지 선택한 해 집합이 전체 문제 해결 가능한지 검사
 4. 해 검사에서 문제 해결이 안 된다면 1의 과정으로 돌아감
 
 
 
 
 
 
 */


package basic_algorithm.greedyAlgorithm;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class greedyExample {
	
	
	
	//동전으로 거슬러 줄 때 동전 전체가 최소의 개수가 되는 그리디 알고리즘 (거슬러 줄 동전 상위 단위가 하위 단위의 배수이기 때문에 그리디 사용 가능)
	public class coin_greedy{
		
		static int[] coinTypes = {500, 100, 50, 10, 5, 1};
		
		static void coin(int money) {
			System.out.println(money+"원 최소동전 개수로 거슬러주기");
			int n = money;
			int count = 0;
			for(int i=0; i<coinTypes.length; i++) {
				int cnt = 0;
				cnt += n/coinTypes[i];
				count += n/coinTypes[i];
				n %= coinTypes[i];
				System.out.println(coinTypes[i] + "원 : " + cnt + "개");
			}
			System.out.println("총 동전 : " + count + "개");

		}
	}
	
	
	
	
	
	//N과 K가 주어졌을 때 N이 1이 될 때까지 과정이 최소가 되는 프로그램 구현
	// 과정 : N에서 1 빼기 or N을 K로 나누기(N이 K로 나눠 떨어질 때만)
	// k가 2 이상이라는 조건이 있고, 1을  나눠 떨어질 때는 빼는 것 보다 무조건 나눠야 전체과정을 최소화 할 수 있음
	public class one_only{
		
		static void one(int n, int k) {
			System.out.println(n +"을 "+k+"로 나누거나, 나눠떨어지지 않을 때 " +n +"에서 1을 빼는 과정");
			
			int count = 0;
			
			while(n != 1) {
				count++;
				if(n%k == 0) {
					n /= k;
				}else {
					n -= 1;
				}
			}
			System.out.println("과정 최소횟수 : " +count);
		}
		
	}
	
	
	//숫자로만 구성된 문자열이 주어졌을 때 왼쪽부터 순서대로 + or * 연산을 하여 마지막에 가장 큰 수가 출력되도록 하는 프로그램 (연산자의 우선순위는 없음. 즉, 순서대로 연산됨)
	public class MultiorAdd {
		
		static void ma (String S) {
			//다음 수가 0,1 일때만 더해주고 나머지는 곱하면 제일 큰수가 나올 듯?
			String[] list = S.split("");
			int[] num = new int[list.length];
			int total = 0;
			
			for(int i=0; i<list.length; i++) {
				num[i] = Integer.parseInt(list[i]);	
			}
			
			total = num[0];
			
			for(int j=1; j<num.length; j++) {
				if(total == 1|| total == 0 || num[j] == 0 || num[j] == 1) {
					total += num[j];
				}else {
					total *= num[j];
				}
			}
			System.out.println(S + " 의 각 숫자들을 연산자 우선순위 없이 좌에서 우측 순으로 + 또는 * 계산하여 만들 수 있는 가장 큰 수");
			System.out.println("최대 수 : " + total);
		}
	}
	
	
	//모험가 길드가입 문제. 모험가는 공포도 수치를 갖고 있고 이 수치가 높으면 쉽게 공포를 느낌. 공포도가 x인 모험가는 x명 이상의 길드에만 가입 가능.
	// n명의 모험가의 공포도 수치가 주어졌을 때 최대로 만들 수 있는 길드의 수를 구하라
	public class argonautGuild {
		
		public static void guild(int n, int[] fear) {
			
			
			
			Arrays.sort(fear);//1,2,2,2,3
			
			Queue<Integer> myqueue = new LinkedList<>();
			
			for(int i=n-1; i>=0; i--) {
				myqueue.add(fear[i]);
				
			}
			System.out.println("모험가 공포도 : " + myqueue);
			
			int numGuild = 0;
			
			while(!(myqueue.size() == 0)) {
				int num = myqueue.peek();
				if(myqueue.size() >= num) {
					for(int i=0; i<num; i++) {
						myqueue.poll();
					}
					numGuild++;
				}else {
					break;
				}
			}
			System.out.println("최대로 만들 수 있는 길드 수 : " + numGuild);	
		}	
	}

	
	

	//테스트
	public static int n;
	public static ArrayList<Integer> myarr = new ArrayList<>();
	//
	
	
	public static void main(String[] args) {
		
		System.out.println("====== 탐욕 알고리즘 ======");
		System.out.println();
		
		coin_greedy.coin(1245);
		System.out.println();
		
		one_only.one(25, 3);
		System.out.println();
		
		String S = "00130012";
		MultiorAdd.ma(S);
		System.out.println();
		
		
		
		int[] fear = {1,2,3,4,5,6,7,8,7,7,4,5,2,2,5,6,3,5};
		argonautGuild.guild(fear.length, fear);
		System.out.println();
		
		
		
		
		//test용
		for(int i =0; i<fear.length; i++) {
			myarr.add(fear[i]);
		}
		
		//Integer 타입은 Arrays.sort() 사용 못 함. Collections.sort()사용
		Collections.sort(myarr);
				
		int result = 0;
		int count = 0;
		for(int i=0; i<fear.length; i++) {
			count ++;
			if(count >= myarr.get(i)) {
				result ++;
				count = 0;
			}
		}
		System.out.println("최대로 만들 수 있는 길드 수 : " + result);
		//
		

		
		
	}

}
