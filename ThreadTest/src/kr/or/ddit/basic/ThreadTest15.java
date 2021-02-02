package kr.or.ddit.basic;

// 쓰레드에서 객체를 공통으로 사용하는 예제

/*
 * 원주율을 계산하는 쓰레드와
 * 계산된 원주율을 출력하는 쓰레드가 있다.
 * 
 * 이떄 원주율을 저장하는 객체가 필요하다.
 * 이 객체를 두 쓰레드에서 공통으로 사용해서 처리한다.
 */
public class ThreadTest15 {
	public static void main(String[] args) {
		// 공통으로 사용할 객체를 생성한다.
		ShareData sd = new ShareData();
		
		// 각각의 쓰레드 객체를 생성하고, 공통으로 사용할 객체를
		// 쓰레드 객체에 주입한다.
//		CalcPIThread cal = new CalcPIThread(sd);
		CalcPIThread cal = new CalcPIThread();
		cal.setSd(sd); // setter를 이용한 주입
		
		// 생성자를 이용한 주입
		printPIThread prn = new printPIThread(sd);
		
		cal.start();
		prn.start();
	}
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;

	// 생성자
	/*public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}*/
	
	// setter를 이용하기
	public void setSd(ShareData sd){
		this.sd = sd;
	}
	
	@Override
	public void run() {
		// 원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 - ....)
		//		  1 	-3	+5	-7	+9...		
		//		  0		1	2	3	4	5...
		double sum =0.0;
		for(int i =1; i <=1000000000; i +=2){
			if((i/2)%2==0){
				sum += (1.0/i);
			}else{
				sum -= (1.0/i);
			}
		}
		// 계산이 완료된 결과를 ShareData객체에 저장한다.
		sd.setResult(sum * 4);
		sd.setChk(true);
		
	}
	
}

// 계산된 원주율을 출력하는 쓰레드
class printPIThread extends Thread{
	private ShareData sd;

	public printPIThread(ShareData sd) {
		super();
		this.sd = sd;
	}
	@Override
	public void run() {
		while(true){
			if(sd.isChk()){
				System.out.println();
				System.out.println("결과 : " + sd.getResult());
				System.out.println("PI : " + Math.PI);
				break;
			}
		}
	}
}

// 원주율을 관리하는 클래스(이 클래스가 공통으로 사용할 클래스이다.)
class ShareData{
	private double result; // 계산된 원주율이 저장될 변수
	private volatile boolean chk; // 계산이 완료되었는지를 나타내는 변수
									// 계산이 완료되면 true로 변경된다.
	
	// volatile ==> 이 키워드가 붙은 변수는 값이 변경되는 즉시 변수에 적용 시킨다.
	// 				즉, CPU의 코어에 있는 캐쉬를 사용하지 않고 직접 메모리의 
	//				데이터를 입출력 한다.
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public boolean isChk() {
		return chk;
	}
	public void setChk(boolean chk) {
		this.chk = chk;
	}
	
	
}