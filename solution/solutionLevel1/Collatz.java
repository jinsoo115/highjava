package solutionLevel1;

public class Collatz { // 콜라츠 추측
	public static void main(String[] args) {
//		int n = 6;
//		int n = 16;
		int n = 626331;
		System.out.println(new Collatz().solution(n));
	}
	public int solution(int num) {
		long n = (long)num;
		int answer = 0;
		if (n == 1) return 0;
		while(n > 1){
			if(n % 2 == 0){
				n = n / 2;
				answer++;
			}else if(n % 2 == 1){
				n = (n * 3) + 1;
				answer++;
			}
			if(answer >= 500){
				return -1;
			}
		}
		
		return answer;
		
	}
}
