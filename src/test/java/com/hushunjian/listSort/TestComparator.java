package com.hushunjian.listSort;

import java.util.Comparator;

public class TestComparator implements Comparator<TestDTO> {

	@Override
	public int compare(TestDTO o1, TestDTO o2) {
		int compareTo = o1.getPath().compareTo(o2.getPath());
		if (compareTo == 0) {
			compareTo = -(o1.getTime().compareTo(o2.getTime()));
		}
		return compareTo;
	}

}
