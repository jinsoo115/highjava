package solutionLevel1;

public class TelHiden { // 핸드폰 번호 가리기
	public static void main(String[] args) {
		String phone_number = "01033334444";
//		String phone_number = "027778888";
		
		System.out.println(new TelHiden().solution(phone_number));
	}
	public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i < phone_number.length(); i++){
        	if(i < phone_number.length()-4){
        		answer += "*";
        	}else{
        		answer += Character.toString(phone_number.charAt(i));
        	}
        }
        return answer;
    }
}
