package solutionLevel1;

public class CaesarCipher {

	public static void main(String[] args) { //시저 암호
//		String s = "AB";
//		String s = "z";
		String s = "a B z";
		
//		int n = 1;
//		int n = 1;
		int n = 4;
		
		System.out.println(new CaesarCipher().solution(s, n));
	}
	
	public String solution(String s, int n) {
        String answer = "";
        for(int i = 0; i < s.length(); i++){
        	char a = s.charAt(i);
        	if(a >= 'A' && a <= 'Z'){
        		if(a + n > 'Z'){
        			answer += (char)(a + n-26);
        		}else{
        			answer += (char)(a + n);
        		}
        	}else if(a >= 'a' && a <= 'z'){
        		if(a + n > 'z'){
        			answer += (char)(a + n-26);
        		}else{
        			answer += (char)(a + n);
        		}
        	}else{
        		answer += (char)a;
        	}
        }
        
        return answer;
    }
}
