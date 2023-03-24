package linkedlist;

import java.util.LinkedList;
import java.util.Arrays;

class Student{
	int StudentID;
}

public class linkedListExample {
	
	int[] arrayInt = {1,2,3,4,5};

	LinkedList Llist = new LinkedList();
	
	LinkedList<Student> members = new LinkedList<Student>();
	LinkedList<Integer> num = new LinkedList<Integer>();
	LinkedList<Integer> num2 = new LinkedList<>();
	LinkedList<Integer> Llist2 = new LinkedList<>(Arrays.asList(1,2));
	//Arrays.asList()는 Arrays의 private 정적 클래스인 ArrayList를 리턴한다.
	
	
	
	
	public static void main(String[] args) {
		linkedListExample lle = new linkedListExample();
		
		lle.num2.addFirst(1); //Llist 링크드리스트 가장 앞에 1 추가
		lle.num2.add(10); // Llist 링크드리스트 가장 뒤에 10 추가
		lle.num2.addLast(33); // Llist 링크드리스트 가장 뒤에 33 추가
		lle.num2.add(3, 11); //Llist 링크드리스트 3번 인덱스 (0번부터 시작)에 10 추가
		
		lle.num.addFirst(3); // num<Integer> 링크드리스트 가장 뒤에 3 추가
		
		System.out.println(lle.num2.size());
		System.out.println(lle.num2); // 링크드 리스트로 출력됨
		System.out.println(lle.arrayInt); //일반 배열은 주소값 나옴
		for(int i=0; i<lle.arrayInt.length; i++) {
			System.out.print(lle.arrayInt[i] + " ");
		}

	}

}
