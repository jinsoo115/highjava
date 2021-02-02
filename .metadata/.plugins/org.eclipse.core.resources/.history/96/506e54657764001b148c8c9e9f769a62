package solutionLevel1;

public class TwoNumGapSum {
	public static void main(String[] args) {
		int a=3;
		int b=5;
		long answer = new TwoNumGapSum().solution(a, b);
		System.out.println(answer);
	}
	
	public long solution(int a, int b) {//두 정수 사이의 합
        long answer = 0;
        if(a==b){
            answer=a;
        }else{
          if(a>b){
              answer=((a+b)*(a-b+1))/2;
          }else if(b>a){
              answer=((a+b)*(b-a+1))/2;
          }  
        } 
        return answer;
    }
}
