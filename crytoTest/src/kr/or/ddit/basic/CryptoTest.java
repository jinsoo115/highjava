package kr.or.ddit.basic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import kr.or.ddit.util.CrytoUtil;

public class CryptoTest {
	private static final String key = "a1b2c3d4e5f6g7h8";
	
	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String plainText = 
				"123456789012345";
//				"Hello, World! 가나다라 대한민국 12345 ^&*()";
		
//		final String key = "a1b2c3d4e5f6g7h8"; // 16글자 이상
		System.out.println("MD5 	: " + CrytoUtil.md5(plainText));
		System.out.println("SHA-256 : " + CrytoUtil.sha256(plainText));
		System.out.println("SHA-521 : " + CrytoUtil.sha512(plainText));
		
		System.out.println("------------------------------------------");
		System.out.println();
		
		String result = CrytoUtil.encryptAES256(plainText, key);
		String result2 = CrytoUtil.decryptAES256(result, key);
		System.out.println("원본데이터	   : " + plainText);
		System.out.println("암호화 된 데이터 : " + result);
		System.out.println("복호화 된 데이터 : " + result2);
		
	}
	
}
