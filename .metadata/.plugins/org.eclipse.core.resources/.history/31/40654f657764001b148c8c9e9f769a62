package solutionLevel1;

import java.util.ArrayList;
import java.util.Stack;

public class KaKaoCrane {// 카카오 크레인 인형 뽑기
	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		System.out.println(new KaKaoCrane().solution(board, moves));
	}
	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for(int move : moves){
			for(int j = 0; j < board.length; j++){
				if(board[j][move-1]!=0){
					if(stack.peek()==board[j][move-1]){
						stack.pop();
						answer +=2;
					}else{
						stack.push(board[j][move-1]);
					}
					board[j][move-1] = 0;
					break;
				}
			}
		}

		return answer;
	}

}
