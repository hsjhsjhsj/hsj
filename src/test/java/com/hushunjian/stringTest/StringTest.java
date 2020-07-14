package com.hushunjian.stringTest;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

import net.sf.json.JSONObject;

public class StringTest {
	public static void main(String[] args) {
		String a = null;
		String b = " ss";
		System.out.println(StringUtils.isNoneBlank(a,b));
		
		String c = "B2";
		String replaceAll = c.replaceAll("^[a-zA-Z]", "");
		System.out.println(replaceAll);
		
		System.out.println("==========");
		List<String> list = new ArrayList<>();
		list.add("D1");
		list.add("G2");
		list.add("B3");
		list.add("B4");
		list.add("B5");
		list.add("B6");
		String d = list.toString();
		System.out.println(d.substring(1,d.length()-1));
		String f = "1-2-41下";
		System.out.println("++++" + f.substring(0,f.length()-1));
		String e = "1,2";
		String[] split = e.split(",");
		for (String s : split) {
			System.out.println(s);
		}
		System.out.println("==========");
		String g = " D1 ";
		System.out.println("'"+g.trim()+"'");
		System.out.println("==========1==========");
		StringBuilder message = new StringBuilder("该目录下已存在相同文件[");
		message.replace(message.length()-1, message.length(), ".");
		System.out.println(message);
		System.out.println("==========2==========");
		
		String parentProjectName = "青岛地铁一号线";
		System.out.println(StringUtils.contains(parentProjectName, "青岛") && StringUtils.contains(parentProjectName, "一号"));
		System.out.println("==========3==========");
		String beamBlock = "YY30Z-020-D3";
		String[] split2 = beamBlock.split("-");
		String a1 = split2[2];
		System.out.println(a1.substring(1, a1.length()));
		System.out.println("==========4==========");
		System.out.println(StringUtils.containsAny(beamBlock, "D10", "D12"));
		System.out.println("==========5==========");
		String a2 = " S  dd ";
		System.out.println(StringUtils.isNotBlank(a2));
		System.out.println("==========6==========");
/*		JSONObject json = JSONObject.fromObject("{id:a}");
		String string = json.getString("id");
		System.out.println(string);*/
		System.out.println("==========7==========");
		String send = "流亭机场站-结构主体施工-主体结构-站台层-混凝土中板梁";
		System.out.println(send.indexOf("-"));
		String send1 = send.substring(0, send.indexOf("-"));
		System.out.println(send1);
		String send2 = send.substring(send.indexOf("-"), send.length());
		System.out.println(send2);
		System.out.println("==========8==========");
		
		String str1 = "线路1|单位工程1|参建方1+2";
		String str2 = "线路1|单位工程2|参建方2+2";
		String str3 = "线路1|单位工程1|参建方1+2";
		String str4 = str3.replaceFirst(str1.replace("|", "\\|"), str2);
		System.out.println(str4);
		System.out.println("==========9==========");
		String source = "测试线路|郑许市域铁路工程长葛制梁场|001+测试|青岛站+测试|自建文件夹1+a";
		String regex = source.replace("|", "\\|");
		String target = "测试线路|郑许市域铁路工程长葛制梁场|001+测试|青岛站+测试|自建文件夹1+a+b";
		String name = "测试线路|郑许市域铁路工程长葛制梁场|001+测试|青岛站+测试|自建文件夹1+a";
		name = target + name.substring(source.length(), name.length());
		System.out.println(name);
		String path1 = "1.1";
		String path2 = "1.2.1";
		System.out.println(path1.compareTo(path2));
		System.out.println("==========10==========");
		String name1 = "aaaa";
		String name2 = "aaaa-bbbb";
		String substring = name2.substring(name1.length());
		System.out.println(substring);
		System.out.println("==========11==========");
		String oldOutLine = "1.2.1.1.2.1";
		String reg = "1.2.1";
		String replacement = "1.3.1";
		String replaceFirst = oldOutLine.replaceFirst(reg, replacement);
		System.out.println(replaceFirst);
		System.out.println("==========12==========");
		String outLineStr = "1.2.1.1";
		int indexOf = outLineStr.indexOf(".", 1);
		System.out.println(indexOf);
		System.out.println(outLineStr.substring(indexOf));
		System.out.println("==========13==========");
		String transformOutLine = transformOutLine(outLineStr);
		System.out.println(transformOutLine);
		System.out.println("==========14==========");
		String path = "1.1.3";
		System.out.println(path.split("\\.").length);
		System.out.println("==========15==========");
		Integer value = 78161;
		System.out.println(String.format("DK%02d+", value));
		System.out.println("==========16==========");
		System.out.println("01114".substring(0, 4));
		System.out.println("==========17==========");
		List<String> parentPaths = getParentPath("01020304");
		parentPaths.forEach(str -> System.out.println(str));
		System.out.println("==========18==========");
		String in = "1-1-2";
		System.out.println(in.substring(0, in.indexOf("-")));
		System.out.println(in.substring(in.indexOf("-") + 1));
		System.out.println("==========19==========");
		System.out.println(path.substring(path.lastIndexOf(".") + 1));
		System.out.println("==========20==========");
		String outLine = "012036";
		System.out.println(StringUtils.startsWith(outLine, "01203"));
		System.out.println("==========21==========");
		for (int i = 0; i < 10; i++) {
			System.out.println(i + "==>" + System.nanoTime());
		}
		System.out.println("==========22==========");
		System.out.println(StringUtils.center("", 4, "0"));
		System.out.println("==========23==========");
		System.out.println(String.format("%%%s%%", "555"));
		StringUtils.difference(str1, str2);
		System.out.println("==========24==========");
		String code = "50-01.10.10.01";
		System.out.println(handleCode(code, 1));
		String r = "\\d\\d-\\d\\d.\\d\\d.\\d\\d.\\d\\d";
		System.out.println(code.matches(r));
		System.out.println("==========25==========");
		long start1 = System.currentTimeMillis();
		//System.out.println(Double.valueOf(code.replaceAll("-", "").replace(".", "")));
		for(int i = 0;i<1000000;i++) {
			String code1 = code;
			//Double.valueOf(code1.replaceAll("-", "").replace(".", ""));
		}
		System.out.println("replace耗时: " + (System.currentTimeMillis() - start1));
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
		long start2 = System.currentTimeMillis();
		System.out.println(Double.valueOf(p.matcher(code).replaceAll("").trim()));
		for(int i = 0;i<1000000;i++) {
			String code1 = code;
			Double.valueOf(p.matcher(code1).replaceAll("").trim());
		}
		System.out.println("正则耗时: " + (System.currentTimeMillis() - start2));
		System.out.println("==========26==========");
		
	}
	
	public static String handleCode(String code, int level) {
        String[] split = code.split("\\.");
        if (split.length == level) {
            return code;
        }
        return StringUtils.join(Arrays.asList(split).subList(0, level), ".");
    }
	
	public static List<String> getParentPath(String currentPath) {
		String parentPath = currentPath;
		List<String> parentPaths = new ArrayList<>();
        for (int i = 1, len = currentPath.length() / 2; i < len; i++) {
            parentPath = parentPath.substring(0, parentPath.length() - 2);
            parentPaths.add(parentPath);
        }
        return parentPaths;
	}
	
	public static String transformOutLine(String outLine){
		String[] split = outLine.split("\\.");
		StringBuffer transform = new StringBuffer();
		for (String s : split) {
			transform.append(String.format("%08d", Integer.valueOf(s))).append(".");
		}
		return transform.substring(0, transform.length() - 1);
	}
}
