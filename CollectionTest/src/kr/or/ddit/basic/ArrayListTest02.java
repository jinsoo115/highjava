package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제) 5명의 사람이름을 입력 받아서 ArrayList에 저장한 후에 이들 중 '김'씨 성을 가진 사람을 모두 출력하시오.
 * 		(입력은 Scanner객체를 이용한다.)
 */
public class ArrayListTest02 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			System.out.print(i+1 + "번째 입력 > ");
			list.add(sc.nextLine());
		}
		System.out.println();
		System.out.println("김씨 성을 가진 사람은 ");
		for(int i = 0; i < list.size(); i++){
//			if(list.get(i).charAt(0)=='김'){
//				System.out.println(list.get(i));
//			}
			
//			if(list.get(i).substring(0,1).equals("김")){
//				System.out.println(list.get(i));
//			}
			
//			if(list.get(i).indexOf("김")==0){
//				System.out.println(list.get(i));
//			}
			
			if(list.get(i).startsWith("김")){
				System.out.println(list.get(i));
			}
		}
		sc.close();
	}
	
}
