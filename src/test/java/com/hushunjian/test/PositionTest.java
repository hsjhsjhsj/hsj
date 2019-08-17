package com.hushunjian.test;

import java.util.Date;
import java.util.HashMap;

public class PositionTest {
	
	/**
     * 方位
     */
    private final static HashMap<Double, String> POSITION_MAP = new HashMap<>();
    
    static{
        POSITION_MAP.put(0.0, "北");
        POSITION_MAP.put(0.5, "东北");
        POSITION_MAP.put(1.0, "东");
        POSITION_MAP.put(1.5, "东南");
        POSITION_MAP.put(2.0, "南");
        POSITION_MAP.put(2.5, "西南");
        POSITION_MAP.put(3.0, "西");
        POSITION_MAP.put(3.5, "西北");
        POSITION_MAP.put(4.0, "北");
    }
	
    private static String angleToPosition(double angle){
    	Double position = angle / 90;
    	if (position.intValue() != position) {
    		position = position.intValue() + 0.5;
    	}
        return POSITION_MAP.get(position);
    }
    
	public static void main(String[] args) {
		Date start = new Date();
		for(int i=0;i<=3000000;i++){
			angleToPosition(270.0);
			//System.out.println(angleToPosition(270.0));
		}
		System.out.println(System.currentTimeMillis() - start.getTime());
		System.out.println("==============================");
		Date start1 = new Date();
		for(int j=0;j<=3000000;j++){
			angleToPosition1("270");
			//System.out.println(angleToPosition1("270"));
		}
		System.out.println(System.currentTimeMillis() - start1.getTime());
		System.out.println("==============================");
		double quotient = 45.0 / 90;
		System.out.println(quotient);
		if (quotient % 1 != 0) {
			System.out.println("有小数");
		}else{
			System.out.println("没有小数");
		}
		System.out.println("==============================");
		double angle1 = 0.00;
		System.out.println(angleToPosition(angle1));
		double angle2 = 45.00;
		System.out.println(angleToPosition(angle2));
		double angle3 = 90.00;
		System.out.println(angleToPosition(angle3));
		double angle4 = 135.00;
		System.out.println(angleToPosition(angle4));
		double angle5 = 180.00;
		System.out.println(angleToPosition(angle5));
		double angle6 = 225.00;
		System.out.println(angleToPosition(angle6));
		double angle7 = 270.00;
		System.out.println(angleToPosition(angle7));
		double angle8 = 315.00;
		System.out.println(angleToPosition(angle8));
		double angle9 = 360.00;
		System.out.println(angleToPosition(angle9));
		
		for(double k = 0;k<=360;k++){
			System.out.println(k + "====" + angleToPosition(k));
		}
	}
	
	private static String angleToPosition1(String angle){
		Integer angleValue = Integer.valueOf(angle);
		String positon = null;
		switch(angleValue % 90){
		case 0:
			positon = angleToPosition1(angleValue);
			break;
		default:
			positon = angleToPosition2(angleValue);
			break;
		}
		return positon;
	}
	
	private static String angleToPosition1(int angle){
		String position = null;
		switch(angle / 90){
		case 0:
			position = "北";
			break;
		case 1:
			position = "东";
			break;
		case 2:
			position = "南";
			break;
		case 3:
			position = "西";
			break;
		}
		return position;
	}
	
	private static String angleToPosition2(int angle){
		String position = null;
		switch(angle / 90){
		case 0:
			position = "东北";
			break;
		case 1:
			position = "东南";
			break;
		case 2:
			position = "西南";
			break;
		case 3:
			position = "西北";
			break;
		}
		return position;
	}
}
