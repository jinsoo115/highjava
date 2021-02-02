package kr.or.ddit.basic;

import java.util.Arrays;

public class HorseSam {
	public static void main(String[] args) {
		HoresSams[] horseSams = new HoresSams[]{
				new HoresSams("1번말"),
				new HoresSams("2번말"),
				new HoresSams("3번말"),
				new HoresSams("4번말"),
				new HoresSams("5번말"),
				new HoresSams("6번말"),
				new HoresSams("7번말"),
				new HoresSams("8번말"),
				new HoresSams("9번말"),
				new HoresSams("10번말")
		};
		
		System.out.println("경기 시작...");
		for(HoresSams h : horseSams){
			h.start();
		}
		Show sh = new Show(horseSams);
		
		sh.start();
		
		for(HoresSams h : horseSams){
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			sh.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println("경기 끝....");
		System.out.println();
		
		// 경기가 끝난 후 등수순으로 정렬한다.
		Arrays.sort(horseSams);
		
		System.out.println("경기 결과");
		for(HoresSams h : horseSams){
			System.out.println(h);
		}
		
	}
}

class HoresSams extends Thread implements Comparable<HoresSams>{
	public static int currentRank=0;
	
	private String horseName;
	private int rank;
	private int loc;
	
	// 등수의 오름차순 정렬
	@Override
	public int compareTo(HoresSams h) {
		// TODO Auto-generated method stub
		return Integer.compare(rank, h.getRank());
	}

	public HoresSams(String horseName) {
		super();
		this.horseName = horseName;
	}

	public String getHorseName() {
		return horseName;
	}

	public void setHorseName(String horseName) {
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
	public String toString() {
		return "경주마 "+horseName + "은(는)" + rank + "등입니다";
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
		}// for문
		
		// 한 마리의 말이 경주가 끝나면 currentRank값을 증가시킨다.
		// 이 값이 현재 경주가 끝난 말의 등수가 된다.
		currentRank++;
		this.rank = currentRank;
	}
}

// 경기 중 말의 현재 위치를 나타내는 쓰레드

class Show extends Thread{
	// 경기를 진행 중인 말들이 저장될 배열이 저장될 변수 선언
	private HoresSams[] horseSams;

	public Show(HoresSams[] horseSams) {
		super();
		this.horseSams = horseSams;
	} 
	
	@Override
	public void run() {
		while(true){
			if(HoresSams.currentRank==horseSams.length){
				break;
			}
			for(int i = 1; i <= 10; i++)
				System.out.println();
			for(int i = 0; i < horseSams.length; i++){
				System.out.print(horseSams[i].getHorseName() + "");
				
				for(int j = 1; j <= 50; j++){
					if(horseSams[i].getLoc()==j){
						System.out.print(">");
					}else{
						System.out.print("-");
					}
				}
				System.out.println();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}