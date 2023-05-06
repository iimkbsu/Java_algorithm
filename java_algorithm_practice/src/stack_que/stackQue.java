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

 Stack<E> myStack = new Stack<>();

	myStack.push(E item);		: top 자리에 item 삽입
	myStack.pop();				: top 자리에서 item 반출 (성공 item리턴/ 실패 예외발생)
	
	myStack.peek();				: top 자리 객체 확인 (성공 item리턴/ 실패 예외발생)
	myStack.empty();			: true/false 반환
	myStack.search(E item);		: item의 int 인덱스 반환 (1부터시작, 실패 -1 리턴)
	
 
 종류 : 깊이 우선 탐색(DFS), 백트래킹, 재귀함수 알고리즘(후입선출)
 
 ************************************************************************
 
 큐 (관통형) - FIFO(First In First Out, 선입선출), 삽입은 rear 삭제는 front에서 일어남
 
 							peek할 위치
 		------------------------
 add ->	새값 값 값 값 값 값 값 값 지울값 ->poll
 		------------------------
 		rear				front
 
 
 Queue<E> myQueue = new Queue<>();
 	
 	myQueue.offer(E e);		: e 삽입. (성공 true/ 실패 false)
 	myQueue.poll();			: front 자리에서 item 반출 (성공 item 리턴/ 실패 null 리턴)
 	
 	myQueue.add(E e);		: e 삽입. (성공 true/ 실패 예외발생)
 	myQueue.remove();		: front 자리에서 item 반출 (성공 item 리턴/ 실패 예외발생)
 	
 	myQueue.element();		: front 자리 객체 확인 (성공 item 리턴/ 실패 예외발생)
 	myQueue.peek();			: front 자리 객체 확인 (성공 item 리턴/ 실패 null 리턴)
 	myQueue.isEmpty();		: true/false 리턴

 
 
 
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




