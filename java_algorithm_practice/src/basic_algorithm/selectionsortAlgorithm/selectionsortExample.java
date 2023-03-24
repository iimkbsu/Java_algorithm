/*
 
 선택정렬 : 나열된 데이터를 모두 검사한 후 가장 작은 또는 큰 수를 선택하여 가장 앞 또는 뒤로 바꿔준 후 그 수는 제외하고 이를 반복
 시간복잡도 : O(n^2), 버블정렬과 빅오는 같으나 버블정렬보다는 빠름
 
 방식 (오름차순일 경우, 작은 수 선택)
 42 32 24 60 15 (주어진 자료)
 
 32 42 24 60 15 (인덱스0번에 가장 작은 수 넣기)
 24 42 32 60 15
 15 42 32 60 24
 
 [15] 32 42 60 24 (인덱스0 고정, 인덱스1번에 가장 작은 수 넣기)
 [15] 24 42 60 32
 
 [15][24] 32 60 42 (인덱스0,1 고정, 인덱스2에 가장 작은 수 넣기)
 
 [15][24][32] 42 60 (인덱스0,1,2고정, 인덱스3에 가장 작은 수 넣기) 

 
 
 */


package basic_algorithm.selectionsortAlgorithm;

public class selectionsortExample {
	
	public static void main(String[] args) {
		
		int[] selection = {5,3,1,4,2};
		
		//오름차순 선택 정렬
		for(int i=0; i<selection.length; i++) {
			for(int j=i+1; j<selection.length; j++) {
				if(selection[i]>selection[j]) {
					int tmp = selection[j];
					selection[j] = selection[i];
					selection[i] = tmp;
				}
			}
		}
		for(int i=0; i<selection.length; i++) {
			System.out.print(selection[i]+", ");
		}

	}

}
