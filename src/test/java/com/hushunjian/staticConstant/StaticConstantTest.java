package com.hushunjian.staticConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticConstantTest {

	
	private static final List<String> list = Arrays.asList("1", "2", "3");
	
	public static void main(String[] args) {
		StaticConstantTest t = new StaticConstantTest();
		t.test();
	}
	
	public void test() {
		List<String> a = Arrays.asList("1", "2", "4");
		List<String> b = new ArrayList<String>(list);
		a.forEach(s -> b.remove(s));
		System.out.println(b);
	}
}
