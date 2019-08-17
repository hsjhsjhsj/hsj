package com.hushunjian.bigdecimalTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalTest {
	public static void main(String[] args) {
		BigDecimal total = BigDecimal.ZERO;
		List<BigDecimal> list = new ArrayList<>();
		list.add(BigDecimal.ZERO);
		//list.add(BigDecimal.ONE);
		for(BigDecimal a : list){
			total = total.add(a);
		}
		if (BigDecimal.ZERO.equals(total)) {
			System.out.println("与0相等");
		}else if(BigDecimal.ONE.equals(total)){
			System.out.println("与1相等");
		}else{
			
		}
		
		
		BigDecimal a1 = BigDecimal.TEN;
		Integer a2 = 10;
		if (a1.intValue() == a2) {
			System.out.println("a1,a2相等");
		}
		System.out.println("==========1==========");
		BigDecimal b1 = BigDecimal.valueOf(0.26);
		BigDecimal b2 = BigDecimal.ONE;
		System.out.println(b1.compareTo(b2));
	}
}
