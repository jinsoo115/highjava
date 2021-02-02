package solutionLevel1;

public class xSpaceNInt {// x만큼 간격이 있는 n개의 숫자
	public static void main(String[] args) {
		int x = 2;
		int n = 5;
		long[] answer = new xSpaceNInt().solution(x, n);
		for(long i : answer){
			System.out.println(i);
		}
	}
	public long[] solution(int x, int n) {
        long[] answer = new long[n];
        answer[0] = x;
        for(int i = 1; i < n; i++){
        	answer[i] += answer[i-1]+x; 
        }
        return answer;
    }
}
