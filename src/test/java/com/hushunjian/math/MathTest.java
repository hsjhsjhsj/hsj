package com.hushunjian.math;

import java.math.BigDecimal;

public class MathTest {
	 public static void main(String[] args) {
		Long a = 10L;
		Long b = 3L;
		double f1 = new BigDecimal((float)a/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(f1);
	}
}
