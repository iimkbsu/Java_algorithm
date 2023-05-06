/*
배열 = [1,2,3,4,5....]
배열의 특징
1. 인덱스를 사용하여 값에 바로 접근 가능 (접근 속도 빠름)
2. 새로운 값을 삽입하거나 특정 인덱스에 있는 값을 삭제하기 어렵다. 해당 인덱스 주변의 값을 이동시키는 과정이 필요하기 때문
3. 배열의 크기는 선언할 때 지정하고, 선언된 배열 크기는 수정할 수 없음
4. 코테 대부분 배열 사용




리스트 = 값, 포인터를 묶은 노드를 포인터로 연결한 자료구조
[1] ->포인터 [3] ->포인터 [7]

리스트 특징
1. 인덱스가 없어 Head 포인터부터 순서대로 접근해야 함 (원하는 값에 접근 속도 느림)
2. 포인터로 연결되어 있어 데이터 삽입, 삭제 속도는 빠름
3. 산언 시 리스크 크기 설정 필요 없음, 크기 수정 가능
4. 포인터 저장해야 하므로 배열보다 구조 복잡
*/

//자바는 ArrayList, LinkedList 다 구현되어있으므로 갖다 사용하면 됨

/* 
 array(배열)			ArrayList(배열리스트)
 길이수정 x				길이수정 o
 프리미티브+객체보유			객체만 보유
 다차원 가능				1차원만 가능
 length로 길이확인			size()로 길이확인
 정적 배열					동적배열 (필요할 때 크기 조절가능)
 연산 빠름					array에 비해 느린
 



*/

package array_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;


public class arraylist {
	
	
	
	//workers 중첩클래스 생성
	public class Workers{
		
		//필드선언
		private String name;
		private int age;
		
		//생성자 선언
		Workers(String name, int age){
			this.name = name;
			this.age = age;
		}
		
		
		String getName() {
			return name;
		}
		
		int getAge() {
			return age;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	static void array(){
		
		//배열
		int[] array = {7,3,1,2,1,4,10,9,20,5};
		
		//배열 최소값, 최대값 구하는 방법1
		int min = array[0];
		int max = array[0];
		
		for(int i=0; i<array.length; i++) {
			
			if(max < array[i]) {
				max = array[i];
			}
			if(min > array[i]) {
				min = array[i];
			}
		}
		
		
		
		//배열 최소, 최대값 구하는 방법2
		int mmin = 9999; //최대값의 경계값 넣어주는 게 좋음
		int mmax = 0; //최소값의 경계값 넣어주는 게 좋음
		
		for(int a : array) {
			mmax = Math.max(a, mmax);
		}
		for(int b : array) {
			mmin = Math.min(b, mmin);
		}
		
		
		//배열 최소, 최대값 구하는 방법3 (Arrays.sort(배열) : 오름차순 정렬)
		
		int[] arrays = {7,3,1,2,1,4,10,9,20,5};
		System.out.println("초기 배열: "+Arrays.toString(arrays));
		Arrays.sort(arrays);
		System.out.println("sort(초기배열) : " + Arrays.toString(arrays));
		int mmmin = arrays[0];
		int mmmax = arrays[arrays.length-1];
		
		
		//sort(배열) 내림차순정렬, int[] 를 Integer[]로 바꿔줘야 컴파일 에러 안 남, sort(첫 인자, 둘 인자)에서 첫 인자는 int[] 대신 T[]를 필요로 함
		//int[] 배열을 Integer[] 배열로 바꾸는 작업
		Integer[] arrayss = {7,3,1,2,1,4,10,9,20,5};
		Arrays.sort(arrayss, Collections.reverseOrder());
		System.out.println("sort(초기배열, Collections.reverseOrder()) : "+Arrays.toString(arrayss));
		
	}
	
	

	
	void settingList() {
		
		//배열리스트 & 링크드리스트
		ArrayList myAlist = new ArrayList();
		ArrayList<Integer> myIAlist = new ArrayList<>();
		ArrayList<Integer> myIAlist1 = new ArrayList<>(Arrays.asList(2,3,4,5,6,7)); //생성과 동시에 데이터 추가 가능 (Arrays.asList는 고정데이터로 생성되어 삭제 삽입 불가)
		ArrayList<Boolean> myBAlist = new ArrayList<>();
		
		
		LinkedList myLlist = new LinkedList();
		LinkedList<Integer> myILlist = new LinkedList<>();
		LinkedList<Integer> myILlist1 = new LinkedList<>(Arrays.asList(3,4,5,6,7)); //생성과 동시에 데이터 추가 가능 (Arrays.asList는 고정데이터로 생성되어 삭제 삽입 불가)
		LinkedList<Boolean> myBLlist = new LinkedList<>();
		
		//제네릭 workers 객테타입을 받아서 LinkedList 생성
		LinkedList<Workers> myWLlist = new LinkedList<>();
		
		//Workers 클래스로 객체 생성한 후 이를 링크드리스트에 저장
		myWLlist.add(new Workers("홍길동", 33));
		
		//Workers 클래스 타입으로 링크드리스트에 첫번째 데이터를 가져와서 출력
		Workers myworkers1 = myWLlist.getFirst();
		System.out.println("이름 : " + myworkers1.getName() + ", 나이 : " + myworkers1.getAge());
		System.out.println();
		
		//ArrayList 메소드
		//LinkedList 메소드와 같음
		
		
		//LinkedList 메소드 
		myILlist.addFirst(1); //첫번 째 1 추가
		myILlist.add(2); //2 추가
		myILlist.add(2,3); // 인덱스2에  3 추가
		myILlist.add(7);
		myILlist.add(5);
		myILlist.add(6);
		myILlist.addLast(7); //마지막에 7 추가
		myILlist.remove(5); //리스트에서 인덱스5 데이터 제거
		
		System.out.println("LinkedList : " + myILlist);
		System.out.println("size() :"+myILlist.size());
		System.out.println("get(3) : "+myILlist.get(3));
		myILlist.set(3, 10);
		System.out.println("set(3,10) -> get(3) : "+myILlist.get(3));
		System.out.println();
		
		myILlist.removeFirst(); //가장 앞의 인덱스 데이터 제거
		System.out.println("removeFirst() : " + myILlist);
		System.out.println();
		myILlist.removeLast(); //가장 뒤의 인덱스 데이터 제거
		System.out.println("removeLast() :" + myILlist);
		System.out.println();
		myILlist.remove(); //생략시 0번째 index 데이터 제거
		System.out.println("remove() :" + myILlist);
		System.out.println();
		myILlist.remove(1); //index 1 제거
		System.out.println("remove(1) :" + myILlist);
		System.out.println("size() :"+myILlist.size());
		System.out.println();
		
		myILlist.clear(); //모든 값 제거
		System.out.println("myILlist.clear() : " + myILlist);
		System.out.println("size() :"+myILlist.size());
		System.out.println("isEmpty() : "+myILlist.isEmpty());
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {

		arraylist.array();
		System.out.println();
		System.out.println("======================");
		
		
		System.out.println("ArrayList and LinkedList");
		arraylist al = new arraylist();
		al.settingList();
		
		
		
	}

}
