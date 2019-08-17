package com.hushunjian.listAverage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ListAverage {
	public static void main(String[] args) {
		
		List<String> l1 = new ArrayList<>();
		l1.add("1");
		l1.add("12");
		l1.add("13");
		l1.add("14");
		l1.add("15");
		l1.add("16");
		l1.add("17");
		l1.add("18");
		l1.add("19");
		l1.add("10");
		l1.add("1a");
		l1.add("1s");
		l1.add("1d");
		l1.add("1f");
		l1.add("1g");
		l1.add("1h");
		l1.add("1j");
		l1.add("1k");
		l1.add("1l");
		l1.add("1q");
		l1.add("1w");
		l1.add("1e");
		l1.add("1r");
		l1.add("1t");
		l1.add("1y");
		l1.add("1u");
		l1.add("1i");
		l1.add("1o");
		l1.add("1p");
		l1.add("1p");
		System.out.println("去重前list长度:"+l1.size());
		Collection<String> l2 = new HashSet<>(l1);
		System.out.println("使用set去重后长度:"+l2.size());
		
		int size = l1.size() / 2;
		System.out.println(size);
		for(int i = 0; i <= size; i++){
			List<String> l3 = l1.subList(i*2, (i+1)*2 > l1.size()?l1.size():(i+1)*2);
			System.out.println(l3+"==="+l3.size());
		}
		System.out.println("=====================1=====================");
		for(String s : l1){
			if (StringUtils.equals(s, "17")) {
				return;
			}
			System.out.println(s);
		}
		
	}
}
