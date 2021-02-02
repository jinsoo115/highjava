package solutionLevel1;

public class StrangeString {
	public static void main(String[] args) {
		String s = "try hello world";
		System.out.println(new StrangeString().solution(s));
	}
	
	public String solution(String s) {
        String answer = "";
        String[] a = s.split(" ", -1);
        
        for(int i = 0; i < a.length; i++){
        	if(i != 0){
        		answer += " ";
        	}
        	for(int j = 0; j < a[i].length(); j++){
        		if(j % 2 ==0){
        			answer += Character.toString(a[i].charAt(j)).toUpperCase();
        		}else{
        			answer += Character.toString(a[i].charAt(j)).toLowerCase();
        		}
        	}
        	
        }
        return answer;
    }
}
