package kr.or.ddit.basic;

class NonGenericClass{
	private Object value;
	
	public void setValue(Object value){
		this.value = value;
	}
	public Object getValue(){
		return value;
		
	}
}

/*
 * 제네릭 클래스를 만드는 방법
 * (형식)
 * class 클래스명<제네릭타입글자>{
 * 		제네릭타입글자 변수명; // 변수 선언에 제네릭을 사용할 경우
 * 		...
 * 		제네릭타입글자 메서드명(){ // 메서드의 반환값에 제네릭을 사용할 경우
 * 			...
 * 			return 값;
 * 		}
 * 
 * 		void 메서드명(제네릭타입글자 변수명){	// 메서드의 매개변수에 제네릭을 사용할 경우
 * 			...
 * 		}
 * }
 * -- 제네릭 타입 글자로 많이 사용되는 것 --
 * T ==> Type
 * K ==> Key
 * V ==> Value
 * E ==> Element(자료구조에 들어가는 것들을 주로 나타낸다.)
 */


class MyGeneric<T>{
	private T value;
	public void setValue(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
}

public class GenericTest {
	
	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setValue("가나다라");
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setValue(100);
		
		String rtnNg1 = (String) ng1.getValue();
		System.out.println("문자열 반환값 : " + rtnNg1);
		int rtnNg2 = (int) ng2.getValue();
		System.out.println("정수 반환값 : " + rtnNg2);
		System.out.println();
		
//		String rtnNg3 = (String) ng2.getValue();
//		System.out.println("rtnNg3 = " + rtnNg3);
		
		//부모타입을 자식타입으로 형변환 할 때는 문제가 되지 않는다
		
		MyGeneric<String> mg1 = new MyGeneric<>();
		MyGeneric<Integer> mg2 = new MyGeneric<>();
		
		mg1.setValue("우리나라");
		mg2.setValue(500);
		
		System.out.println(mg1.getValue());
		System.out.println(mg2.getValue());
		
		String rtnMg1 = mg1.getValue();
		int rtnMg2 = mg2.getValue();
		
//		mg1.setValue(200);
//		mg2.setValue("가나다");// 컴파일 단계에서 오류를 검사가능
		
		System.out.println("문자열  반환값  : " + rtnMg1);
		System.out.println("정수  반환값  : " + rtnMg2);
		
	}
}
