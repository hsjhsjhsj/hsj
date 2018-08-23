package com.hushunjian.DoubleTest;

import java.math.BigDecimal;

public class DoubleTest {
	public static void main(String[] args) {
		Double a = 0.0007;
		BigDecimal b1 = new BigDecimal(Double.toString(a));
		BigDecimal b2 = new BigDecimal(Double.toString(100));
		System.out.println(b1.multiply(b2).doubleValue());
	}
}
