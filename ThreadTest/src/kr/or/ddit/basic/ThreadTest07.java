package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 문제) 컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
 * 		컴퓨터의 가위 바위 보는 난수를 이용해서 정하고,
 * 		사용자는 showInputDialog()메서드를 이용해서 입력받는다.
 * 		
 * 		입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
 * 		5초안에 입력이 없으면 게임에 진것으로 처리한다.
 * 
 *  	5초안에 입력이 완료되면 승패를 구해서 출력한다.
 *
 *  1)	5초 안에 입력을 못했을 경우 실행 예시
 *  	-- 결과 --
 *  	시간 초과로 당신이 졌습니다.
 *  2)	5초 안에 입력을 했을 경우 실행 예시
 *  	-- 결과 --
 *  	컴퓨터 : 가위
 *  	사용자 : 바위
 *  	결   과 : 당신이 이겼습니다.
 *  		
 */
public class ThreadTest07 {
	public static void main(String[] args) {
		Thread th1 = new Input();
		Thread th2 = new CountDown();

		th1.start();
		th2.start();

	}
}

class Input extends Thread {
	public static boolean check = false;
	int computer = (int) (Math.random() * 3);

	@Override
	public void run() {
		String com;
		if (computer == 1) {
			com = "가위";
		} else if (computer == 2) {
			com = "바위";
		} else {
			com = "보";
		}
		String str = JOptionPane.showInputDialog("가위 바위 보 중에 입력하세요");

		check = true;

		System.out.println("-- 결과 --");
		if (str.equals(com)) {
			System.out.println("컴퓨터 : " + com);
			System.out.println("사용자 : " + str);
			System.out.println("결과 : 비겼습니다.");
		} else if ((com.equals("바위") && str.equals("가위"))
				|| (com.equals("보") && str.equals("바위"))
				|| (com.equals("가위") && str.equals("보"))) {
			System.out.println("컴퓨터 : " + com);
			System.out.println("사용자 : " + str);
			System.out.println("결   과 : 당신이 졌습니다.");
		} else if ((com.equals("가위") && str.equals("바위"))
				|| (com.equals("바위") && str.equals("보"))
				|| (com.equals("보") && str.equals("가위"))) {
			System.out.println("컴퓨터 : " + com);
			System.out.println("사용자 : " + str);
			System.out.println("결   과 : 당신이 이겼습니다.");
		} else {
			System.out.println("컴퓨터 : " + com);
			System.out.println("사용자 : " + str);
			System.out.println("결   과 : 잘못 입력하셨습니다.");
		}
		System.exit(0);
	}
}

class CountDown extends Thread {
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			if (Input.check == true) {
				return;
			}
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("-- 결과 --");
		System.out.println("시간초과로 당신이 졌습니다. ");
		System.exit(0);
	}
}