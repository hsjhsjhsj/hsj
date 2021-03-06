package com.hushunjian.path;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

public class PathTest {
    private static final List<Character> OPTIONS = Lists.newArrayList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    private static final int OPTIONS_SIZE = OPTIONS.size();
    
    
    public static void main(String[] args) {
        System.out.println("候选项个数:");
        System.out.println(OPTIONS.size());
        String outLine = "B";
        char[] chars = outLine.toCharArray();
        for (char option : chars) {
            System.out.println(option + "");
        }
        System.out.println(outLineStrToDouble(outLine));
        System.out.println("==========1==========");
        System.out.println(Math.pow(2, 2));
        System.out.println("==========2==========");
        System.out.println(outLineDoubleToStr(1, 9d));
        System.out.println("==========3==========");
        System.out.println(outLineStrToDouble("0AB"));
        System.out.println(outLineDoubleToStr(BigDecimal.valueOf(371)));
        System.out.println(outLineDoubleToStr(1, 371d));
        System.out.println("==========4==========");
        String path = "004005";
        System.out.println(path.substring(0, path.length() - 3));
        System.out.println(path.substring(path.length() - 3));
        System.out.println("==========5==========");
        System.out.println(Double.MAX_VALUE);
        System.out.println(outLineDoubleToStr(BigDecimal.valueOf(Double.MAX_VALUE)));
    }

    public static Double outLineStrToDouble(String outLine) {
        char[] chars = outLine.toCharArray();
        double result = 0d;
        for (int i = 0; i < chars.length; i++) {
            result += (OPTIONS.indexOf(chars[chars.length - i - 1])) * Math.pow(OPTIONS.size(), i);
        }
        return result;
    }

    public static String outLineDoubleToStr(Integer step, Double current) {
        BigDecimal next = BigDecimal.valueOf(current + step);
        return outLineDoubleToStr(next);
    }
    
    public static String outLineDoubleToStr(BigDecimal outLine) {
        List<Integer> positions = Lists.newLinkedList();
        while (outLine.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal[] nextResult = outLine.divideAndRemainder(BigDecimal.valueOf(OPTIONS.size()));
            outLine = nextResult[0];
            positions.add(nextResult[1].intValue());
        }
        StringBuilder str = new StringBuilder();
        for (int i = positions.size() - 1; i >= 0; i--) {
            str = str.append(OPTIONS.get(positions.get(i)));
        }
        return StringUtils.leftPad(str.toString(), 3, "0");
    }
    
    public static String next(String path, int step) {
        char[] chars = path.toCharArray();
        char[] result = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            int remainder = step % OPTIONS_SIZE;
            int merchant = step / OPTIONS_SIZE;
            int index = OPTIONS.indexOf(chars[i]);
            int nextCharIndex = index + remainder;
            if (nextCharIndex >= OPTIONS_SIZE) {
                merchant = merchant + nextCharIndex / OPTIONS_SIZE;
                nextCharIndex = nextCharIndex % OPTIONS_SIZE;
            }
            result[i] = OPTIONS.get(nextCharIndex);
            step = merchant;
        }
        return String.valueOf(result);
    }
}
