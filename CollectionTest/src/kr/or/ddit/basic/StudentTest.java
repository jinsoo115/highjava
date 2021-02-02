package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/*
 * 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를
 * 	         멤버로 갖는 Student클래스를 작성한다.
 * 		이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만
 * 		매개변수로 받아서 초기화 처리한다.
 * 
 * 		이 Student객체는 List에 저장하여 관리한다.
 * 
 * 		List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬기준을 구현하고,
 * 
 * 		총점의 역순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는
 * 	  	외부 정렬기준 클래스를 작성하여 정렬된 결과를 출력하시오.
 * 
 *  	(등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
 */
public class StudentTest {
	
	//등수를 구하는 메서드
	public void setRanking(List<Student> list){
//		 for(int i = 0; i < list.size(); i++){ // 기준 데이터를 구하기 위한 반복문
//			 int rank = 1;// 처음에는 1등으로 설정해 놓고 시작한다.
//			 for (int j = 0; j < list.size(); j++){// 비교 대상을 나타내는 반복문
//				 //기준보다 큰 값을 만나면 rank값을 증가시킨다.
//				 if(list.get(i).getTotal() < list.get(j).getTotal()){
//					 rank++;
//				 }
//			 }// for - j
//			 // 구해진 등수를 Student 객체의 rank변수에 저장한다.
//			 list.get(i).setRank(rank);
//		 } // for - i 
		 
		for(Student std1 : list){
			int rank = 1;
			for(Student std2 : list){
				if(std1.getTotal() < std2.getTotal()){
					rank++;
				}
				std1.setRank(rank);
			}
		}
		 
		
	}
	
	public static void main(String[] args) {
		StudentTest t = new StudentTest();
		List<Student> list = new ArrayList<>();
		
		list.add(new Student(1, "이씨", 90, 80, 60));
		list.add(new Student(4, "김씨", 70, 70, 40));
		list.add(new Student(12, "박씨", 40, 50, 87));
		list.add(new Student(45, "정씨", 90, 40, 67));
		list.add(new Student(2, "홍씨", 85, 60, 60));
		list.add(new Student(56, "류씨", 94, 80, 96));
		list.add(new Student(3, "양씨", 57, 75, 73));
		
		// 등수를 구하는 메서드
		t.setRanking(list);
		
		
		System.out.println("정렬 전");
		for(Student st : list){
			System.out.println(st);
		}
		System.out.println("학번 정렬 후");
		Collections.sort(list);
		for(Student st : list){
			System.out.println(st);
		}
		System.out.println("총점 정렬 후");
		Collections.sort(list, new totalDesc());
		int i = 0;
		for(Student st : list){
//			i++;
//			st.setRank(i);
			System.out.println(st);
		}
	}
} 

class totalDesc implements Comparator<Student>{

	public int compare(Student st1, Student st2) {
		if(st1.getTotal() > st2.getTotal()){
			return -1;
		}else if(st1.getTotal() < st2.getTotal()){
			return 1;
		}else{
			if(st1.getName().compareTo(st2.getName()) > 0){
				return 1;
			}else if(st1.getName().compareTo(st2.getName()) < 0){
				return -1;
			}else{
				return 0;
			}
		}
	}
	
}

class Student implements Comparable<Student>{
	private int number;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int total;
	private int rank;
	
	public Student(int number, String name, int kor, int eng, int math) {
		super();
		this.number = number;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = kor + eng + math;
		this.rank=0;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	

	@Override
	public String toString() {
		return "Student [number=" + number + ", name=" + name + ", kor=" + kor
				+ ", eng=" + eng + ", math=" + math + ", total=" + total
				+ ", rank=" + rank + "]";
	}

	@Override
	public int compareTo(Student student) {
		// 회원 학번의 오름차순 정렬 기준 만들기
		return Integer.compare(this.number, student.getNumber());
	}
}
