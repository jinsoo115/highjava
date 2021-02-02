package solutionLevel1;

public class StringPAndY {
	public static void main(String[] args) {
		String s = "pPoooyY";
//		String s = "Pyy";
		boolean answer = new StringPAndY().solution(s);
		System.out.println(answer);
	}

	public boolean solution(String s) {
		boolean answer = true;
		int a = 0;
		int b = 0;
		for(int i = 0; i < s.length(); i++){
			if(Character.toString(s.charAt(i)).equals("p")||Character.toString(s.charAt(i)).equals("P")){
				a++;
			}else if(Character.toString(s.charAt(i)).equals("y")||Character.toString(s.charAt(i)).equals("Y")){
				b++;
			}
		}
		if(a!=b){
			answer = false;
		}

		return answer;
	}

}
