package solutionLevel1;

public class StringMiddle {
	public static void main(String[] args) {
//		String s = "abcde";
		String s = "qwer";
		
		String answer = new StringMiddle().solution(s);
		System.out.println(answer);
	}
	
	public String solution(String s) {//String의 중간 문자
        String answer = "";
        if(s.length()%2==1){
        	return Character.toString(s.charAt(s.length()/2));
        }else{
        	return s.substring(s.length()/2-1, s.length()/2+1);
        }
    }
}
