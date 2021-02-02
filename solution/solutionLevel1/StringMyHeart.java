package solutionLevel1;

import java.util.Arrays;


public class StringMyHeart { // 문자열 내 마음대로 정렬하기
	public static void main(String[] args) {
//		String[] strings = {"sun", "bed", "car"};
		String[] strings = {"abce", "abcd", "cdx"};
		
//		int n = 1;
		int n = 2;
		
		String[] answer = new StringMyHeart().solution(strings, n);
		for(String s : answer){
			System.out.println(s);
		}
	}
	public String[] solution(String[] strings, int n) {
		String[] answer = {};
		answer = new String[strings.length];
		for(int i = 0; i <strings.length; i++){
			strings[i] = strings[i].charAt(n) + strings[i]; // charAt(n)로 비교 하고자 하는 위치의 문자를 맨 앞에 추가한다.
			System.out.println(strings[i]);
		}
		Arrays.sort(strings);
		
		for(int i = 0; i < strings.length; i++){
			answer[i] = strings[i].substring(1, strings[i].length()); // 추가 했던 맨 앞의 문자를 제외한 위치 부터 끝까지 다시 덮어씌운다.
		}
		return answer;
	}
	
	
}
