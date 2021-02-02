package solutionLevel1;

import java.util.ArrayList;
import java.util.Collections;

public class Kplayer {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int[] answer = new Kplayer().solution(array, commands);
		for(int i : answer){
			System.out.println(i);
		}
	}
	
	public int[] solution(int[] array, int[][] commands) {//k번째수
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0; i < commands.length; i++){
        	int[] temp = {0,0,0}; 
        	for(int j = 0; j < commands[i].length; j++){
        		list = new ArrayList<>();
        		temp[j] = commands[i][j];
        		for(int k = temp[0]-1; k <= temp[1]-1; k++ ){
        			list.add(array[k]);
        		}
        		
        	}
        	Collections.sort(list);
        	answerList.add(list.get(commands[i][2]-1));
        }
        
        answer = new int[commands.length];
        for(int i =0; i< commands.length; i++){
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
