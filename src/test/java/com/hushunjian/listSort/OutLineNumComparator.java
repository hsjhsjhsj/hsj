package com.hushunjian.listSort;

import java.util.Comparator;

public class OutLineNumComparator implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		String[] split1 = arg0.split("\\.");
		String[] split2 = arg1.split("\\.");
		int compareTo = 0;
		compareTo = compare(split1, split2);
		return compareTo;
	}

	/**
	 * @param arry1
	 * @param arry2
	 * @return
	 */
	private int compare(String[] arry1, String[] arry2) {
		int compareTo = 0;
		int minLength = arry1.length;
		if (arry1.length > arry2.length) {
			minLength = arry2.length;
		}
		for (int i = 0; i < minLength; i++) {
			if (Integer.valueOf(arry1[i]) < Integer.valueOf(arry2[i])) {
				compareTo = -1;
				break;
			} else if (Integer.valueOf(arry1[i]) > Integer.valueOf(arry2[i])) {
				compareTo = 1;
				break;
			} else {
				if (i == minLength - 1) {
					if (arry1.length > arry2.length) {
						compareTo = 1;
					} else if (arry1.length < arry2.length) {
						compareTo = -1;
					}
				}
			}
		}
		return compareTo;
	}

}
