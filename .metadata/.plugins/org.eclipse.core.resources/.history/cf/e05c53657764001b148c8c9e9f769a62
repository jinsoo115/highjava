package solutionLevel1;

public class IntSqrt {// 제곱근 정수인지 확인하기
	
	public static void main(String[] args) {
//		 long n = 121;
		 long n = 3;
		 System.out.println(new IntSqrt().solution(n));
	}
	public long solution(long n) {
        long answer = 0;
        double a= Math.sqrt(n);
        int b = (int) Math.sqrt(n);
        
        if(a == b){
        	answer = (long) Math.pow(Math.sqrt(n)+1, 2);
        }else{
        	answer = -1L;
        }
        return answer;
    }
}
