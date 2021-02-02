package solutionLevel1;

import java.util.ArrayList;
import java.util.Arrays;

public class Division {
	public static void main(String[] args) {
//		int[] arr = {5, 9, 7, 10};
//		int divisor = 5;
//		int[] arr = {2, 36, 1, 3};
//		int divisor = 1;
		int[] arr = {3, 2, 6};
		int divisor = 10;
		
		int[] answers= new Division().solution(arr, divisor);
		for(int i : answers){
			System.out.println(i);
		}
	}
	
	public int[] solution(int[] arr, int divisor) {//나누어 떨어지는 숫자 배열

        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
        	if(arr[i] % divisor == 0){
        		list.add(arr[i]);
        	}
        }
        if(list.size()==0){
        	answer = new int[1];
        	answer[0] = -1;
        }else{
        	answer = new int[list.size()];
        	for(int i = 0; i < list.size(); i++){
        		answer[i] = list.get(i);
        	}
        }
        Arrays.sort(answer);
        return answer;
    }
}
