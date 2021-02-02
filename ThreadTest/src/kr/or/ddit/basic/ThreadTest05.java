package kr.or.ddit.basic;

import javax.swing.JOptionPane;

public class ThreadTest05 {
	public static void main(String[] args) {
		// 사용자로부터 데이터 입력 받기
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		System.out.println("입력값: " + str);

		for (int i = 10; i > 0; i--) {
			// 입력이 완료되었는지 여부를 검사해서 이볅이 완료되면
			// 카운트 다운 쓰레드를 종료시킨다.

			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다.");
		System.exit(0);
	}
}
