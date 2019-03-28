package com.hushunjian.test;

import java.math.BigDecimal;

public class NumberTest {
	private static final int BASE = 1024;

	public static void main(String[] args) {
		String a = "2222222222222";
		Long b = Long.valueOf(a);
		System.out.println(bytes2kb(b));
		System.out.println(converByteSize(b));
	}
	
	public static String bytes2kb(long bytes) {
        BigDecimal filesize = new BigDecimal(bytes);
        BigDecimal gibibyte = new BigDecimal(1024*1024*1024);
        float returnValue = filesize.divide(gibibyte, 2, BigDecimal.ROUND_UP).floatValue();
        if(returnValue > 10) {
            return (returnValue + "GB");
        } else {
            BigDecimal mebibyte = new BigDecimal(1024*1024);
            returnValue = filesize.divide(mebibyte, 2, BigDecimal.ROUND_UP).floatValue();
            if(returnValue > 1) {
                return (returnValue + "MB");
            } else {
                BigDecimal kibibyte = new BigDecimal(1024);
                returnValue = filesize.divide(kibibyte, 2,BigDecimal.ROUND_UP).floatValue();
                return (returnValue + "KB");
            }
        }
    }
	public static String converByteSize(long byteSize) {
        BigDecimal byteNum = new BigDecimal(byteSize);
        BigDecimal divisor = BigDecimal.ONE;
        String unit;
        float value;
        if (byteSize < BASE){
            unit = "BT";
        }else if (byteSize < BASE * BASE){
            divisor = new BigDecimal(BASE);
            unit = "KB";
        }else if(byteSize < BASE * BASE * BASE) {
            unit = "MB";
            divisor = new BigDecimal(BASE * BASE);
        }else {
            unit = "GB";
            divisor = new BigDecimal(BASE * BASE * BASE);
        }
        value = byteNum.divide(divisor, 2, BigDecimal.ROUND_UP).floatValue();
        return value + unit;
    }
}
