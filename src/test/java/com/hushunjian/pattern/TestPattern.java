package com.hushunjian.pattern;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {
	public static void main(String[] args) {
		
		
		
		
		
		
		
		String a="1-1";
		String regEx="[^0-9]";  
		Pattern p = Pattern.compile(regEx);  
		Matcher m = p.matcher(a);  
		System.out.println( m.replaceAll("").trim());
		}
}
