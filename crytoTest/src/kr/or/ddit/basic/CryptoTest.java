package kr.or.ddit.basic;

import java.security.NoSuchAlgorithmException;

import kr.or.ddit.util.CrytoUtil;

public class CryptoTest {
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String plainText = "Hello, World! 가나다라 대한민국 12345 ^&*()";
		System.out.println("MD5 : " + CrytoUtil.md5(plainText));
		System.out.println("SHA-256 : " + CrytoUtil.sha256(plainText));
		System.out.println("SHA-521 : " + CrytoUtil.sha512(plainText));
	}
	
}
