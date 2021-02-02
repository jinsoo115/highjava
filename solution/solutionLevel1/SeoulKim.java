package solutionLevel1;

public class SeoulKim {// 서울에서 김서방 찾기
	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		
		String answer = new SeoulKim().solution(seoul);
		System.out.println(answer);
	}
	
	public String solution(String[] seoul) {
        String answer = "";
        for(int i = 0; i < seoul.length; i++){
        	if(seoul[i].equals("Kim")){
        		answer = "김서방은 "+i+"에 있다";
        	}
        }
        return answer;
    }
}
