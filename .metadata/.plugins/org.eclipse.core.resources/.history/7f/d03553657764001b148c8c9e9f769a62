package solutionLevel1;

public class StringIntChange { // 문자열을 정수로 바꾸기
	public static void main(String[] args) {
		String s = "1234";
		int answer = new StringIntChange().solution(s);
		System.out.println(answer);
	}
	
	public int solution(String s) {
        int answer = 0;
        
        switch (s.charAt(0)) {
		case '+':
			answer += Integer.parseInt(s.substring(1, s.length())); 
			break;

		case '-':
			answer -= Integer.parseInt(s.substring(1, s.length()));
			break;
		default:
			answer = Integer.parseInt(s);
			break;
		}
        
        return answer;
    }
}
