package solutionLevel1;

public class Harsa {// 하샤드 수
	public static void main(String[] args) {
//		int arr = 10;
//		int arr = 12;
//		int arr = 11;
		int arr = 13;
		
		System.out.println(new Harsa().solution(arr));
	}
	public boolean solution(int x) {
        boolean answer = true;
        String s = Integer.toString(x);
        int a =0;
        for(int i = 0; i < s.length(); i++){
        	a += Character.getNumericValue(s.charAt(i));
        }
        if(x % a !=0){
        	answer = false;
        }
        return answer;
    }
}
