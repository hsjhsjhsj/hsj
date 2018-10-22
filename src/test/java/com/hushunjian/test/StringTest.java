package com.hushunjian.test;

import java.util.regex.Pattern;

import org.codehaus.groovy.util.StringUtil;

public class StringTest {
	public static void main(String[] args) {
		String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s1.intern());
        System.out.println("=================");
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.out.println(str1 == str2);
        System.out.println("++++++++++++++++");
        String str3 = "iosaaa";
        String str4 = filter(str3);
        System.out.println(str4);
        System.out.println("888888888888888888");
        String key = "FD9CAD10A58146D1825FA9E48F431437";
        StringBuffer sb = new StringBuffer();
        sb.append(key.substring(0, 4)).append("******").append(key.substring(key.length()-4, key.length()));
        System.out.println(sb.toString());
        System.out.println("PPPPPPPPPPPPPPPPPPPP");
        String a ="       ";
        System.out.println(a.isEmpty());
        System.out.println("AAAAAAAAAAAAAAAAAAAAA");
        String outLineNum = "1.2.1.1.2";
        System.out.println(outLineNum.substring(0,outLineNum.lastIndexOf(".")));
	}
	
	public static String filter(String str) {
		String regex = "^(ios)$";
		boolean matches = Pattern.matches(regex,str);
		if(matches){
			return str;
		}
		return null;
	}
	
}
