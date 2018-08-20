package com.hushunjian.StringSplitTest;

import java.util.ArrayList;
import java.util.List;

public class StringSplitTest {
	public static void main(String[] args) {
		String s1 = "";
		System.out.println(s1.split("\\.")[0]);
		
		
		String a = "aaaaaaaaaaaaa";
		for(int i=0;i<3;i++){
			a += i;
			System.out.println(a);
		}
		
		String b = "B12";
		System.out.println("===================");
		System.out.println(b.substring(1));
		System.out.println("===================");
		String c = "A25Z-1-D1";
		String[] split = c.split("-");
		System.out.println(split[1]);
		System.out.println("===================");
		String d = "1";
		String[] splitd = d.split("-");
		System.out.println(splitd.length);
		List<String> strs = new ArrayList<String>();
		for(String str : strs){
			
		}
		
		System.out.println("==============================");
		
	}
	
}
