package com.hushunjian.listFilter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.Data;

@Data
public class ListFilter {
	private String id;
	
	private String parent;

	private static final List<ListFilter> list = new ArrayList<>();
	
	static{
		list.add(new ListFilter("A",null));
		list.add(new ListFilter("A1", "A"));
		list.add(new ListFilter("A2", "A"));
		list.add(new ListFilter("A3", "A"));
		list.add(new ListFilter("A4", "A"));
		list.add(new ListFilter("A11", "A1"));
		list.add(new ListFilter("A12", "A1"));
		list.add(new ListFilter("A13", "A1"));
		list.add(new ListFilter("A14", "A1"));
		list.add(new ListFilter("A21", "A2"));
		list.add(new ListFilter("A22", "A2"));
		list.add(new ListFilter("A23", "A2"));
		list.add(new ListFilter("A24", "A2"));
		list.add(new ListFilter("A241", "A24"));
		list.add(new ListFilter("A231", "A23"));
		list.add(new ListFilter("A232", "A23"));
		
/*		list.add(new ListFilter("B",null));
		list.add(new ListFilter("B1", "B"));
		list.add(new ListFilter("B2", "B"));
		list.add(new ListFilter("B3", "B"));
		list.add(new ListFilter("B4", "B"));
		list.add(new ListFilter("B11", "B1"));
		list.add(new ListFilter("B12", "B1"));
		list.add(new ListFilter("B13", "B1"));
		list.add(new ListFilter("B14", "B1"));
		list.add(new ListFilter("B21", "B2"));
		list.add(new ListFilter("B22", "B2"));
		list.add(new ListFilter("B23", "B2"));
		list.add(new ListFilter("B24", "B2"));*/
	}
	
	
	public static void main(String[] args) {
		List<ListFilter> top1 = list.stream().filter(l -> StringUtils.isBlank(l.getParent())).collect(Collectors.toList());
/*		top1.forEach(l -> {
			System.out.println("父级" + l.getId());
			List<ListFilter> collect = list.stream().filter(l1 -> StringUtils.equals(l.getId(), l1.getParent())).collect(Collectors.toList());
			collect.forEach(a -> {
				System.out.println("父级" + l.getId() + "的子级" + a.getId());
			});
		});
		System.out.println("===============1===============");
		top1.forEach(l -> {
			List<ListFilter> collect = list.stream().filter(l1 -> StringUtils.equals(l.getId(), l1.getParent())).collect(Collectors.toList());
			getChild(l.getId(),collect);
		});*/
		System.out.println("===============2===============");
		List<ListFilter> aa = new ArrayList<>();
		top1.forEach(l -> {
			getChild(l,aa);
		});
		aa.forEach(a -> System.out.println(a.getId()));
	}
	
	public static void getChild(String id,List<ListFilter> chilids){
		if (CollectionUtils.isEmpty(chilids)) {
			return;
		}
		System.out.println("父级==" + id);
		chilids.forEach(a -> {
			List<ListFilter> collect = list.stream().filter(l1 -> StringUtils.equals(a.getId(), l1.getParent())).collect(Collectors.toList());
			getChild(a.getId(), collect);
		});
	}
	
	public static void getChild(String id){
		Map map = new HashMap();
		List<ListFilter> collect = list.stream().filter(l1 -> StringUtils.equals(id, l1.getParent())).collect(Collectors.toList());
		map.put(id, collect);
		collect.forEach(a -> {
			List<ListFilter> b = list.stream().filter(l1 -> StringUtils.equals(a.getParent(), l1.getParent())).collect(Collectors.toList());
			if (CollectionUtils.isEmpty(b)) {
				
			}
		});
	}
	
	public static List<ListFilter> getChild(ListFilter listFilter, List<ListFilter> aa){
		List<ListFilter> childs = list.stream().filter(l -> StringUtils.equals(listFilter.getId(), l.getParent())).collect(Collectors.toList());
		aa.add(listFilter);
		if (CollectionUtils.isEmpty(childs)) {
			return aa;
		}
		childs.forEach(l ->{
			getChild(l,aa);
		});
		return aa;
	}
	

	public ListFilter(String id, String parent) {
		super();
		this.id = id;
		this.parent = parent;
	}
}
