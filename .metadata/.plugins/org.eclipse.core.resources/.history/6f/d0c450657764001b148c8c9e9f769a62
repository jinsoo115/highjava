package solutionLevel1;

public class Divisor {// 약수의 합
	public static void main(String[] args) {
		int n = 12;
		
		System.out.println(new Divisor().solution(n));
	}
	
	 public int solution(int n) {
	        int answer = 1;
	        if(n==0) return 0; // 0이 아닐경우도 있음;;
	        for(int i =2; i <n; i++){
	        	if(n%i==0){
	        		answer+=i;
	        	}
	        }
	        
	        return answer+n;
	    }
}
