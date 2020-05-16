package com.hushunjian.urlTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UrlTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String sendTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		System.out.println(sendTime);
		System.out.println(URLEncoder.encode(sendTime, "utf-8"));
		
	}
}
