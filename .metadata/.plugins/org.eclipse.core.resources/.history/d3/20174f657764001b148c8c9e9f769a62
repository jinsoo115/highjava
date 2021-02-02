package solutionLevel1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class IntSortDESC {// 정수를 내림차순으로
	public static void main(String[] args) {
		long n = 118372L;
		System.out.println(new IntSortDESC().solution(n));
	}
	public long solution(long n) {
		long answer = 0;
		String s = Long.toString(n);
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < s.length(); i++){
			 list.add(Character.getNumericValue(s.charAt(i))); 
		}
		Collections.sort(list, Collections.reverseOrder()); // 내림차순
		s = "";
		for(int i = 0; i < list.size(); i++){
			s += list.get(i);
		}
		
		return answer = Long.parseLong(s);
	}
}
