/*
 너비우선탐색(BFS) : 그래프 완전 탐색 기법
 방법 : 시작 노드를 기준으로 가까운 노드 순으로 탐색함, 목표 노드에 도착하는 경로가 여러 개일 때 최단 경로 보장
 특징 : FIFO탐색 or 큐 이용
 시간복잡도 : O(V+E) (V:노드 수, E:엣지 수)
 
 깊이우선탐색 FILO(스택) vs 너비우선탐색 FIFO(큐)
 
 
  <과정>
 1. 그래프를 인접리스트로 표현
 
 <그래프>
  시작
  (1) →  (2) → (5)
   |        ↘ 
   ↓          ↘
  (3) → (4) → (6)

 <인접리스트>
 시작 
  1 → 2,3
  2 → 5,6
  3 → 4
  4 → 6
  5
  6
 
 
 2. 방문 배열 작성 (현재 방문 중인 노드에 true or int형으로 0,1 해도 됨)
 1 2 3 4 5 6
 t f f f f f
 
 
 
 3. 큐에 시작점 더하기
 -----------------
 노드1
 -----------------
 
 
 4. 큐에서 poll 또는 remove 연산으로 노드를 꺼내고 탐색순서에 기록, 인접 노드 큐에 삽입
 ------------------
 노드3  노드2             -> 노드1 poll
 ------------------
 
 
 5. 노드 삽입 후 방문 배열 작성
 1 2 3 4 5 6
 t t t f f f
 
 
 
 
 
 
 */


package basic_algorithm.BFSAlgorithm;

import java.util.Queue;
import java.util.LinkedList;

public class breadthfirstsearchExample {
	

	public class BFS{
		
		//8개 노드 방문 배열 작성
		static boolean[] visited = new boolean[8];
		//그래프를 인접리스트로 작성
		static int[][] graph = {{2,3,8},{1,6,8},{1,5},{5,7},{3,4,7},{2},{4,5},{1,2}};
		
		//정수형 큐 사용하기 위해 연결리스트로 객체 생성
		static Queue<Integer> myqueue = new LinkedList<>();
		
		//함수작성
		static void bfs_a() {
			//큐에 시작노드 넣고 방문배열 true
			myqueue.add(0);
			visited[0] = true;
			
			//큐가 비기 전까지 반복
			while(!myqueue.isEmpty()) {
				//노드인데스 만들고 큐 front에서 poll된 데이터 넣어줌
				int nodeIndex = myqueue.poll();
				//출력할 때 노드인텍스는 0부터이고 그래프는 1부터이므로 +1 해줌
				System.out.print(nodeIndex +1 + " → ");
				
				//향상된 for문 사용하여 LinkedNode에 graph 노드 순서대로 넣어주면서 방문여부 확인하고 방문 하지 않았을 경우 방문배열 true 해주고 큐에 노드 입력
				for(int LinkedNode : graph[nodeIndex]) {
					if(!visited[LinkedNode-1]) {
						myqueue.add(LinkedNode-1);
						visited[LinkedNode-1] = true;
					}
				}
			}
		}
		
		
	}
	
	
	public static void main(String[] args) {	
		BFS.bfs_a();
	}

}










