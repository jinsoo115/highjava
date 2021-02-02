package util;

import java.util.regex.Pattern;

public class RegEx {
	/**
	 * 비밀번호 정규식 체크
	 * @param mem_pw
	 * @return
	 */
	public static boolean regPw(String mem_pw) {
		String str = "[A-Za-z0-9]{4,10}";
		boolean result = Pattern.matches(str, mem_pw);
		return result;
	}
	
	/**
	 * 아이디 정규식 체크
	 * @param mem_id
	 * @return
	 */
	public static boolean regId(String mem_id) {
		String str = "[A-Za-z0-9]{4,10}";
		boolean result = Pattern.matches(str, mem_id);
		return result;
	}
	/**
	 * 이름 정규식
	 * @param mem_name
	 * @return
	 */
	public static boolean regName(String mem_name) {
		String str = "[가-힣]{2,5}";
		boolean result = Pattern.matches(str, mem_name);
		return result;
	}
	/**
	 * 생년월일 정규식
	 * @param mem_birth
	 * @return
	 */
	public static boolean regBirth(String mem_birth) {
		String str = "[01][0-9]{3}-((0[1-9])|(1[0-2]))-((0[1-9])|([1-2][0-9])|(3[0-1]))";
		boolean result = Pattern.matches(str, mem_birth);
		return result;
	}
	/**
	 * 핸드폰번호 정규식
	 * @param mem_phone
	 * @return
	 */
	public static boolean regPhone(String mem_phone) {
		String str = "0[0-1]{2}-[0-9]{4}-[0-9]{4}";
		boolean result = Pattern.matches(str, mem_phone);
		return result;
	}
	/**
	 * 숫자만 입력 정규식
	 */
	public static boolean regNumber(String number){
		String str = "^[0-9]*$";
		boolean result = Pattern.matches(str, number);
		return result;
	}
}
