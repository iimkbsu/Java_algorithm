/*
 스택, 큐
 
 배열에서 발전된 형태
 두 자료구조는 형태는 비슷하나 자료 처리 방식이 다름
 
 **********************************************************************
 
 스택 (통 모양) - LIFO(Last In First Out, 후입선출), 삽입 삭제가 top 부분에서만 일어남
 
 |		|
 |	top	|			  <- 삽입 삭제가 일어나는 제일 끝 자료 위치
 |	자료	|
 |	자료	|
 ----------

 push 연산 : top 위치에 새로운 데이터 삽입
 pop 연산 : top 위치에 있는 데이터를 삭제하고 확인 (데이터 빼내서 확인)
 peek 연산 : top 위치에 있는 데이터를 단순화 (데이터 단순 확인)
 empty 연산 : 스택이 비어있는지 true false 반환
 search 연산 : 스택에서 주어진 객체 자료의 위치 반환 (스택 인덱스는 1부터 시작)
 
 종류 : 깊이 우선 탐색(DFS), 백트래킹, 재귀함수 알고리즘(후입선출)
 
 ************************************************************************
 
 큐 (관통형) - FIFO(First In First Out, 선입선출), 삽입은 rear 삭제는 front에서 일어남
 
 							peek할 위치
 		------------------------
 add ->	새값 값 값 값 값 값 값 값 지울값 ->poll
 		------------------------
 		rear				front
 
 
 add 연산 : rear 부분에 새로운 데이터 삽입, 성공하면 true 실패하면 false 반환
 poll 연산 : front 부분에 있는 데이터 삭제 후 확인 (데이터 빼내서 확인), 비어있으면 null 반환
 peek 연산 : front 부분에 있는 데이터 단순 확인 (데이터 단순 확인), 비어있으면 null 반환
 element 연산 : front 부분에 있는 데이터 단순 확인, 비어있으면 예외처리 발생(Exception)
 isEmpty 연산 : 큐가 비어있는지 확인하여 true false 반환
 
 remove(지울 값)
 
 
비어있을 시		예외발생			true false 리턴 
추가			add()			offer()
삭제			remove()		poll()
검사			element()		peek()
 
 
 
 종류 : 너비 우선 탐색 (BFS)
 
 ******************************************************************************
 
 우선순위 큐 (힙을 이용한 큐) : 트리구조를 가짐
 
 
 */


package stack_que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class stackQue {

	public static void main(String[] args) {
		
		//stack은 클래스로 구현되어있음
		//queue는 인터페이스만 구현되어 있어서 linkedlist 클래스를 객체로 사용해야 함
		
		Stack<Integer> mystack = new Stack<>();
		Queue<Integer> myqueue = new LinkedList<>();
		
		mystack.push(0);
		mystack.push(1);
		mystack.push(2);
		mystack.push(3);
		
		myqueue.add(0);
		myqueue.offer(1);
		myqueue.add(2);
		myqueue.offer(3);
		
		System.out.println("stack : "+mystack);
		System.out.println("queue : "+myqueue);
		
		System.out.println("stack top 데이터 : " + mystack.peek());
		System.out.println("queue front 데이터 : "+myqueue.peek());
		
		mystack.pop();
		mystack.pop();
		myqueue.remove(2); //큐에서 2 제거
		myqueue.poll(); // 큐에서 front 제거
		
		System.out.println("pop() 두 번 한 stack : "+mystack);
		System.out.println("2를 삭제하고 front에서 하나 삭제한 queue : " +myqueue);
		
		System.out.println("스택 비어있나 : "+mystack.empty());
		System.out.println("스택 비어있나 : "+mystack.isEmpty());
		System.out.println("큐 비어있나 : "+myqueue.isEmpty());
		

		
		System.out.println("stack에서 데이터 1의 인덱스 :"+mystack.search(1) + "   stack에서 데이터 0의 인덱스 :"+ mystack.search(0));
		System.out.println("큐의 front 값 확인 :" + myqueue.element());
	}

}




