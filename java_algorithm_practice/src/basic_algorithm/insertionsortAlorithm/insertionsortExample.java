/*
 삽입정렬 : 두 번째 인덱스부터 시작하여 왼쪽 데이터와 비교하여 차순으로 자리교체 반복
 시간복잡도 : O(n^2) 버블정렬 선택정렬보다는 빠름
 
 방식 (오름차순일 경우)
 42 32 24 60 15 (주어진 자료)
 
 [32][42] 24 60 15 (0-1)
 
 32 [24][42] 60 15 (1-2)
 [24][32] 42 60 15 (0-1)
 
 24 32 42 60 15 (2-3) (변화없음)
 24 32 42 60 15 (1-2) (변화없음)
 24 32 42 60 15 (0-1) (변화없음)
 
 24 32 42 [15][60] (3-4)
 24 32 [15][42] 60 (2-3)
 24 [15][32] 42 60 (1-2)
 [15][24] 32 42 60 (0-1)
 
 */



package basic_algorithm.insertionsortAlorithm;

public class insertionsortExample {

	public static void main(String[] args) {
		
		int[] insertion = {42, 32, 24, 60, 15};

		//오름차순 삽입정렬
		for(int i=1; i<insertion.length; i++) {
			for(int j=i; j>0; j--) {
				if(insertion[j] < insertion[j-1]) {
					int tmp = insertion[j];
					insertion[j] = insertion[j-1];
					insertion[j-1] = tmp;
				}
			}
		}
		for(int i=0; i<insertion.length; i++) {
			System.out.print(insertion[i]+", ");
		}
	}

}
