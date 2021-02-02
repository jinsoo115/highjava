package solutionLevel1;

import java.util.ArrayList;

public class Equal {
	public static void main(String[] args) {
		int[] numbers = {1,1,3,3,0,1,1};
		int[] answers = new Equal().solution(numbers);
		for(int i : answers){
			System.out.println(i);
		}
	}
	public int[] solution(int []arr) {//같은숫자는 싫어
        ArrayList list = new ArrayList<>();
        int[] answer = {};
        list.add(arr[0]);
        for(int i =1; i<arr.length; i++){
            	if(arr[i-1] != arr[i]){
                list.add(arr[i]);
            }
        }
        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++){
            answer[i] = (int) list.get(i);
        }

        return answer;
    }
}
