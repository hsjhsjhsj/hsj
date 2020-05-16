package com.hushunjian.StringSplitTest;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

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
		String aadd = "1";
		List<String> parentPlanTaskOutLineNums = stringSplitTest.getParentPlanTaskOutLineNum(aadd,new ArrayList<>());
		for(String parentPlanTaskOutLineNum : parentPlanTaskOutLineNums){
			System.out.println("++++");
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
		String beamBlockColde = "BN25#1-2#B6";
		String[] split2 = beamBlockColde.split("#");
		for (int i = 0 ; i< split2.length; i++){
			if(i == 0){
				System.out.println(split2[i].substring(0, split2[i].length()-2));
			}
			System.out.println(split2[i]);
		}
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-4-|||||||||||||||]");
		System.out.println("[==============================]");
		String asd = "(未区分)";
		String asd1 = "(未分区)";
		boolean containsIgnoreCase = StringUtils.containsAny(asd1, "未区分","未分区","(未区分)","(未分区)");
		if(containsIgnoreCase){
			System.out.println("包含");
		}else{
			System.out.println("不包含");
		}
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-5-|||||||||||||||]");
		System.out.println("[==============================]");
		Long l1 = 15L;
		System.out.println(String.format("%03d", l1));
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-6-|||||||||||||||]");
		System.out.println("[==============================]");
		String bimCode = "50-04.10.00";
		if (StringUtils.isNotEmpty(bimCode)){
            String[] split1 = bimCode.split("\\.");
            if (split1.length >= 2){
                bimCode = String.format("%s.%s",split1[0],split1[1]);
            }
        }
		System.out.println(bimCode);
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-7-|||||||||||||||]");
		System.out.println("[==============================]");
		String lastIndexOf = "1.1.1.1.4";
		System.out.println(lastIndexOf.lastIndexOf("."));
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-8-|||||||||||||||]");
		System.out.println("[==============================]");
		String foreignKey = "a_b_c_id";
		String substring = foreignKey.substring(0, foreignKey.indexOf("_"));
		System.out.println("substring:"+substring);
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-9-|||||||||||||||]");
		System.out.println("[==============================]");
		String foreignKey1 = "c_id";
		if (foreignKey1.contains("_")) {
			String substring2 = foreignKey1.substring(foreignKey1.indexOf("_")+1,foreignKey1.length());
			System.out.println("substring2:"+substring2);
		}
		System.out.println("[==============================]");
		System.out.println("[||||||||||||-10-|||||||||||||||]");
		System.out.println("[==============================]");
		String path = "1.2.30.4.50.6.7";
		getParentPaths(path).forEach(str -> System.out.println(str));
	}
	
	public static List<String> getParentPaths(String path) {
        List<String> parentPaths = Lists.newArrayList();
        String[] split = path.split("\\.");
        if (split.length == 0) {
            return parentPaths;
        }
        String parentPath = split[0];
        parentPaths.add(parentPath);
        for (int i = 1; i < split.length - 1; i++) {
            parentPath = String.format("%s.%s", parentPath, split[i]);
            parentPaths.add(parentPath);
        }
        return parentPaths;
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
