package com.hushunjian.math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MathTest {
	 public static void main(String[] args) {
		 
		 BigDecimal doneCount = BigDecimal.valueOf(200); 
		 BigDecimal count = BigDecimal.valueOf(300); 
		 System.out.println(doneCount.divide(count,2,BigDecimal.ROUND_HALF_UP));
		 System.out.println("====================");
		 
		 
		 
		BigDecimal mileageStart = BigDecimal.valueOf(69070.75);
		String formatBigDecimalMileage = formatBigDecimalMileage(mileageStart);
		System.out.println(formatBigDecimalMileage);
		BigDecimal[] divideAndRemainder = mileageStart.divideAndRemainder(new BigDecimal(1000));
		DecimalFormat df1=new DecimalFormat("000.000");
		System.out.println(df1.format(divideAndRemainder[1]).toString());
		DecimalFormat df2=new DecimalFormat("00");
		System.out.println(df2.format(divideAndRemainder[0]));
		System.out.println(String.format("DK%s+%03s", divideAndRemainder[0].intValue(),divideAndRemainder[1].toString()));
		System.out.println(mileageStart.divideToIntegralValue(new BigDecimal(1000)));
		System.out.println(mileageStart.divide(new BigDecimal(1000),0));
	}
	 
	 public static String formatBigDecimalMileage(BigDecimal mileage){
	        BigDecimal[] divideAndRemainder = mileage.divideAndRemainder(new BigDecimal(1000));
	        DecimalFormat df1=new DecimalFormat("00");
	        DecimalFormat df2=new DecimalFormat("000.000");
	        return String.format("DK%s+%s",df1.format(divideAndRemainder[0]),df2.format(divideAndRemainder[1]));
	    }
}
