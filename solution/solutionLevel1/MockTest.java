package solutionLevel1;

public class MockTest {
	public static void main(String[] args) {
//		int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		int[] r = new MockTest().solution(answers); 
		for(int i : r){
			System.out.println(i);
		}
	}
	public int[] solution(int[] answers) {//모의고사 수포자
        int[] answer = {};
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2,1,2,3,2,4,2,5};
        int[] student3 = {3,3,1,1,2,2,4,4,5,5};
        int[] temp = {0,0,0};
        for(int i=0; i< answers.length; i++){//채점
        	if(answers[i] == student1[i%student1.length]){
        		temp[0]++;
        	}
        	if(answers[i] == student2[i%student2.length]){
        		temp[1]++;
        	}
        	if(answers[i] == student3[i%student3.length]){
        		temp[2]++;
        	}
        }
        //가장 많이 맞춘사람
        if(temp[0] == temp[1] && temp[1] == temp[2]) {
        	answer = new int[3];
        	answer[0] = 1;
        	answer[1] = 2;
        	answer[2] = 3;
        }else if (temp[0] > temp[1] && temp[0] > temp[2]) {
        	answer = new int[1];
        	answer[0] = 1;
        }else if (temp[1] > temp[0] && temp[1] > temp[2]) {
        	answer = new int[1];
        	answer[0] = 2;
        }else if (temp[2] > temp[1] && temp[2] > temp[0]) {
        	answer = new int[1];
        	answer[0] = 3;
        }else if (temp[0] == temp[1] && temp[0] != temp[2]) {
        	answer = new int[2];
        	answer[0] = 1;
        	answer[1] = 2;
        }else if(temp[0] == temp[2] && temp[0] != temp[1]){
        	answer = new int[2];
        	answer[0] = 1;
        	answer[1] = 3;
        }else if(temp[1] == temp[2] && temp[0] != temp[2]){
        	answer = new int[2];
        	answer[0] = 2;
        	answer[1] = 3;
        }else if(temp[1] == temp[2] && temp[0] != temp[1]){
        	answer = new int[2];
        	answer[0] = 2;
        	answer[1] = 3;
        }

        	return answer;
	}
}
