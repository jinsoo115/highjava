package solutionLevel1;

import java.util.Arrays;

public class GymSuit {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {1,2,5};
		
//		int n = 5;
//		int[] lost = {2,4};
//		int[] reserve = {3};
//		
//		int n = 3;
//		int[] lost = {3};
//		int[] reserve = {1};
		
		
		
		int answer = new GymSuit().solution(n, lost, reserve);
		System.out.println(answer);
	}
	
	public int solution(int n, int[] lost, int[] reserve) {//체육복
        int answer = 0;
        answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i = 0; i < lost.length; i++){
        	for(int j = 0; j < reserve.length; j++){
        		if(lost[i]==reserve[j]){
        			lost[i] = -1;
        			reserve[j] = -1;
        			answer++;
        		}
        	}
        }
        for(int i = 0; i < lost.length; i++){
        	for(int j = 0; j < reserve.length; j++){
        		if(lost[i]-reserve[j]==1||reserve[j]-lost[i]==1){
        			lost[i] = -1;
        			reserve[j] = -1;
        			answer++;
        		}
        	}
        }
        return answer;
    }
}
