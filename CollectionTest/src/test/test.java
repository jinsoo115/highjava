package test;

import java.util.Scanner;
import java.util.regex.Pattern;

public class test {
	/*
	 * 
	 */
	public static void main(String[] args) {
		//문제1
		//변수 num의 값에 따라 양수, 음수, 0을 출력하는 코드를 작성하세요,
		//삼항연산자를  이용 
		int num = 10;
		String st = num > 0 ? "양수" : (num < 0 ? "음수" : "0");
		System.out.println(st);
		
		//문제2
//		문자형 변수 ch가 영문(대문자 또는 소문자)자이거나 숫자일때만 
//		변수 b의 값이  true가 되도록 하는 코드를 작성하세요
//		삼항연산자이용 
		char ch='z';
		String check = Character.toString(ch);
		boolean b = rexEx(check);
		System.out.println(b);
		
		//문제3
//		문자형변수 ch의 값을 소문자로 변경하는 코드를 작성하세요
//		char ch='A'
		ch ='A';
		ch = (char) (ch+32);
		System.out.println(ch);
		
		//문제4
//		Math.random() 을 이용하여 1~6 사이의 임의의 정수를 변수 value 에 
//		저장하는 코드를 작성하세요 
		
		int value = (int) ((Math.random()* 6)+1) ;
		System.out.println(value);
		
		
		//문제5
//		1~100 까지의 합을 구하는 코드를 작성하세요
		value =0;
		for(int i = 1; i <= 100; i++){
			value += i;
		}
		System.out.println(value);
		
		//문제6
//		1~100사이의 랜덤수를 발생시켜 저장한다
//		 임의의 값을 입력받아 랜덤값을  맞추는 코드 작성하세요
//		 맞출때가지 계속 입력받고 맞추면 종료한다.
		value = (int) ((Math.random()* 100)+1) ;
		System.out.println("정답 : " + value);
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("입력 : ");
			int temp = sc.nextInt();
			if(value == temp){
				System.out.println("정답입니다.");
				break;
			}else{
				System.out.println("틀렸습니다.");
			}
		}
		
	}
	//문제2
	public static boolean rexEx(String check){
		String str = "[A-Za-z0-9]";
		boolean result = Pattern.matches(str, check);
		return result;
	}
}
