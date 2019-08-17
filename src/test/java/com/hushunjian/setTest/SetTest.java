package com.hushunjian.setTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class SetTest {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("2");
		set.add("1");
		System.out.println(set.iterator().next());
		
		
		String typeId = null;
		String sign = null;
		System.out.println(StringUtils.isNoneBlank(typeId, sign));
		
		String time = "2019-06-27 10:34:43";
		System.out.println(urlTimeEncode(time));
		
		System.out.println("====================1====================");
		
		Date now = new Date();
		String sendTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(now);
		System.out.println(now);
		System.out.println(sendTime);
		System.out.println("====================2====================");
		Set<String> set1 = new HashSet<>();
		System.out.println(set1.iterator().next());
	}
	
	private static String urlTimeEncode(String time){
		try {
			return URLEncoder.encode(time, "utf-8");
		} catch (UnsupportedEncodingException e) {
			return time;
		}
	}
}
