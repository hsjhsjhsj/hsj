package com.hushunjian.tree;

import java.util.Comparator;

public class OutLineNumComparator implements Comparator<Tree> {

	@Override
	public int compare(Tree o1, Tree o2) {
		return -o1.getOutLineNum().compareTo(o2.getOutLineNum());
	}

}
