package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import util.RegEx;
import util.ScanUtil;

public class Hotel {
	HashMap<Integer, Room> room;
	Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		new Hotel().start();
	}

	private void start() {
		System.out.println("*********************************************");
		System.out.println("호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		room = new HashMap<>();
		roomAdd();
		while(true){
			int choice = menu();
			switch (choice) {
			case 1:	// 체크인
				checkIn();
				break;
			case 2:	// 체크아웃
				checkOut();
				break;
			case 3:	//객실상태
				view();
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;
			default:
				break;
			}
		}
	}

	private void checkOut() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("-----------------------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방번호 입력 >> ");
		int number = inputNumber();
		if(!room.containsKey(number)){
			System.out.println(number + "호 객실은 존재하지 않습니다.");
			return;
		}else if(room.get(number).getName().equals("-")){
			System.out.println(number + "호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}else{
			System.out.println(number + "호 객실의 " + room.get(number).getName() + "님 체크아웃을 완료하였습니다.");
			room.get(number).setName("-");
		}
		
	}

	private void checkIn() {
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸"); 
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int number = inputNumber();

		if(!room.containsKey(number)){
			System.out.println(number+"호 객실은 존재하지 않습니다.");
			return;
		}else if(!room.get(number).getName().equals("-")){
			System.out.println(number+"호 객실은 이미 손님이 있습니다.");
			return;
		}
		
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = sc.nextLine();
		
		room.get(number).setName(name);
		System.out.println("체크인이 완료되었습니다.");
	}
	private void view() {
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		List<Integer> list = new ArrayList<>(room.keySet());
		Collections.sort(list);
		for(int key : list){
			System.out.println(room.get(key).getNumber() + "\t" + room.get(key).getType() + "\t\t" + room.get(key).getName());
		}
		System.out.println("----------------------------------------------");
		
	}

	private void roomAdd() {
		room.put(201, new Room(201, "싱글룸", "-"));
		room.put(202, new Room(202, "싱글룸", "-"));
		room.put(203, new Room(203, "싱글룸", "-"));
		room.put(204, new Room(204, "싱글룸", "-"));
		room.put(205, new Room(205, "싱글룸", "-"));
		room.put(206, new Room(206, "싱글룸", "-"));
		room.put(207, new Room(207, "싱글룸", "-"));
		room.put(208, new Room(208, "싱글룸", "-"));
		room.put(209, new Room(209, "싱글룸", "-"));
		
		
		room.put(301, new Room(301, "더블룸", "-"));
		room.put(301, new Room(302, "더블룸", "-"));
		room.put(303, new Room(303, "더블룸", "-"));
		room.put(304, new Room(304, "더블룸", "-"));
		room.put(305, new Room(305, "더블룸", "-"));
		room.put(306, new Room(306, "더블룸", "-"));
		room.put(307, new Room(307, "더블룸", "-"));
		room.put(308, new Room(308, "더블룸", "-"));
		room.put(309, new Room(309, "더블룸", "-"));
		
		
		room.put(401, new Room(401, "스위트룸", "-"));
		room.put(401, new Room(402, "스위트룸", "-"));
		room.put(403, new Room(403, "스위트룸", "-"));
		room.put(404, new Room(404, "스위트룸", "-"));
		room.put(405, new Room(405, "스위트룸", "-"));
		room.put(406, new Room(406, "스위트룸", "-"));
		room.put(407, new Room(407, "스위트룸", "-"));
		room.put(408, new Room(408, "스위트룸", "-"));
		room.put(409, new Room(409, "스위트룸", "-"));
		
	}

	private int menu() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		int input = inputNumber();
		return input;
	}
	
	//숫자입력 정규식
		private int inputNumber(){
			String input = null;
			while(true){
				input = sc.nextLine();
				boolean result = RegEx.regNumber(input);
				if(result == false){
					System.out.println("숫자만 입력하세요.");
					continue;
				} else {
					break;
				}
			}
			return Integer.parseInt(input);
		}
}


class Room{
	private int number;
	private String type;
	private String name;
	public Room(int number, String type, String name) {
		super();
		this.number = number;
		this.type = type;
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}