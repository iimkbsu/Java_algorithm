/*
 구간 합 : 합 배열을 이용하여 시간 복잡도를 줄이기 위해 특수 목적으로 사용하는 알고리즘
 
 합 배열을 만들고 구간 합을 구함
 
 (e.g.)
 S[i] = A[0] + A[1] + ... A[i];
 
 
 인덱스 0  1  2  3  4  5
 A[]  15 13 10 7  3  12
 S[]  15 28 38 45 48 60

 S[i] = S[i-1] + A[i];
 
 A[i]~A[j] 까지 구간 합 : S[j] - S[i-1];

*/
package prefix_sum;

public class prefixsumExample {
	
	int[] A = {1,2,3,4,5,6,7,8,9,10};
	
	
	
	private static int array(int start, int end) {
		prefixsumExample pfe = new prefixsumExample();
		
		int[] S = new int[11];
		int index = 0;
		int answer = 0;
		
		System.out.print("S[] = [");
		for(int i =1; i<=pfe.A.length; i++) {
			S[i] = S[i-1] + pfe.A[i-1];
			System.out.print(S[i-1] + " ");
			}
		System.out.println("]");
		answer = S[end + 1] - S[start];
		return answer;
	}
	
	

	public static void main(String[] args) {
		prefixsumExample dd = new prefixsumExample();

		System.out.print("A[] = [");
		for(int i=0; i<dd.A.length; i++) {
			System.out.print(dd.A[i]+ " ");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("A[3]~A[5] 까지 합 = " + array(3, 5));

	}

}
