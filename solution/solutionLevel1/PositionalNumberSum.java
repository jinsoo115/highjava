package solutionLevel1;

public class PositionalNumberSum {	// 자릿수 더하기
	public static void main(String[] args) {
		int N = 123;
//		int N = 987;
		System.out.println(new PositionalNumberSum().solution(N));
	}
	
	public int solution(int n) {
        int answer = 0;
        
        StringBuffer s = new StringBuffer(Integer.toString(n));
        
        for(int i = 0; i < s.length(); i++){
        	answer += Character.getNumericValue(s.charAt(i));//char형 Int로 변환하기
        	
        }
        return answer;
    }
}
