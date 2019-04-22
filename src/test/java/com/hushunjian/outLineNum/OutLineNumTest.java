package com.hushunjian.outLineNum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OutLineNumTest {
	public static void main(String[] args) {
		List<OutLineNumTestDTO> list = new ArrayList<>();
		list.sort(new OutLineNumComparator());
		
		
		// String outLineNum = "1.2.3.6.44.555";
		String outLineNum = "1";
		String[] split = outLineNum.split("\\.");
		Set<String> parent = new HashSet<>();
		String s = split[0];
		for(int i = 1; i< split.length -1; i++){
			s = String.format("%s.%s", s, split[i]);
			parent.add(s);
		}
		System.out.println(parent);
		
		System.out.println("------------------");
		String path = "1.2";
		System.out.println(path.substring(0, path.lastIndexOf(".")));
	}
}
