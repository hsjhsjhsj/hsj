package com.hushunjian.user;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserTest {
	
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		User u1 = new User("1","openId1");
		list.add(u1);
		User u2 = new User("1","openId1");
		list.add(u2);
		User u3 = new User("2","openId1");
		list.add(u3);
		User u4 = new User("2","openId1");
		list.add(u4);
		list = list.stream().distinct().collect(Collectors.toList());
		list.forEach(l -> System.out.println(l));
	}
}
