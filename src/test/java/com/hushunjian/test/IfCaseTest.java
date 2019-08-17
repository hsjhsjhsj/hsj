package com.hushunjian.test;

import java.util.Date;

public class IfCaseTest {
	public static void main(String[] args) {
		int num = 3;
		Date start1 = new Date();
		for(int i=0;i<=300000000;i++){
			testIf(num);
		}
		System.out.println(System.currentTimeMillis() - start1.getTime());
		System.out.println("======================");
		Date start2 = new Date();
		for(int i=0;i<=300000000;i++){
			testCase(num);
		}
		System.out.println(System.currentTimeMillis() - start2.getTime());
		
	}
	
	private static void testIf(int num){
		if (num == 0) {
			
		}else if(num == 1){
			
		}else if(num == 2){
			
		}else if(num == 3){
			
		}else{
			
		}
	}
	
	private static void testCase(int num){
		switch(num){
		case 0:
			break;
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		default:
			break;
		}
	}
	
	
}
