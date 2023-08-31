package Programmers_low;

public class PolynomialPlus {
	
	public static String solution(String polyno) {
		String poly = polyno;
		String[] splits = poly.split(" [+] ");
		int countX = 0;
		int rest = 0;
		
		for(String tmp : splits) {
			if(tmp.contains("x")) {
				if(tmp.equals("x")) {
					countX++;
				}else {
					countX = countX + Integer.parseInt(tmp.substring(0, tmp.length() -1));
				}
			}else {
				rest += Integer.parseInt(tmp);
			}
		}
		
		String answer;
		
		if(rest == 0) {
			if(countX == 1) {
				answer = "x";
			}else {
				answer = countX +"x";
			}

		}else if(countX == 0) {
			answer = rest +"";
		}
		else{
			if(countX == 1) {
				answer = "x + " + rest;
			}else {
				answer = countX +"x + " + rest;
			}

		}
		
		return answer;
		
		

	}

	public static void main(String[] args) {
		
		String answer = solution("x + 1");
		System.out.println(answer);

	}

}
