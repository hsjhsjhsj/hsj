package com.hushunjian.listSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		order.add("张三3");
		order.add("张三2");
		order.add("张三5");
		order.add("张三4");
		
		List<User> users = new ArrayList<User>();
		users.add(new User("张三1",11,1L));
		users.add(new User("张三3",13,3L));
		users.add(new User("张三1",11,1L));
		users.add(new User("张三2",12,2L));
		users.add(new User("张三5",15,5L));
		users.add(new User("张三4",14,4L));
		//users.sort(Comparator.comparing(User::getUserName));
		//System.out.println(users);
		setListOrde(order,users);
		System.out.println("=======================");
		System.out.println("|||||||||||1|||||||||||");
		System.out.println("=======================");
		
		List<String> partitions = new ArrayList<>();
		partitions.add("第1段");
		partitions.add("第2段");
		List<String> partitionOrder = new ArrayList<>();
		partitionOrder.add("第2段");
		partitionOrder.add("第1段");
		//setListOrder1(partitions,partitionOrder);
		List<String> orderByTarget = orderByTarget(partitions,partitionOrder);
		System.out.println(orderByTarget);
		System.out.println("=======================");
		System.out.println("|||||||||||2|||||||||||");
		System.out.println("=======================");
		List<ListDTO> list1 = new ArrayList<>();
		list1.add(new ListDTO("001"));
		list1.add(new ListDTO("002"));
		list1.add(new ListDTO("011"));
		list1.add(new ListDTO("021"));
		list1.add(new ListDTO("101"));
		list1.add(new ListDTO("003"));
		list1.sort(Comparator.comparing(ListDTO::getBeamSpanNum));
		System.out.println(list1);
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
	
	public static void setListOrder1(List<String> source, List<String> target) {
		System.out.println("排列后的数据：");
		System.out.println(source);
		Collections.sort(source, ((o1, o2) -> {
			int io1 = target.indexOf(o1);
			int io2 = target.indexOf(o2);
			return io1 - io2;
		}));
		System.out.println("规则数据：");
		target.forEach(t -> System.out.print(t + " "));
		System.out.println();
		System.out.println("排列后的数据：");
		System.out.println(source);
	}
	
	 private static List<String> orderByTarget(List<String> source,List<String> target){
	        Collections.sort(source, ((o1, o2) -> {
	            int io1 = target.indexOf(o1);
	            int io2 = target.indexOf(o2);
	            return io1 - io2;
	        }));
	        return source;
	    }
}
