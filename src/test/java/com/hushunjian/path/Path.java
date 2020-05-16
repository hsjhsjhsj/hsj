package com.hushunjian.path;

import org.apache.commons.lang3.StringUtils;

public class Path {

	public static void main(String[] args) {
		String path = "00ZY1C";
		if (StringUtils.isBlank(path)) {
			System.out.println("字符不可为空!");
			return;
		}
		int length = path.length();
		if (length < 2 || length % 2 != 0) {
			System.out.println("字符长度不正确!");
			return;
		}
		String last = path.substring(length - 2, length);
		System.out.println("last:" + last);
		if (StringUtils.equals(last, "ZZ")) {
			System.out.println("限制ZZ!");
			return;
		}
		String lastOne = last.substring(0, 1);
		String lastTwo = last.substring(1);
		System.out.println("lastOne:" + lastOne);
		System.out.println("lastTwo:" + lastTwo);
		char lastOneChar = last.charAt(0);
		char lastTwoChar = last.charAt(1);
		System.out.println("lastOneChar:" + lastOneChar);
		System.out.println("lastTwoChar:" + lastTwoChar);
		int step = 4;
		char a = (char) (lastOneChar + step);
		System.out.println("a:" + a);
		
		System.out.println("lastOneChar+1:" + lastOneChar + 1);
		System.out.println("lastTwoChar+1:" + lastTwoChar + 1);
		System.out.println("==========================================");
		char source = 'A';
		char target = (char) (source + step);
		System.out.println("target:" + target);
		System.out.println("==========================================");
		System.out.println(nextChar('9', 1));
	}
	
	public static char nextChar(char c, int step) {
		int next = c + step;
		return (char) next;
	}
}
