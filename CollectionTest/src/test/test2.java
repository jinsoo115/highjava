package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class test2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*문제1.
		arr배열의 모든값을 더하는 프로그램을 작성하세요*/
		int[] arr ={10,20,30,40,50};
		int sum=0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		System.out.println(sum);
		/*문제2 
		5명의 이름을 입력받아 배열에 저장하는 프로그램을 작성하세요.*/
		String[] name = new String[5];
		for(int i = 0; i < name.length; i++){
			System.out.print("이름 입력 : ");
			name[i] = sc.nextLine();
		}
		System.out.println(Arrays.toString(name));

		/*문제3
		score배열의 최대값, 최소값구하기 */
		int[] score = { 79, 88, 91, 33, 100, 55, 95};
		int max = 0;
		int min = 100;
		for(int i = 0; i < score.length; i++){
			if(max < score[i]){
				max = score[i];
			}else if(min > score[i]){
				min = score[i];
			}
		}
		System.out.println("쵀대값은 " + max + " 최소값은 " + min);
		/*문제4
		2차원 배열 arr2에 담긴 모든값의 총합과 평균을 구하는 프로그램을 작성하세요*/
		int[][] arr2 = {
				{5,5,5,5,5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}};
		double avg = 0.0;
		int count = 0;
		sum = 0;
		for(int i =0; i<arr2.length; i++){
			for(int j = 0; j < arr2[i].length; j ++){
				sum += arr2[i][j];
				count++;
			}
		}
		System.out.println("총합은 " + sum + " 평균은 " +  (double)sum/count);

		/*문제5
		answer 배열의 각 숫자의 갯수를 세어 count배열에 넣고 
		count배열의 각숫자만큼씩 *를 출력한다*/ 
		int[] answer= {3,2,1,0,0,1,2,0,1,0,0,0,1,3,0};
		int[] counter = new int[4];
		count=0;
		Set<Integer> set = new HashSet<>();
		for(int i : answer){
			set.add(i);
		}
		ArrayList<Integer> testList = new ArrayList<>(set);
		for(int i = 0; i < testList.size(); i++){
			for(int j = 0; j < answer.length; j++){
				if(testList.get(i) == answer[j]){
					count++;
				}
			}
			counter[i] = count;
			count = 0;
		}
		for(int i = 0; i < counter.length; i++){
			for(int j = 0; j < counter[i]; j++){
				System.out.print("*");
			}
			System.out.println();
		}


		/*문제6
		menu배열에서 메뉴이름과 가격중 메뉴이름을 추출하는 프로그램을 작성하세요.*/
		String menu[] ={ "아메리카노 3000원", "카푸치노 4000원", "카페라떼 3500원"};
		for(int i =0; i <menu.length; i++){
			String[] split = menu[i].split(" ");
			System.out.println("메뉴명: " + split[0]);
		}

		/*문제7.
		str변수에서 Java의 위치를 찾아 출력하는 프로그램을 작성하세요,*/
		String str = "i Love Java";
		int temp = str.indexOf("Java");
		System.out.println(str.substring(temp));

		/*문제8
		s변수에서 lang문자열을 추출하는 프로그램을 작성하세요*/ 
		String  s="java.lang.Object";
		s = s.substring(s.indexOf("lang"), s.lastIndexOf("."));
		System.out.println(s);
		/*문제9
		animals변수에서 ,를 기준으로  문자열을  분리해서  3개의 단어로 각각 출력하는
		프로그램을 작성하세요*/
		String animals = "dog,cat,bear";
		String[] split = animals.split(",");
		for(int i = 0; i < split.length; i++){
			System.out.println(split[i]);
		}
		/*문제 10
		str문자열에서 ,를 .으로 바꾸어 출력하는 프로그램을 작성하세요.*/
		str="java,lang,Object";
		split = str.split(",");
		String fi = "";
		for(int i = 0; i < split.length; i++){
			fi  += split[i];
			if(i != split.length-1){
				fi += ".";
			}
		}
		System.out.println(fi);

	}

}
