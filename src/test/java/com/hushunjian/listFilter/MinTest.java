package com.hushunjian.listFilter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinTest {
	public static void main(String[] args) {
		List<ZonedDateTime> list = new ArrayList<>();
		list.add(null);
		Collections.max(list);
	}
}
