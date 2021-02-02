package solutionLevel1;

import java.util.ArrayList;
import java.util.Arrays;

public class DoubleSum {
	public static void main(String[] args) {
//		int[] numbers = {2, 1, 3, 4, 1};
		int[] numbers = {5, 0, 2, 7};
		int[] answers = new DoubleSum().solution(numbers);
		for(int i : answers){
			System.out.println(i);
		}
	}
	
	public int[] solution(int[] numbers) {//두개 뽑아서 더하기
	 	ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};
        int count = 0;
        for(int i = 0; i < numbers.length-1; i++){
    		for(int j = i+1; j < numbers.length; j++){
    			int sum = numbers[i] + numbers[j];
    			if(list.indexOf(sum)<0){
    				list.add(sum);
    			}
    		}
    	}

        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
        	answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
