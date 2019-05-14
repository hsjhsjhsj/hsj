package com.hushunjian.listFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFilterTest {
	public static void main(String[] args) {
		List<ListFilterDTO> list = new ArrayList<>();
		list.add(new ListFilterDTO("1", "1"));
		list.add(new ListFilterDTO("2", "2"));
		list.add(new ListFilterDTO("3", "3"));
		list.add(new ListFilterDTO("4", "4"));
		list.add(new ListFilterDTO("5", "5"));
		
		List<ListFilterDTO> collect = list.stream().filter(i -> i.test(i.getName()) != null).collect(Collectors.toList());
		collect.forEach(i -> System.out.println(i));
		
	}
}
