package com.hushunjian.listSort;

import java.time.ZonedDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class TestDTOSort {

	public static void main(String[] args) {
		List<TestDTO> list = Lists.newArrayList();
		list.add(new TestDTO("001.001", ZonedDateTime.now().plusDays(10)));
		list.add(new TestDTO("001.001.001.002", ZonedDateTime.now().plusDays(2)));
		list.add(new TestDTO("001.001.001", ZonedDateTime.now().plusDays(2)));
		list.add(new TestDTO("001.001", ZonedDateTime.now().plusDays(2)));
		list.add(new TestDTO("001.001.001.001", ZonedDateTime.now().plusDays(1)));
		list.add(new TestDTO("001.001.001", ZonedDateTime.now().plusDays(3)));
		list.add(new TestDTO("001.001.001", ZonedDateTime.now().plusDays(1)));
		list.add(new TestDTO("001.001", ZonedDateTime.now().plusDays(30)));
		list.add(new TestDTO("001.001.001.003", ZonedDateTime.now().plusDays(3)));
		list.add(new TestDTO("001.001.001.003", ZonedDateTime.now().plusDays(2)));
		
		System.out.println("==============================================1");
		list.sort(Comparator.comparing(TestDTO::getPath));
		list.forEach(l -> System.out.println(l.getPath() + "->" + l.getTime()));
		System.out.println("==============================================1");
		System.out.println();
		System.out.println();
		System.out.println("==============================================2");
		list.sort(Comparator.comparing(TestDTO::getPath).thenComparing(TestDTO::getTime).reversed());
		list.forEach(l -> System.out.println(l.getPath() + "->" + l.getTime()));
		System.out.println("==============================================2");
		System.out.println();
		System.out.println();
		System.out.println("==============================================3");
		list.sort(Comparator.comparing(TestDTO::getPath).reversed().thenComparing(TestDTO::getTime).reversed());
		list.forEach(l -> System.out.println(l.getPath() + "->" + l.getTime()));
		System.out.println("==============================================3");
		System.out.println();
		System.out.println();
		System.out.println("==============================================4");
		list.sort(Comparator.comparing(TestDTO::getPath).thenComparing(TestDTO::getTime));
		list.forEach(l -> System.out.println(l.getPath() + "->" + l.getTime()));
		System.out.println("==============================================4");
		System.out.println();
		System.out.println();
		System.out.println("==============================================5");
		list.sort(new TestComparator());
		list.forEach(l -> System.out.println(l.getPath() + "->" + l.getTime()));
		System.out.println("==============================================5");
		System.out.println();
		System.out.println();
		System.out.println("==============================================6");
		list = list.stream().sorted(Comparator.comparing(TestDTO::getPath).thenComparing(TestDTO::getTime).reversed()).collect(Collectors.toList());
		list.forEach(l -> System.out.println(l.getPath() + "->" + l.getTime()));
		System.out.println("==============================================6");
		System.out.println();
		System.out.println();
	}
}
