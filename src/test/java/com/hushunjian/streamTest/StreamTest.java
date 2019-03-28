package com.hushunjian.streamTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<StreamA> a = new ArrayList<>();
		a.add(new StreamA("a","a"));
		a.add(new StreamA("a","a"));
		a.add(new StreamA("a","a"));
		a.add(new StreamA("a","a"));
		List<String> b = a.stream().map(StreamA::getName).collect(Collectors.toList());
		System.out.println(b);
		System.out.println(b.size());
		System.out.println(new HashSet<>(b).size());
	}
}
