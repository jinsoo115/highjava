package solutionLevel1;

public class ThreeNumeral {
	public static void main(String[] args) {
//		int n = 45;
		int n = 125;
		int answer = new ThreeNumeral().solution(n);
		System.out.println(answer);
	}
	
	
	public int solution(int n) {
        int answer = 0;
        String str = "";
        while(n > 0 ){
        	str = (n % 3) + str;
        	n = n / 3;
        }
       
        String sReverse = new StringBuffer(str).reverse().toString();// 문자열 뒤집기
        answer = Integer.parseInt(sReverse, 3);
        return answer;
    }
	
}
