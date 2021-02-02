package solutionLevel1;

public class Day {
	public static void main(String[] args) {
		int a = 5;
		int b =24;
		String answer = new Day().solution(a, b);
		System.out.println(answer);
	}
	public String solution(int a, int b) {// 2016년 요일 맞추기
        String answer = "";
        int temp=0;

        for(int i = 1; i<a;i++){
        	if(i==2){
            	temp+=29;
            }else if(i==4||i==6||i==9||i==11){
            	temp+=30;
            }else{
            	temp+=31;
            }	
        }
        temp+=b;


        switch (temp%7) {
        case 0:
        	answer="THU";
			break;
		case 1:
			answer="FRI";
			break;
		case 2:
			answer="SAT";
			break;
		case 3:
			answer="SUN";
			break;
		case 4:
			answer="MON";
			break;
		case 5:
			answer="TUE";
			break;
		case 6:
			answer="WED";
			break;

		}

        return answer;
    }
}
