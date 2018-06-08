package com.hushunjian.ListToString;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ListToString {
	public static void main(String[] args) {
		List<String> strs = new ArrayList<String>();
		strs.add("1");
		strs.add("11");
		strs.add("111");
		strs.add("1111");
		strs.add("11111");
		strs.add("111111");
		strs.add("1111111");
		String a = StringUtils.join(strs.toArray(), "','");
		System.out.println(a);
	}
}
