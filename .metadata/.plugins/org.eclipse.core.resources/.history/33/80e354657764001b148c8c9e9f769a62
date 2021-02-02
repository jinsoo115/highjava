package solutionLevel1;

import java.util.Arrays;

public class MinDelete { // 제일 작은수 제거하기
	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
//		int[] arr = {10};
		
		int[] answer = new MinDelete().solution(arr);
		for(int i : answer){
			System.out.println(i);
		}
	}
	
	public int[] solution(int[] arr) {
        if(arr.length == 1){
        	int[] answer = new int[1];
        	answer[0] = -1;
        	return answer;
        }
        
        int a = arr[0];
        for(int i = 0; i < arr.length; i++){
        	if(a>arr[i]){
        		a = arr[i];
        	}
        }
        int q = 0; 
        int[] answer = new int[arr.length-1];
        for(int i = 0; i < arr.length; i++){
        	if(a != arr[i]){
        		answer[q] = arr[i];
        		q++;
        	}
        }
        
        return answer;
    }
}
