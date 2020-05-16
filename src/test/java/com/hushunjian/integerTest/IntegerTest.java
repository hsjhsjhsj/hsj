package com.hushunjian.integerTest;

import org.apache.commons.lang3.StringUtils;

public class IntegerTest {
	public static void main(String[] args) {
		int value = 4;
		System.out.println(String.format("%3ssd", value));
		System.out.println(StringUtils.leftPad(String.valueOf(value), 3, "ss"));
		Integer source = 2;
		System.out.println("==========1");
		System.out.println(Integer.toHexString(source));
		System.out.println("==========2");
		int orderNum = 0;
		int temp = orderNum;
		System.out.println(orderNum);
		for (int i = 0; i< 10; i++) {
			System.out.println(++temp);
		}
		System.out.println(orderNum);
	}
}
