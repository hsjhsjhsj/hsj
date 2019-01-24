package com.hushunjian.CollectionTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTest {
	public static void main(String[] args) {
		List<String> aa = Collections.singletonList("aa");
		aa.add("bb");
		System.out.println(aa);
		System.out.println("=================================");
		List<String> savedImportantTasks = Arrays.asList("dd");
		savedImportantTasks.add("a");
		
	}
}
