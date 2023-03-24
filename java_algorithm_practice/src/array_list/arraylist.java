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

package array_list;

import java.util.ArrayList;
import java.util.LinkedList;


public class arraylist {
	
	//배열
	int[] array = {1,2,3,4,5};	
	//리스트
	ArrayList myAlist = new ArrayList();
	LinkedList myLlist = new LinkedList();
	
	void settingList() {
		myAlist.add(10);
		myAlist.remove(3);
		
		myLlist.add(10);
		myLlist.remove(6);
	}
	
	
	public static void main(String[] args) {

		
	}

}
