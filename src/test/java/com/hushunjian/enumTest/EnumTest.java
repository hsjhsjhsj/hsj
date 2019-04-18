package com.hushunjian.enumTest;

import lombok.Getter;

public enum EnumTest {
	
	test_2(0, "2"),
	test_1(0, "1"),
	test_3(0, "3");
	
	
	EnumTest(int key, String value){
		this.key = key;
		this.value = value;
	}
	@Getter
	private int key;
	@Getter
	private String value;
}
