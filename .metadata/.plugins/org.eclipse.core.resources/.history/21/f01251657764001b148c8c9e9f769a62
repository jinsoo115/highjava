package solutionLevel1;

import java.util.Arrays;

public class Finish {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "mislav", "ana"};
		/*String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};*/
		String answer = new Finish().solution(participant, completion);
		System.out.println(answer);
	}
	public String solution(String[] participant, String[] completion) {// 완주
		String answer = "";
		Arrays.sort(participant);
		Arrays.sort(completion);
		for(int i=0; i < completion.length; i++){
			if(!participant[i].equals(completion[i])){
				answer = participant[i];
				break;
			}else if(i==completion.length-1){
				answer = participant[completion.length];
				break;
			}
		}
		return answer;
	}
}
