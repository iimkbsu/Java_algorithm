/*
 
 DFS(깊이 우선 탐색) : 그래프 완전 탐색 기법
 
 방법 : 그래프 시작 노드에서 출발, 분기를 나누고 먼저 탐색할 분기를 정하여 최대 깊이까지 탐색 후 다음 분기로 넘어가서 이를 반복
 특징 : 재귀함수 구현 or 스택(FILO) 이용, 스택 오버플로우 유의하며 사용해야 함
 시간복잡도 : O(V+E) (V:노드 수, E:엣지 수)
 활용 : 단절점 탐색, 단절선 탐색, 사이클 탐색, 위상 정렬 등
 
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
 
 3. 스택에 시작점 쌓기
 
 |		|
 |		|
 |		|
 |		|
 | 1노드	|
 --------
 
 4. 스택에서 pop 수행하여 노드를 꺼내고 탐색순서에 기록, 꺼낸 노드의 인접리스트 노드를 스택에 순서대로 쌓음
 
 |		|  pop 1노드
 |		|
 |		|
 | 3노드	|
 | 2노드	|
 --------
 
 5. 노드 삽입 후 방문 배열 작성
 1 2 3 4 5 6
 t t t f f f
 
 6. 스택에 값이 없을 때 까지 과정 반복 (방문 했던 노드는 재사용하지 않음)
 
 1 2 3 4 5 6
 t t t t t t
 
 */

package basic_algorithm.DFSAlgorithm;

import java.util.Stack;

public class depthfirstsearchExample {
	
	
	
	
	//-------------------------------------------------------------------
	//재귀를 사용한 DFS
	public class dfs_Recursion {
		
		//방문 배열
		static boolean[] visited = new boolean[9];
		//그래프를 인접리스트로 변환 (노드번호와 인덱스번호를 맞추기 위해 첫 배열은 공백으로)
		static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		
		static void dfs_r(int nodeIndex) {
			//방문처리
			visited[nodeIndex] = true;
			//방문 노드 출력
			System.out.print(nodeIndex + " → ");
			//방문한 노드의 인접 노드 찾기
			for(int node : graph[nodeIndex]) {
				if(!visited[node]) {
					dfs_r(node);
				}
			}
		}
		
	}
	
	//--------------------------------------------------------------------
	//스택을 사용한 DFS
	public class dfs_Stack {
		
		//방문 배열
		static boolean[] visited = new boolean[9];
		//그래프를 인접리스트로 변환 (노드번호와 인덱스번호를 맞추기 위해 첫 배열은 공백으로)
		static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		
		static Stack<Integer> mystack = new Stack<>();
		
		static void dfs_s() {
			mystack.push(1);
			visited[1] = true;
			
			//stack.empty 해도 됨
			while(!mystack.isEmpty()) {
				int nodeIndex = mystack.pop();
				System.out.print(nodeIndex + " → ");
				
				for(int LinkedNode : graph[nodeIndex]) {
					if(!visited[LinkedNode]) {
						mystack.push(LinkedNode);
						visited[LinkedNode] = true;
					}
				}
			}
		}
	}
	
	

	public static void main(String[] args) {
		dfs_Recursion.dfs_r(1);
		System.out.println();
		dfs_Stack.dfs_s();
		
		
	}

}
