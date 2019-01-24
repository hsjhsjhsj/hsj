package com.hushunjian.outLineNum;

public class OutLineNumComparatorUtil {
	/**
	 * @param arry1
	 * @param arry2
	 * @return
	 */
	private static int compare(String s1, String s2) {
		if(s1 == null || s2 == null){
			return 0;
		}
		String[] arry1 = s1.split("\\.");
		String[] arry2 = s2.split("\\.");
		int minLength = arry1.length;
		if (arry1.length > arry2.length) {
			minLength = arry2.length;
		}
		for (int i = 0; i < minLength; i++) {
			int compareTo = Integer.valueOf(arry1[i]) - Integer.valueOf(arry2[i]);
			if (compareTo != 0) {
				return compareTo;
			}
		}
		return arry1.length - arry2.length;
	}
}
