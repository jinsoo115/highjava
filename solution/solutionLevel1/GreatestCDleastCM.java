package solutionLevel1;

public class GreatestCDleastCM { // 최대공약수와 최소공배수
	public static void main(String[] args) {
//		int n = 3;
		int n = 2;
//		int m = 12;
		int m = 5;
		int[] answer = new GreatestCDleastCM().solution(n, m);
		for(int i : answer){
			System.out.println(i);
		}
		
	}
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = n;
        int b = m;
        while(b !=0){
        	int r = a % b;
        	a = b;
        	b = r;
        }
        answer[0] = a; // 최소공배수
        answer[1] = n * m / answer[0]; // 최대공약수
        return answer;
    }
}
