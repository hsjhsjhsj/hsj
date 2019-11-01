package com.hushunjian.integerTest;

import org.apache.commons.lang3.StringUtils;

public class IntegerTest {
	public static void main(String[] args) {
		int value = 4;
		System.out.println(String.format("%3ssd", value));
		System.out.println(StringUtils.leftPad(String.valueOf(value), 3, "ss"));
	}
}
