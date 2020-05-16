package com.hushunjian.path;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class PathUtil {
	
	private static final List<Character> OPTIONS = Lists.newArrayList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    private static final BigDecimal OPTIONS_SIZE = BigDecimal.valueOf(OPTIONS.size());

    public static BigDecimal toBigDecimal(String strPath) {
        char[] chars = strPath.toCharArray();
        BigDecimal result = BigDecimal.ZERO;
        for (int i = 0; i < chars.length; i++) {
            result = result.add(BigDecimal.valueOf(OPTIONS.indexOf(chars[chars.length - i - 1])).multiply(OPTIONS_SIZE.pow(i)));
        }
        return result;
    }

    public static String toStr(BigDecimal bigDecimalPath) {
        return toStr(bigDecimalPath, 3);
    }

    public static String stepPath(String strPath, int step) {
        BigDecimal bigDecimalPath = toBigDecimal(strPath);
        return toStr(bigDecimalPath.add(BigDecimal.valueOf(step)));
    }

    public static String defaultPath() {
        return toStr(BigDecimal.valueOf(4));
    }

    public static String stepPath(int step) {
        return toStr(BigDecimal.valueOf(step));
    }

    public static String nextDefaultPath(String currentPath) {
        return nextStepPath(currentPath, 4);
    }

    public static String nextStepPath(String currentPath, int step) {
        // 截取父级
        String parentPath = "";
        if (currentPath.length() > 3) {
            parentPath = currentPath.substring(0, currentPath.length() - 3);
        }
        String path = currentPath.substring(currentPath.length() - 3);
        return parentPath + stepPath(path, step);
    }

    public static String next(String currentPath, int step) {
        BigDecimal path = toBigDecimal(currentPath);
        return toStr(path.add(BigDecimal.valueOf(step)), currentPath.length());
    }

    public static String toStr(BigDecimal path, int size) {
        List<Integer> positions = Lists.newLinkedList();
        while (path.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal[] nextResult = path.divideAndRemainder(OPTIONS_SIZE);
            path = nextResult[0];
            positions.add(nextResult[1].intValue());
        }
        StringBuilder str = new StringBuilder();
        for (int i = positions.size() - 1; i >= 0; i--) {
            str.append(OPTIONS.get(positions.get(i)));
        }
        return StringUtils.leftPad(str.toString(), size, "0");
    }

    public static void main(String[] args) {
        System.out.println("==========1==========");
        System.out.println(defaultPath());
        System.out.println("==========2==========");
        System.out.println(stepPath(1));
        System.out.println("==========3==========");
        String currentPath = "001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001001";
        System.out.println(nextDefaultPath(currentPath));
        System.out.println("==========4==========");
        System.out.println(nextStepPath(currentPath, 2));
        System.out.println("==========5==========");
        System.out.println(next(currentPath, 2));
    }
}
