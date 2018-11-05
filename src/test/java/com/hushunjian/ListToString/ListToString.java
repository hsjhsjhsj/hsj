package com.hushunjian.ListToString;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

public class ListToString {
	
	private static void strs(){
		List<String> strs = new ArrayList<String>();
		if(strs==null||strs.size()<1){
			strs.add("1");
		}
		System.out.println(strs.get(0));
	}
	public static void main(String[] args) {
		String s = "1233";
		List<String> ss = Arrays.asList(s);
		
		System.out.println(ss);
		
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
		System.out.println("====================");
		strs();
		String str = "meetId:"+123;
		try {
			byte[] bytes = str.getBytes("UTF-8");
			for(byte bytea:bytes){
				System.out.println(bytea);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
