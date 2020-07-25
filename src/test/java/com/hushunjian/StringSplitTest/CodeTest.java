package com.hushunjian.StringSplitTest;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

public class CodeTest {

	
	public static void main(String[] args) {
		String code = "50-01.02.03.04";
		int level = 4;
		String pathCode = codeToPathCode1(code, 4);
		System.out.println("parentPathCode -> " + pathCode.substring(0, pathCode.lastIndexOf(".")));
		List<String> parentCodes = getAllParentPathCodes1(pathCode);
		parentCodes.forEach(parent -> System.out.println(parent));
		System.out.println("======================codeToPathCode1======================");
		for (int i = 1; i <= level; i++) {
			System.out.println(i + "==>" + codeToPathCode1(code, i));
		}
		long time1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			codeToPathCode1(code, level);
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - time1));
		System.out.println("======================codeToPathCode2======================");
		for (int i = 1; i <= level; i++) {
			System.out.println(i + "==>" + codeToPathCode2(code, i));
		}
		long time2 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			codeToPathCode2(code, level);
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - time2));
		System.out.println("======================getAllParentPathCodes======================");
		List<String> parents = getAllParentPathCodes(code, level);
		parents.forEach(parent -> System.out.println(parent));
		System.out.println("======================getAllParentPathCodes2======================");
		List<String> allParentPathCodes2 = getAllParentPathCodes2(pathCode);
		allParentPathCodes2.forEach(parent -> System.out.println(parent));
		System.out.println("======================getAllParentPathCodes1-test======================");
		List<String> allParentPathCodes1 = getAllParentPathCodes1(pathCode);
		allParentPathCodes1.forEach(parent -> System.out.println(parent));
		long time3 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			getAllParentPathCodes1(pathCode);
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - time3));
		System.out.println("======================getAllParentPathCodes2-test======================");
		List<String> allParentPathCodes22 = getAllParentPathCodes2(pathCode);
		allParentPathCodes22.forEach(parent -> System.out.println(parent));
		long time4 = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			getAllParentPathCodes2(pathCode);
		}
		System.out.println("耗时:" + (System.currentTimeMillis() - time4));
	}
	
	private static String codeToPathCode1(String code, int level) {
		Pair<String, String[]> pair = codeSplit(code);
        StringBuilder builder = new StringBuilder(StringUtils.leftPad(pair.getLeft(), 4, "0"));
        for (int i = 0; i < level; i++) {
            builder.append(StringUtils.leftPad(pair.getRight()[i], 4, "0")).append(".");
        }
        return builder.substring(0, builder.length() - 1);
	}
	
	private static String codeToPathCode2(String code, int level) {
		Pair<String, String[]> pair = codeSplit(code);
        String parentPathCode = StringUtils.leftPad(pair.getLeft(), 4, "0");
        for (int i = 0; i < level; i++) {
        	parentPathCode += StringUtils.leftPad(pair.getRight()[i], 4, "0");
        }
        return parentPathCode;
	}
	
	private static Pair<String, String[]> codeSplit(String code) {
        String[] array1 = code.split("-");
        String[] array2 = array1[1].split("\\.");
        return Pair.of(array1[0], array2);
    }
	
	private static List<String> getAllParentPathCodes(String code, int level) {
        if (level == 1) {
            return Lists.newArrayList();
        }
        Pair<String, String[]> pair = codeSplit(code);
        List<String> parentPathCodes = Lists.newArrayList();
        StringBuilder pathCode = new StringBuilder(StringUtils.leftPad(pair.getLeft(), 4, "0"));
        for (int i = 1; i < level; i++) {
            pathCode.append(StringUtils.leftPad(pair.getRight()[i - 1], 4, "0"));
            parentPathCodes.add(pathCode.toString());
        }
        return parentPathCodes;
    }
	
	private static List<String> getAllParentPathCodes1(String code) {
		String[] split = code.split("\\.");
        if (split.length == 1) {
            return Lists.newArrayList();
        }
        List<String> parentPathCodes = Lists.newArrayList(split[0]);
        String parentPathCode = split[0];
        for (int i = 1; i < split.length - 1; i++) {
            parentPathCode = String.format("%s.%s", parentPathCode, split[i]);
            parentPathCodes.add(parentPathCode);
        }
        return parentPathCodes;
    }
	
	private static List<String> getAllParentPathCodes2(String pathCode) {
		int lastIndexOf = pathCode.lastIndexOf(".");
		List<String> parentPathCodes = Lists.newArrayList();
		while (lastIndexOf > 0) {
			pathCode = pathCode.substring(0, lastIndexOf);
			parentPathCodes.add(pathCode);
			lastIndexOf = pathCode.lastIndexOf(".");
		}
		return parentPathCodes;
    }
}
