package kr.or.ddit.util;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CrytoUtil {
	/**
	 * 문자열을 MD5방식으로 암호화(해시) 한다.
	 * @param str 암호화 할 문자열
	 * @return 암호화 된 문자열
	 * @throws NoSuchAlgorithmException 
	 */
	public static String md5(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(str.getBytes());
		
		return Base64.getEncoder().encodeToString(md.digest());
	}
	// 문자열을 SHA-256방식으로 암호화하는 메서드
	public static String sha256(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(str.getBytes());
		
		return Base64.getEncoder().encodeToString(md.digest());
	}
	
	// 문자열을 SHA-512방식으로 암호화하는 메서드
	public static String sha512(String str) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(str.getBytes());
		
		return Base64.getEncoder().encodeToString(md.digest());
	}
	/**
	 * AES 256 방식으로 암호화하는 메서드
	 * @param str 암호화 할 문자열
	 * @param key 암호키값 문자열(16자 이상)
	 * @return 암호화 된 문자열
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidAlgorithmParameterException 
	 * @throws InvalidKeyException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 */
	public static String encryptAES256(String str, String key) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		String iv = key.substring(0,16);
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = keyBytes.length;
		
		System.arraycopy(b, 0, keyBytes, 0, len);
		
		// 비밀키 생성 (암호화할 byte배열, 알고리즘 이름)
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		
		// Cipher객체 생성 및 초기화 
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		
		byte[] ivBytes = new byte[16];
		
		System.arraycopy(iv.getBytes(), 0, ivBytes, 0, ivBytes.length);
		
		// 옵션 종류에 맞게 초기화 한다.
		c.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(ivBytes));
		
		// 암호문 생성
		byte[] encryped = c.doFinal(str.getBytes("UTF-8"));
		
		String enStr = Base64.getEncoder().encodeToString(encryped);
		
		return enStr;
	}
}
