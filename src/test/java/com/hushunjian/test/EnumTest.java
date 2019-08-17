package com.hushunjian.test;

import java.util.Date;

public class EnumTest {
	public static void main(String[] args) {
		Date time1 = new Date();
		TestEnum test = TestEnum.a;
		if (TestEnum.a.equals(test)) {
			System.out.println("true");
		}
		System.out.println(System.currentTimeMillis() - time1.getTime());
		Date time2 = new Date();
		if (TestEnum.a == test) {
			System.out.println("true");
		}
		System.out.println(System.currentTimeMillis() - time2.getTime());
	}
}
