package solutionLevel1;

import java.util.Arrays;

public class IntArray {

	public static void main(String[] args) {// 자연수 뒤집어서 배열에 넣기
		long n = 12345L;
		System.out.println(new IntArray().solution(n));
	}
	public int[] solution(long n) {
        int[] answer = {};
        String s = Long.toString(n);
        answer = new int[s.length()];
        int l = 0;
        for(int i = s.length()-1; i >= 0; i--){
        	answer[l] = Character.getNumericValue(s.charAt(i));
        	l++;
        }
        for(int i : answer){
        	System.out.println(i);
        }
        return answer;
    }
}
