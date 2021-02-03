package kr.or.ddit.basic;

import org.apache.log4j.Logger;

public class Log4jTest {
	// Logger 클래스의 인스턴스를 받아온다.
	private static Logger logger = Logger.getLogger(Log4jTest.class);
	public static void main(String[] args) {
		// 로그 기록을 남기는 메서드는 로그 레벨과 1대1로 대응이 되는
		// 메서드를 제공한다.
		// 형식) logger객체 변수, 로그레벨메서드("출력할 메시지");
		// 로그레벨 : trace < debug < info < warn < error < fatal
		logger.trace("이것은 log4j의 Trace 레벨의 메시지입니다.");
		logger.debug("이것은 log4j의 Debug 레벨의 메시지입니다.");
		logger.info("이것은 log4j의 Info 레벨의 메시지입니다.");
		logger.warn("이것은 log4j의 Warn 레벨의 메시지입니다.");
		logger.error("이것은 log4j의 Error 레벨의 메시지입니다.");
		logger.fatal("이것은 log4j의 Fatal 레벨의 메시지입니다.");
	}
}
