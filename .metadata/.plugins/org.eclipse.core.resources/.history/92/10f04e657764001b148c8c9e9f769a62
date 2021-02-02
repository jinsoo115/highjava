package solutionLevel1;

public class MatrixSum {// 행렬의 덧셈
	public static void main(String[] args) {
		int[][] arr1 = {{1,2},{2,3}};
//		int[][] arr1 = {{1},{2}};
		int[][] arr2 = {{3,4},{5,6}};
//		int[][] arr2 = {{3},{4}};
		int[][] answer = new MatrixSum().solution(arr1, arr2);
		for(int i = 0; i< answer.length; i++){
			for(int j = 0; j<answer[i].length; j++){
				System.out.println(answer[i][j]);
			}
		}
	}
	public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i = 0; i< arr1.length; i++){
			for(int j = 0; j<arr2[i].length; j++){
				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}
        return answer;
    }
}