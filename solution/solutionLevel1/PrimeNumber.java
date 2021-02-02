package solutionLevel1;

public class PrimeNumber { //소수 찾기 에라토스테네스의 체 사용하기(포기)
	public static void main(String[] args) {
//		int n = 10;
		int n = 5;
		
		int answer = new PrimeNumber().solution(n);
		System.out.println(answer);
	}

	public int solution(int n) {
		int answer = 0;
		boolean[] sosu = new boolean[n+1]; 
		
		int root = (int)Math.sqrt(n); // 제곱근
		
		for (int i = 2; i <=root; i++){
			if(sosu[i]== false){
				for(int j = i; j*i <=n ;j++){
					sosu[j*i] = true;
				}
			}
		}
		
		
		for(int i = 2; i <= n; i++){
			if(sosu[i] == false) answer++;
		}
		
		
		return answer;
	}
}
