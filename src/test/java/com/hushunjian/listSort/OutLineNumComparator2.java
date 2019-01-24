package com.hushunjian.listSort;

import java.util.Comparator;

public class OutLineNumComparator2 implements Comparator<ListOutLineNum> {

	@Override
	public int compare(ListOutLineNum arg0, ListOutLineNum arg1) {
		String[] split1 = arg0.getOutLineNum().split("\\.");
		String[] split2 = arg1.getOutLineNum().split("\\.");
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
