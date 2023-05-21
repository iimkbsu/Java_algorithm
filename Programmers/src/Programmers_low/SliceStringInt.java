package Programmers_low;
import java.util.List;
import java.util.ArrayList;

public class SliceStringInt {

	public static void main(String[] args) {
		String[] strArray = solution("abc1Addfggg4556b", 6);
		
		for(String s : strArray) {
			System.out.println(s);
		}

	}
	
	public static String[] solution(String my_str, int n) {
        List<String> answer = new ArrayList<>();
        for (int i=0; i<(my_str.length()/n); i++) {
            answer.add(my_str.substring((n * i), (n * (i + 1))));
        }
        if (my_str.length() % n != 0) {
             answer.add(my_str.substring( (my_str.length() / n) * n));
        }
        return answer.toArray(new String[0]);
    }

}
