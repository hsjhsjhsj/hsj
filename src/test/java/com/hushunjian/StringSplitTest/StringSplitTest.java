package com.hushunjian.StringSplitTest;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

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
		System.out.println("[||||||||||||||||||||||||||||||]");
		System.out.println("[==============================]");
		subString(aa);
		System.out.println("[==============================]");
		System.out.println("[||||||||||||||||||||||||||||||]");
		System.out.println("[==============================]");
		StringSplitTest stringSplitTest = new StringSplitTest();
		List<String> parentPlanTaskOutLineNums = stringSplitTest.getParentPlanTaskOutLineNum(aa,new ArrayList<>());
		for(String parentPlanTaskOutLineNum : parentPlanTaskOutLineNums){
			System.out.println(parentPlanTaskOutLineNum);
		}
		System.out.println("[==============================]");
		System.out.println("[||||||||||||||||||||||||||||||]");
		System.out.println("[==============================]");
		Set<String> order = order("1,2,5,1,3,4,2");
		for(String as : order){
			System.out.println(as);
		}
		System.out.println("[==============================]");
		System.out.println("[||||||||||||||||||||||||||||||]");
		System.out.println("[==============================]");
		List<String> aas = new ArrayList<>();
		aas.add("1");
		aas.add("12");
		aas.add("13");
		aas.add("14");
		System.out.println(aas.indexOf("12d"));
		System.out.println("[==============================]");
		System.out.println("[||||||||||||||||||||||||||||||]");
		System.out.println("[==============================]");
		aa(BigDecimal.valueOf(0.0001));
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-1-|||||||||||||||]");
		System.out.println("[==============================]");
		String as = "1.2.32.3.6.2.33.55";
		List<String> allParent = getAllParent(as);
		System.out.println(allParent);
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-2-|||||||||||||||]");
		System.out.println("[==============================]");
		List<String> parentPlanTaskOutLineNum = getParentPlanTaskOutLineNum(as);
		System.out.println(parentPlanTaskOutLineNum);
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-3-|||||||||||||||]");
		System.out.println("[==============================]");
		String as1 = "56.25.3.25.2";
		System.out.println(as1.split("\\.")[0] + "." + as1.split("\\.")[1]);
	}
	
	public static Set<String> order(String string){
		String[] split = string.split(",");
		Set<String> set = new LinkedHashSet<>(Arrays.asList(split));
		return set;
	}
	
	public static String aa(BigDecimal number){
		String aa = NumberFormat.getInstance().format(number.longValue() * 100);
		System.out.println(aa);
		return aa;
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
    
    private static List<String> getAllParent(String outLineNumber){
    	List<String> all = new ArrayList<String>();
    	// 分隔
    	String[] split = outLineNumber.split("\\.");
    	String as = "";
    	for(String a : split){
    		as = as + "." + a;
    		// 去除最开始的.
    		all.add(as.replaceFirst("\\.", ""));
    	}
    	return all;
    }
    
    private static List<String> getParentPlanTaskOutLineNum(String currentOutLineNum) {
        List<String> parentPlanTaskOutLineNum = new ArrayList<>();
        String[] split = currentOutLineNum.split("\\.");
        String parentOutLineNum = "";
        for (int i = 0; i < split.length - 1; i++) {
            parentOutLineNum = String.format("%s.%s", parentOutLineNum, split[i]);
            parentPlanTaskOutLineNum.add(parentOutLineNum.replaceFirst("\\.", ""));
        }
        return parentPlanTaskOutLineNum;
    }
}
