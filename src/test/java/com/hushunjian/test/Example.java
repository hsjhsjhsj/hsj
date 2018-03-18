package com.hushunjian.test;

public class Example {
	String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };
    public static void main(String args[]) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
        System.out.println("==========");
        for(int i=1;i<=9;i++){
        	for(int j=1;j<=i;j++){
        		System.out.print(j+"*"+i+"="+i*j);
        		System.out.print("    ");
        	}
        	System.out.println();
        }
    }
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}
