package solutionLevel1;

public class StringBasic2 {// 문자열 다루기 기본
	public static void main(String[] args) {
		String s = "a234";
//		String s = "1234";
		
		boolean answer = new StringBasic2().solution(s);
		System.out.println(answer);
	}
	
	public boolean solution(String s) {
        if(s.length()==4 || s.length()==6)
            return s.matches("^[0-9]*$");
        return false;
	}
}
