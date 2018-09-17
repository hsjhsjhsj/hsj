package com.hushunjian.StringSplitTest;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

public class StringSplitTest {
	public static void main(String[] args) {
		String s1 = "";
		System.out.println(s1.split("\\.")[0]);
		
		
		String a = "aaaaaaaaaaaaa";
		for(int i=0;i<3;i++){
			a += i;
			System.out.println(a);
		}
		
		String b = "B12";
		System.out.println("===================");
		System.out.println(b.substring(1));
		System.out.println("===================");
		String c = "A25Z-1-D1";
		String[] split = c.split("-");
		System.out.println(split[1]);
		System.out.println("===================");
		String d = "1";
		String[] splitd = d.split("-");
		System.out.println(splitd.length);
		List<String> strs = new ArrayList<String>();
		for(String str : strs){
			
		}
		
		System.out.println("[==============================]");
		String aa = "1.1.1.1.1.1.1.1";
		String[] bb = aa.split("\\.");
		for(int i = 0;i<bb.length;i++){
			System.out.println(bb[i]);
		}
		System.out.println("[==============================]");
		String cc = aa.substring(0, aa.length()-2);
		System.out.println(cc);
		System.out.println("[==============================]");
		
		//subString(aa);
		StringSplitTest stringSplitTest = new StringSplitTest();
		List<String> parentPlanTaskOutLineNums = stringSplitTest.getParentPlanTaskOutLineNum(aa,new ArrayList<>());
		for(String parentPlanTaskOutLineNum : parentPlanTaskOutLineNums){
			System.out.println(parentPlanTaskOutLineNum);
		}
	}
	
	public static String subString (String string){
		if(string.length() < 3){
			return string;
		}
		String a = string.substring(0,string.length()-2);
		subString(a);
		System.out.println(a);
		return a;
	}
	
    private List<String> getParentPlanTaskOutLineNum(String currentOutLineNum,List<String> parentPlanTaskOutLineNums){
        if(currentOutLineNum.length() < 3){
            return parentPlanTaskOutLineNums;
        }
        String a = currentOutLineNum.substring(0,currentOutLineNum.length()-2);
        parentPlanTaskOutLineNums.add(a);
        getParentPlanTaskOutLineNum(a,parentPlanTaskOutLineNums);
        return parentPlanTaskOutLineNums;
    }
	
}
