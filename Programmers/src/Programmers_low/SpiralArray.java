
// n이 매개변수로 들어왔을 때 1부터 n*n 까지 시계 반대방향으로 2차원 배열에 넣어서 출력해라

//입력 예제. 4
//출력 예제.	[[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]

//16 = 4 + 3 + 3 + 2 + 2 + 1 + 1
//25 = 5 + 4 + 4 + 3 + 3 + 2 + 2 + 1 + 1
//n*n = n + n-1 + n-1 + n-2 + n-2 + n-3 + n-3 + ... + 2 + 2 + 1 + 1

package Programmers_low;

public class SpiralArray {
	
	public static int[][] solution(int n) {
		int[][] arr = new int[n][n];

	    int num = 1;
	    int row = 0, col = 0;
	    int left = 0, right = n - 1, top = 0, bottom = n - 1;
	    int direction = 0; // 0: right, 1: down, 2: left, 3: up

	    while (num <= n * n) {
	        arr[row][col] = num++;

	        switch (direction) {
	            case 0:
	                if (col == right) {
	                    direction = 1;
	                    top++;
	                    row++;
	                } else {
	                    col++;
	                }
	                break;
	            case 1:
	                if (row == bottom) {
	                    direction = 2;
	                    right--;
	                    col--;
	                } else {
	                    row++;
	                }
	                break;
	            case 2:
	                if (col == left) {
	                    direction = 3;
	                    bottom--;
	                    row--;
	                } else {
	                    col--;
	                }
	                break;
	            case 3:
	                if (row == top) {
	                    direction = 0;
	                    left++;
	                    col++;
	                } else {
	                    row--;
	                }
	                break;
	        }
	    }
	    
	    for (int[] rowArr : arr) {
	        for (int numVal : rowArr) {
	            System.out.print(numVal + "\t");
	        }
	        System.out.println();
	    }
	    

	    return arr;
	}

	
	
	
	public static void main(String[] args) {
		
		solution(10);


	}

}
