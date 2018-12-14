package com.hushunjian.comparatorTest;

import java.util.Comparator;

public class PoreSpanComparator implements Comparator<PoreSpan> {

	@Override
	public int compare(PoreSpan o1, PoreSpan o2) {
		int compareTo = o1.getA().compareTo(o2.getA());
		if (compareTo == 0) {
			compareTo = o1.getB().compareTo(o2.getB());
		}
		return compareTo;
	}

}
