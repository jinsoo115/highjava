package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

import util.RegEx;
/*
 * 문제) 이름, 주소, 전화번호를 멤버로 갖는 Phone클래스를 작성하고,
 * 		Map을 이용하여 전화번호 정보를 관리하는 프로그램을 작성하시오.
 * 		
 * 		- 삭제, 검색기능은 '이름'을 입력받아서 처리한다.
 * 
 * 		(Map의 구조는 key값으로 '이름'을 사용하고,
 * 		value값으로는 'Phone클래스의 인스턴스'로 한다.)
 * 		
 * 		- 추가 조건)
 * 		1) '6. 전화번호 저장' 메뉴를 추가하고 구현한다.
 * 			(저장파일명은 'phoneData.dat'로한다.)
 * 		2) 프로그램이 시작할 때 저장된 파일이 있으면 그 데이터를 읽어와 Map에 셋팅하여 사용한다.
 * 		3) 프로그램을 종료할 때 Map의 데이터가 변경되거나
 * 		       추가 또는 삭제 되면 저장한 후 종료되도록 한다.
 * 
 * 		아래 메뉴의 내용을  프로그램하시오.
 * 			
 * 실행예시)
 * -------------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 6. 전화번호 정보 저장
 * 0. 프로그램 종료
 * -------------------------
 * 번호입력 >> 1
 * 
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름 >> 홍길동
 * 전화번호 >> 010-1111-1111
 * 주소 >> 대전시 중구 대흥동
 * 
 * '홍길동' 전화번호 등록 완료!!
 * 
 * -------------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * -------------------------
 * 번호입력 >> 1
 * 새롭게 등록할 전화번호 정보를 입력하세요.
 * 이름>> 홍길동
 * '홍길동'은 이미 등록된 사람입니다.
 * 
 * -------------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * -------------------------
 * 번호입력 >> 5
 * 
 * -------------------------------------
 * 번호	이름		전화번호			주소
 * 1	홍길동	010-1111-1111	대전시 중구 대흥동
 * ...
 * ...
 * -------------------------------------
 * 출력완료...
 * 
 * -------------------------
 * 다음 메뉴를 선택하세요.
 * 
 * 1. 전화번호 등록
 * 2. 전화번호 수정
 * 3. 전화번호 삭제
 * 4. 전화번호 검색
 * 5. 전화번호 전체 출력
 * 0. 프로그램 종료
 * -------------------------
 * 번호입력 >> 1
 */
public class PhoneBookTest {
	HashMap<String, Phone> phoneBookMap;
	Scanner sc = new Scanner(System.in);
	String fileName = "d:/d_other/phoneData.dat";
	
