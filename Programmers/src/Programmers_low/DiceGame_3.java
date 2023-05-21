package Programmers_low;

import java.util.Arrays;



public class DiceGame_3 {
	
	public static int solution(int a, int b, int c ,int d) {
		int answer = 0;
		
		
		int[] dice = {a,b,c,d};
		Arrays.sort(dice);
		
		//a=dice[0]
		//b=dice[1]
		//c=dice[2]
		//d=dice[3]
		
		if(dice[1]==dice[2]) {
			if(dice[0]==dice[1]) {
				if(dice[2]==dice[3]) {
					answer = dice[0]*1000 + dice[0]*100 + dice[0]*10 + dice[0];
				}else if(dice[2]!=dice[3]) {
					answer = (int)Math.pow(10*dice[0] + dice[3], 2);
				}
			}else if(dice[0] != dice[1]) {
				if(dice[2] == dice[3]) {
					answer = (int)Math.pow(10*dice[2] + dice[0], 2);
				}else if(dice[2] != dice[3]) {
					answer = dice[0] * dice[3];
				}
			}
		}else if(dice[1]!=dice[2]) {
			if(dice[0]==dice[1]) {
				if(dice[2]==dice[3]) {
					answer = (dice[0]+dice[2]) * (dice[2]-dice[0]);
				}else if(dice[2]!=dice[3]) {
					answer = dice[2]*dice[3];
				}
			}else if(dice[0]!=dice[1]) {
				if(dice[2] == dice[3]) {
					answer = dice[0] * dice[1];
				}else if(dice[2] != dice[3]){
					answer = dice[0];
				}
			}
		}
		
		
		return answer;
	}

	
	
	
	public static void main(String[] args) {
		
		System.out.println(solution(6,4,2,5));
	
	}

}
