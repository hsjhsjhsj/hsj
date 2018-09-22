package com.hushunjian.listFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.mysql.jdbc.IterateBlock;

import lombok.Data;

@Data
public class ListFilter2 {
	private String id;
	
	private String parent;
	
	private String name;
	
	private List<ListFilter2> child = new ArrayList<>();
	

	private static final List<ListFilter2> list = new ArrayList<>();
	
	static{
		/*list.add(new ListFilter2("A",null,""));
		list.add(new ListFilter2("A1", "A",""));
		list.add(new ListFilter2("A2", "A",""));
		list.add(new ListFilter2("A3", "A",""));
		list.add(new ListFilter2("A4", "A",""));
		list.add(new ListFilter2("A11", "A1",""));
		list.add(new ListFilter2("A12", "A1",""));
		list.add(new ListFilter2("A13", "A1",""));
		list.add(new ListFilter2("A14", "A1",""));
		list.add(new ListFilter2("A21", "A2",""));
		list.add(new ListFilter2("A22", "A2",""));
		list.add(new ListFilter2("A23", "A2",""));
		list.add(new ListFilter2("A24", "A2",""));
		list.add(new ListFilter2("A111", "A11",""));
		list.add(new ListFilter2("A1111", "A111",""));
		
		list.add(new ListFilter2("B",null,""));
		list.add(new ListFilter2("B1", "B",""));
		list.add(new ListFilter2("B2", "B",""));
		list.add(new ListFilter2("B3", "B",""));
		list.add(new ListFilter2("B4", "B",""));
		list.add(new ListFilter2("B11", "B1",""));
		list.add(new ListFilter2("B12", "B1",""));
		list.add(new ListFilter2("B13", "B1",""));
		list.add(new ListFilter2("B14", "B1",""));
		list.add(new ListFilter2("B21", "B2",""));
		list.add(new ListFilter2("B22", "B2",""));
		list.add(new ListFilter2("B23", "B2",""));
		list.add(new ListFilter2("B24", "B2",""));*/
	}
	
	
	public static void main(String[] args) {
		System.out.println(list.size());
		List<String> aa = list.stream().map(ListFilter2::getId).collect(Collectors.toList());
		System.out.println(aa.size());
		/*List<ListFilter2> top1 = list.stream().filter(l -> StringUtils.isBlank(l.getParent())).collect(Collectors.toList());
		top1.forEach(l -> {
			System.out.println("父级" + l.getId());
			List<ListFilter2> collect = list.stream().filter(l1 -> StringUtils.equals(l.getId(), l1.getParent())).collect(Collectors.toList());
			collect.forEach(a -> {
				System.out.println("父级" + l.getId() + "的子级" + a.getId());
			});
		});
		System.out.println("===============1===============");
		top1.forEach(l -> {
			List<ListFilter2> collect = list.stream().filter(l1 -> StringUtils.equals(l.getId(), l1.getParent())).collect(Collectors.toList());
			getChild(l.getId(),collect);
		});
		System.out.println("===============2===============");
		List<ListFilter2> aa = new ArrayList<>();
		for(int i =1;i<=top1.size();i++){
			getChild(String.valueOf(i),top1.get(i-1),aa);
		}
		aa.forEach(a -> {
			System.out.println(a.getId()+"----"+a.getName());
		});*/
	}
	
	public static void getChild(String id,List<ListFilter2> chilids){
		if (CollectionUtils.isEmpty(chilids)) {
			return;
		}
		System.out.println("父级==" + id);
		chilids.forEach(a -> {
			List<ListFilter2> collect = list.stream().filter(l1 -> StringUtils.equals(a.getId(), l1.getParent())).collect(Collectors.toList());
			getChild(a.getId(), collect);
		});
	}
	
	public static void getChild(String id){
		Map map = new HashMap();
		List<ListFilter2> collect = list.stream().filter(l1 -> StringUtils.equals(id, l1.getParent())).collect(Collectors.toList());
		map.put(id, collect);
		collect.forEach(a -> {
			List<ListFilter2> b = list.stream().filter(l1 -> StringUtils.equals(a.getParent(), l1.getParent())).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(b)) {
				
			}
		});
	}
	
	public static void multipleTree(List<ListFilter2> list){
		
	}
	
	
	public static List<ListFilter2> getChild(String order,ListFilter2 listFilter,List<ListFilter2> aa){
		List<ListFilter2> children = list.stream().filter(l1 -> StringUtils.equals(listFilter.getId(),l1.getParent())).collect(Collectors.toList());
		listFilter.setName(order);
		aa.add(listFilter);
		if (CollectionUtils.isEmpty(children)) {
			return aa;
		}
		for(int i =1;i<=children.size();i++){
			String temp = order + "." + i;
			getChild(temp,children.get(i-1),aa);
		}
		return aa;
	}

	public ListFilter2(String id, String parent, String name) {
		super();
		this.id = id;
		this.parent = parent;
		this.name = name;
	}
}
