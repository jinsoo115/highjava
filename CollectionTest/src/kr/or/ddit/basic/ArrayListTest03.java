package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제1) 5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력하시오.
 * 		 (단, 각 별명의 길이는 모두 다르게 입력한다.)
 * 문제2) 문제1에서 별명의 길이가 같은 것을 입력할 수 있는 경우를 처리하시오.
 */
public class ArrayListTest03 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			System.out.print(i+1 + "번째 입력 > ");
			list.add(sc.nextLine());
		}
		String temp ="";
		for(int i = 0; i < list.size(); i++){
			if(temp.length() < list.get(i).length()){
				temp = list.get(i);
			}
		}
		
//		for(String str : list){
//			if(temp.length() < str.length()){
//				temp = str;
//			}
//		}
		System.out.println("별명이 가장 긴사람은");
		System.out.println(temp);
		sc.close();
	}
}
