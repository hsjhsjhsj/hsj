package com.hushunjian.test;

class A {
	 
    static {
        System.out.print("1");
    }
 
    public A() {
        System.out.print("2");
    }
}
 
class B extends A{
 
    static {
        System.out.print("a");
    }
 
    public B() {
        System.out.print("b");
    }
}


public class Test {
	static{
		int x = 5;//局部变量
	}
	static int x,y;
	
	public static void main(String[] args) {
		x--;
		myMethod();
		System.out.println(x + y++ + x);
		int i=0;
		System.out.println('0');
		System.out.println("0="+(int)'0');
		System.out.println("a="+(int)'a');
		System.out.println("z="+(int)'z');
		System.out.println("A="+(int)'A');
		System.out.println("Z="+(int)'Z');//26个英文字母，+25，
		System.out.println(i+'0');//自动类型转换
		int j=0;
		for(i=0;i<100;i++){
			j=j++;
		}
		System.out.println("j="+j);
		
		A ab = new B();
        ab = new B();
	}
	public static void myMethod(){
		y = x++ + ++x;
	}
	
	
	
	
	
	
	
}
