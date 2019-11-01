package com.hushunjian.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Base64Test {
	
	
	public static void main(String[] args) {
		
		// 解密
		Decoder decoder = Base64.getDecoder();
		
		// 加密
		Encoder encoder = Base64.getEncoder();
		
		String password = "111111";
		System.out.println("密码:" + password);
		String encodeToString = encoder.encodeToString(password.getBytes());
		System.out.println("加密密码:" + encodeToString);
		byte[] decode = decoder.decode("bnVsbA==");
		System.out.println("解密密码(不添加字符集指定):" + decode);
		try {
			String string = new String(decode, "UTF-8");
			System.out.println("解密密码(添加字符集指定:)" + string);
			System.out.println(password.equals(string));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
