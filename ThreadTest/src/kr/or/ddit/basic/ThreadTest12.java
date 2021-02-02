package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 문제) 10마리의 말들이 경주하는 경마 프로그램을 작성하시오.
 * 
 * 말은 Horse라는 이름의 쓰레드 클래스로 작성하는데,
 * 이 클래스는 말이름(String), 등수(int), 현재위치값(int)을
 * 멤버변수로 갖는다. 그리고, 이 클래스에는 등수를 오름차순으로
 * 처리할 수 있는 내부 정렬 기준이 있다.(Comparable 인터페이스 구현)
 * 
 * 경기 구간은 1~50구간으로 되어 있다.
 * 
 * 경기가 진행되는 중간  중간에 각각의 말들의 위치를 아래와 같이 나타내시오.
 * 예시)
 * 01번말 : --->-------------------------------------------
 * 02번말 : ------->---------------------------------------
 * 03번말 : ------------>----------------------------------
 * ...
 * 10번말 : -------->--------------------------------------
 * 
 * 경기가 끝나면 등수 순으로 출력한다.
 */
public class ThreadTest12 {
	
	public static void main(String[] args) {
		Horse[] horse = new Horse[]{new Horse("1번말"),
				new Horse("2번말"),
				new Horse("3번말"),
				new Horse("4번말"),
				new Horse("5번말"),
				new Horse("6번말"),
				new Horse("7번말"),
				new Horse("8번말"),
				new Horse("9번말"),
				new Horse("10번말")
		};
		
		DisplayHorse dis = new DisplayHorse(horse);
		
		for(Horse h : horse){
			h.start();
		}
		dis.start();
		
		for(int i = 0; i < horse.length; i++){
			try {
				horse[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
		System.out.println("	== 경기 결과 ==");
		Arrays.sort(horse);
		for(Horse h : horse){
			System.out.println(h.gethorseName() + "의 순위는 " + h.getRank());
		}
		
	}
	
	
}

class Horse extends Thread implements Comparable<Horse>{
	private String horseName;
	private int rank;
	private int loc;
	public static int currentRank=1;
	
	

	public Horse(String horseName) {
		this.horseName = horseName;
	}
	
	
	public String gethorseName() {
		return horseName;
	}


	public void sethorseName(String horseName) {
		this.horseName = horseName;
	}


	public int getRank() {
		return rank;
	}



	public void setRank(int rank) {
		this.rank = rank;
	}



	public int getLoc() {
		return loc;
	}



	public void setLoc(int loc) {
		this.loc = loc;
	}



	@Override
	public void run() {
		for(int i = 1; i <= 50; i++){
			this.loc = i;
			try {
				Thread.sleep((int)(Math.random() * 500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		rank = currentRank++;
		
	}
	@Override
	public int compareTo(Horse o) {
		return new Integer(this.rank).compareTo(o.getRank());
	}
}

class DisplayHorse extends Thread{
	private Horse[] horse;
	
	public DisplayHorse(Horse[] horse) {
		this.horse = horse;
	}
	
	@Override
	public void run() {
		while(true){
			if(Horse.currentRank == 10){
				break;
			}
			for(int i = 0; i < 10; i++){
				System.out.println();
			}
			for(int i = 0; i < 10; i++){
				StringBuffer str = new StringBuffer("-------------------------------------------------");
				
				System.out.println(horse[i].gethorseName()+ ": " + str.insert(horse[i].getLoc()-1, ">"));
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}