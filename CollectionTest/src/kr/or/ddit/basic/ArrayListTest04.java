package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest04 {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			System.out.print(i+1 + "번째 입력 > ");
			list.add(sc.nextLine());
		}
		
		String temp ="";
		for(int i = 0; i < list.size(); i++){
			if(temp.length() <list.get(i).length()){
				temp = list.get(i);
			}
		}
//		for(String str : list){
//			if(temp.length() <str.length()){
//					temp = str;
//			}
//		}
		System.out.println("별명이 가장 긴사람은");
		for(int i = 0; i < list.size(); i++){
			if(temp.length()==list.get(i).length()){
				System.out.println(list.get(i));
			}
		}
		
//		for(String str : list){
//			if(temp.length() == str.length()){
//				System.out.println(str);
//			}
//		}
		sc.close();
	}
}
