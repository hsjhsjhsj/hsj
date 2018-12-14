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
	}
}
