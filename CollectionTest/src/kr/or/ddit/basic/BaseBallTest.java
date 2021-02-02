package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import util.ScanUtil;

/*
 *  문제) Set과 List를 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 *  	 컴퓨터의 숫자는 난수를 이용하여 구한다.
 *  	(스트라이크는 S, 볼을 B로 나타낸다.)
 *  예시)
 *   컴퓨터의 난수 ==> 9 5 7
 *   
 *   실행예시)
 *   숫자입력 => 3 5 6
 *   3 5 6 ==> 1S 0B
 *   숫자입력 => 7 8 9
 *   7 8 9 ==> 0S 2B
 *   숫자입력 => 9 7 5
 *   9 7 5 ==> 1S 2B
 *   숫자입력 => 9 5 7
 *   9 5 7 ==> 3S 0B
 *   
 *   축하합니다.
 *   당신은 4번째만에 맞췄습니다.
 *   
 */
public class BaseBallTest {
	//샘이하신거
	ArrayList<Integer> numList; //난수가 저장될 List
	ArrayList<Integer> userList; //사용자가 입력한 값이 저장될 List

	int strike, ball;

	Scanner sc = new Scanner(System.in);
	// 1~9 사이의 서로 다른 난수 3개를 만들어서 List 에 저장하는 메서드
	//(Set이용)
	public void makeNum(){
		Set<Integer> numSet = new HashSet<>();

		//1~9사이의 난수 3개 만들기
		while(numSet.size() < 3){
			numSet.add((int)(Math.random() * 9 ) + 1);
		}
		//만들어진 나수를 List에 저장하기
		numList = new ArrayList<>(numSet);
		// List의 데이터를 섞어준다.
		Collections.shuffle(numList);
		
		
	}
	
	// 사용자로 부터 3개의 정수를 입력 받아 List에 저장하는 메서드
	// 입력한 값은 서로 중복되지 않는다.
	public void inputNum(){
		int n1, n2, n3; // 입력한 정수값이 저장될 변수
		do{
			System.out.print("숫자 입력 : ");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			if(n1==n2 || n1==n3 || n2==n3){
				System.out.println("중복되는 숫자는 입력할 수 없습니다.");
				System.out.println("다시 입력하세요.");
			}
		}while(n1==n2 || n1==n3 || n2==n3);
		
		// 입력한 데이터를 List에 저장한다.
		userList = new ArrayList<>();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);
	}
	
	// 스트라이크와 볼을 판정하고 결과를 출력하는 메서드
	public void ballCount() {
		strike = 0;
		ball = 0; //스트라이크와 볼의 개수 초기화
		
		for(int i = 0; i < numList.size(); i++){
			for(int j = 0; j < userList.size(); j++){
				if(numList.get(i) == userList.get(j)){
					if(i==j){
						strike++;
					}else{
						ball++;
					}
				}
			}// for = j
		}// for = i 
		
		// 볼카운트 결과를 출력한다.
		System.out.println(userList.get(0) + " , " + userList.get(1) + " , " + userList.get(2) + " ==> " + strike + "S " + ball + "B");
	}
	
	// 게임을 진행하는 메서드
	public void gameStart(){
		System.out.println("게임을 시작합니다...");
		//난수를 만들어주는 메서드 호출
		makeNum();
//		System.out.println("확인용 : " + numList);
		
		int cnt = 0; // 몇 번만에 맞췄는지를 저장하는 변수
		
		do{
			cnt++;
			// 사용자 입력 메서드 호출
			inputNum();
			
			// 볼카운트 구하는 메서드 호출
			ballCount();
			
		}while(strike!=3); // 3 스트라이크가 될때까지 반복한다.
		
		System.out.println();
		System.out.println("축하합니다....");
		System.out.println("당신은 " + cnt + "번째만에 맞췄습니다.");
		
	}
	public static void main(String[] args) {
		BaseBallTest baseBall = new BaseBallTest();
		baseBall.gameStart();
		
		//내가 한거
		/*Set<Integer> set = new HashSet<>();
		while(set.size()<3){
			set.add((int)(Math.random()*9-1+1)+1);
		}
		List<Integer> list = new ArrayList<>(set);
		Collections.shuffle(list);
		System.out.println(list);
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(true){
			List<Integer> answer = new ArrayList<>();
			int s = 0;
			int b = 0;
			for(int i = 0; i < list.size(); i++){
				System.out.print("숫자 입력 : ");
				answer.add(sc.nextInt());

			}
			for(int i = 0; i < list.size(); i++){
				for(int j = 0 ; j < answer.size(); j++){
					if(list.get(i)==answer.get(j)){
						if(i!=j){
							b++;
							break;
						}else{
							s++;
							break;
						}
					}
				}
			}

			System.out.println(s + "S" + b + "B");
			count++;
			if(s==3){
				System.out.println("당신은 " + count + "번째만에 맞췄군요....");
				break;
			}
		}*/

	}
}