	public static void main(String[] args) {
		new PhoneBookTest().PhoneBookstart();	
	}
	private void PhoneBookstart() {
		// 샘이 한거
		
		// 내가 한거
		/*// 읽기 작업
		phoneBookMap = new HashMap<>();
		File file = new File(fileName);
		if(file.exists()){
			Object obj; // 읽어온 객체를 저장할 변수
			try {
				FileInputStream fin = new FileInputStream(fileName);
				BufferedInputStream bis = new BufferedInputStream(fin);
				ObjectInputStream ois = new ObjectInputStream(bis);

				try {
					System.out.println("객체 읽기 작업 시작...");
					while ((obj=ois.readObject())!=null){
						phoneBookMap = (HashMap<String, Phone>)obj;
					}
				} catch (EOFException e) {
					System.out.println("객체 읽기 작업 끝....");
				}  catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		while(true){
			System.out.println("-------------------------");
			System.out.println("다음 메뉴를 선택하세요.");
			System.out.println("1. 전화번호 등록");
			System.out.println("2. 전화번호 수정");
			System.out.println("3. 전화번호 삭제");
			System.out.println("4. 전화번호 검색");
			System.out.println("5. 전화번호 전체 출력");
			System.out.println("6. 전화번호 저장");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------------------");
			int input = inputNumber();

			switch (input) {
			case 1:
				insert();
				break;
			case 2:
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				select();
				break;
			case 5:
				view();
				break;
			case 6:
				save();
				break;
			case 0:
				save();
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default:
			}
		}
	}
	
	
	private void save() {
		ObjectOutputStream oos = null;
		try {	
			//내가 한거
			FileOutputStream fout = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fout);
			oos = new ObjectOutputStream(bos);

			// 쓰기 작업
			System.out.println("저장하기 시작...");
			oos.writeObject(phoneBookMap);
			System.out.println("저장하기 완료....");
			oos.close();

		} catch (IOException e) {
			// TODO: handle exception
		} finally{
			try { oos.close(); } catch (IOException e) { }
		}
	}
	private void view() {
		System.out.println("-------------------------------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t\t주소");
		int count=0;
		for(String p : phoneBookMap.keySet()){
			count++;
			System.out.println(count+"\t"+phoneBookMap.get(p).getName()+"\t" + phoneBookMap.get(p).getTel()+"\t\t" + phoneBookMap.get(p).getAddr());
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("출력완료...");
	}
	private void select() {
		System.out.println("검색할 이름을 입력하세요.");
		String name = inputName();
		if(phoneBookMap.get(name) == null){
			System.out.println("해당 이름이 없습니다.");
			return;
		}
		System.out.println("-------------------------------------------------------");
		System.out.println("이름\t전화번호\t\t\t주소");
		System.out.println(phoneBookMap.get(name).getName()+"\t" + phoneBookMap.get(name).getTel()+"\t\t" + phoneBookMap.get(name).getAddr());
		System.out.println("-------------------------------------------------------");
	}
	private void delete() {
		System.out.println("삭제하실 이름을 입력하세요.");
		String name = inputName();
		if(phoneBookMap.get(name) == null){
			System.out.println("해당 이름이 없습니다.");
			return;
		}
		phoneBookMap.remove(name);
		System.out.println("삭제되었습니다.");

	}
	private void update() {
		System.out.println("수정 하실 이름을 입력하세요.");
		String name = sc.nextLine();
		if(phoneBookMap.get(name)==null){
			System.out.println("해당 이름이 없습니다");
			return;
		}
		String tel = inputPhone();
		System.out.print("주소>>");
		String addr = sc.nextLine();
		phoneBookMap.get(name).setTel(tel);
		phoneBookMap.get(name).setAddr(addr);
		System.out.println("수정되었습니다.");

	}
	private void insert() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		String name = inputName();
		if(phoneBookMap.get(name)!=null){
			System.out.println("'"+name+"'은 이미 등록된 사람입니다.");
			return;
		}

		String tel = inputPhone();
		System.out.print("주소>>");
		String addr = sc.nextLine();
		Phone phone = new Phone();
		phone.setName(name);
		phone.setTel(tel);
		phone.setAddr(addr);

		phoneBookMap.put(name, phone);
		System.out.println("'" + name + "' 전화번호 등록 완료!!");
	}
	//전화번호
	private String inputPhone() {
		String tel = null;
		while (true) {
			System.out.print("전화번호>> ");
			tel = sc.nextLine();
			// 정규식 체크
			boolean result = RegEx.regPhone(tel);
			if (result == false) {
				System.out.println("(000-0000-0000)양식에 맞춰 주세요");
				continue;
			} else {
				break;
			}
		}
		return tel;
	}

	//이름 정규식
	private String inputName() {

		String name = null;
		while (true) {
			System.out.print("(2~5한글)이름 >> ");
			name = sc.nextLine();
			// 정규식 체크
			boolean result = RegEx.regName(name);
			if (result == false) {
				System.out.println("이름은 2~5자리 이어야 합니다.");
				continue;
			} else {
				break;
			}
		}
		return name;
	}

	//숫자입력 정규식
	private int inputNumber(){
		String input = null;
		while(true){
			System.out.print("입력 >>");
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

class Phone implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7251673581595708648L;
	private String name;
	private String addr;
	private String tel;




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}


}
