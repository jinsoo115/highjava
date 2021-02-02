package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import util.ScanUtil;



/* 로또를 구매하는 프로그램 작성하기
 
 사용자는 로또를 구매할 때 구매할 금액을 입력하고
 입력한 금액에 맞게 로또번호를 출력한다.
 (단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
      거스름돈도 계산하여 출력한다.)*/


public class Lotto {
	
	Scanner sc = new Scanner(System.in);
	private void lottoStart(){
		while(true) {
			int choice = displayMenu();
			switch (choice) {
			case 1: // 구입
				lottoBuy();
				break;
			case 2: // 종료
				System.out.println("감사합니다.");
				System.exit(0);
				break;
			default :
			}
		}
	}
	// 로또 구입을 처리하는 메서드
	private void lottoBuy() {
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int money = sc.nextInt();
		
		if(money < 1000){
			System.out.println("입력 금액이 너무 작습니다. 로또번호 구입 실패!!!");
		}else if(money/1000 > 100){
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
		}else{
			// 로또 번호를 생성하고 출력하는 메서드 호출
			lottoNum(money);
		}
	}
	private void lottoNum(int money) {
		System.out.println();
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		for(int i = 0; i < money/1000; i++){
			HashSet<Integer> lottoSet = new HashSet<>();
			while (lottoSet.size() < 6) {
				lottoSet.add((int)(Math.random() * 45 +1));
			}
			List<Integer> lottoList = new ArrayList<>(lottoSet);
			Collections.sort(lottoList);
			System.out.print("로또번호  "+ (i+1) + " : ") ;
			for(int j = 0; j < lottoList.size(); j++){
				if(j > 0 ){
					System.out.print(", ");
				}
				System.out.print(lottoList.get(j));
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + (money%1000) + "원 입니다."); 
		
	}
	// 메뉴를 출력하고 선택한 메뉴 번호를 반환하는 메서드
	private int displayMenu(){
		System.out.println("====================");
		System.out.println("Lotto 프로그램");
		System.out.println("--------------------");
		System.out.println("1. Lotto 구입");
		System.out.println("2. 프로그램 종료");
		System.out.println("====================");
		System.out.print("메뉴선택 : "); 
		int num = sc.nextInt();
		return num;
	}
	public static void main(String[] args) {
		// 샘이 한거
		new Lotto().lottoStart();
		
		// 내가 한거
		/*Lotto lotto = new Lotto();
		while(true){
			System.out.println("====================");
			System.out.println("Lotto 프로그램");
			System.out.println("--------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("====================");
			System.out.print("메뉴선택 : ");
			int input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				lotto.buy();
				break;
			case 2:
				System.out.println("감사합니다.");
				System.exit(0);
				break;
			}
		}*/
		
		
	}

	private void buy() {
		System.out.println("Lotto 구입 시작");
		System.out.println("(1000원에 로또번호 하나입니다.)");
		System.out.print("금액 입력 : ");
		int money = ScanUtil.nextInt();
		if(money < 1000 ){
			System.out.println("입력 금액이 너무 적습니다. 로또번호 구입 실패!!!");
			return;
		}
		if(100 < money/1000){
			System.out.println("입력 금액이 너무 많습니다. 로또번호 구입 실패!!!");
			return;
		}
		int count = money / 1000;
		int change = money % 1000;
		int cnt=0;
		while(true){
			Set<Integer> set = new HashSet<>();
			while(set.size() < 6){
				set.add((int)(Math.random()*45-1+1)+1);
			}
			List<Integer> list = new ArrayList<>(set);
			Collections.sort(list);
			cnt++;
			System.out.print("로또번호" + cnt + " : ");
			for(int i=0; i< list.size(); i++){
				if(i==0){
					System.out.print(list.get(i));
				}else{
					System.out.print(", "+list.get(i));
				}
			}
			System.out.println();
			if(cnt==count){
				System.out.println("받은 금액은 " + money + "원이고 거스름돈은 " + change + "원입니다.");
				break;
			}
		}
	}
}
