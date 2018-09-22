package com.hushunjian.listSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.hushunjian.testEquest.User;

public class ListSort {
	public static void main(String[] args) {
		List<Integer> orderRegulation = new ArrayList<Integer>();
		orderRegulation.add(1);
		orderRegulation.add(2);
		orderRegulation.add(3);
		
		List<Integer> targetList = new ArrayList<Integer>();
		targetList.add(1);
		targetList.add(3);
		targetList.add(2);
		
		setListOrder(orderRegulation, targetList);
		System.out.println("=================================");
		System.out.println("|||||||||||||||||||||||||||||||||");
		System.out.println("=================================");
		
		List<String> order = new ArrayList<String>();
		order.add("张三1");
		order.add("张三2");
		order.add("张三3");
		order.add("张三4");
		order.add("张三5");
		
		List<User> users = new ArrayList<User>();
		users.add(new User("张三1",11,1L));
		users.add(new User("张三3",13,3L));
		users.add(new User("张三2",12,2L));
		users.add(new User("张三5",15,5L));
		users.add(new User("张三4",14,4L));
		
		setListOrde(order,users);
	}
	
	public static void setListOrde(List<String> orderRegulation, List<User> targetList) {
		Collections.sort(targetList, ((o1, o2) -> {
			int io1 = orderRegulation.indexOf(o1.getUserName());
			int io2 = orderRegulation.indexOf(o2.getUserName());
			return io1 - io2;
		}));
		System.out.println("规则数据：");
		orderRegulation.forEach(t -> System.out.print(t + " "));
		System.out.println();
		System.out.println("排列后的数据：");
		targetList.forEach(t -> System.out.print(t + " "));
	}
	

	public static void setListOrder(List<Integer> orderRegulation, List<Integer> targetList) {
		Collections.sort(targetList, ((o1, o2) -> {
			int io1 = orderRegulation.indexOf(o1);
			int io2 = orderRegulation.indexOf(o2);
			return io1 - io2;
		}));
		System.out.println("规则数据：");
		orderRegulation.forEach(t -> System.out.print(t + " "));
		System.out.println();
		System.out.println("排列后的数据：");
		targetList.forEach(t -> System.out.print(t + " "));
	}
}
