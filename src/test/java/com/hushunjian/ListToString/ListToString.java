package com.hushunjian.ListToString;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
