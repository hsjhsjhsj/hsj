package com.hushunjian.outLineNum;

import java.util.ArrayList;
import java.util.List;

public class OutLineNumTest {
	public static void main(String[] args) {
		List<OutLineNumTestDTO> list = new ArrayList<>();
		list.sort(new OutLineNumComparator());
	}
}
