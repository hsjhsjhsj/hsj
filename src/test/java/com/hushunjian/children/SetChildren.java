package com.hushunjian.children;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class SetChildren {
	private String name;
	
	private List<SetChildren> children = new ArrayList<>();
	
	public static void main(String[] args) {
		List<IsParent> list = new ArrayList<>();
		list.add(new IsParent("混凝土中隔墙", "底层", "已分区", "顶板"));
		list.add(new IsParent("混凝土中隔墙", "底层", "已分区", "底板"));
		list.add(new IsParent("混凝土中隔墙", "底层", "未分区", "顶板"));
		list.add(new IsParent("混凝土中隔墙", "顶层", "已分区", "底板"));
		list.add(new IsParent("混凝土中隔墙", "顶层", "已分区", "底板"));
		list.add(new IsParent("混凝土中隔墙", "顶层", "未分区", "顶板"));
		list.add(new IsParent("混凝土侧墙", "顶层", "未分区", "底板"));
		List<A> as = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			A a1 = new A();
			a1.setName(list.get(i).getClassifyCodeName());
			a1.setParent(null);
			A a2 = new A();
			a2.setName(list.get(i).getFloorName());
			a2.setParent(list.get(i).getClassifyCodeName());
			A a3 = new A();
			a3.setName(list.get(i).getSubregion());
			a3.setParent(list.get(i).getFloorName());
			A a4 = new A();
			a4.setName(list.get(i).getCategory());
			a4.setParent(list.get(i).getSubregion());
			as.add(a1);
			as.add(a2);
			as.add(a3);
			as.add(a4);
		}
		Set<A> ass = new HashSet<>(as);
		System.out.println(ass);
	}
}
