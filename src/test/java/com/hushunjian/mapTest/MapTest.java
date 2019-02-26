package com.hushunjian.mapTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<String,String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		
		List<String> list = new ArrayList<>();
		list.add("2");
		list.add("3");
		
		for(String a : list){
			if(!map.containsKey(a)){
				map.remove(a);
			}
		}
		System.out.println(map);
		System.out.println("==========1==========");
		Date date1 = new Date();
		Date date2 = new Date();
		System.out.println("get方法取值:" + (date2.getTime() - date1.getTime()));
		Date date3 = new Date();
		map.forEach((key,value)->{
			if (key.equals("3")) {
				Date date4 = new Date();
				System.out.println("for循环取值:" + (date4.getTime() - date3.getTime()));
			}
		});
		System.out.println("==========1==========");
		List<MapTestDTO> list1 = new ArrayList<>();
		list1.add(new MapTestDTO("1", null, "1"));
		list1.add(new MapTestDTO("2", "1", "2"));
		list1.add(new MapTestDTO("3", "1", "3"));
		list1.add(new MapTestDTO("4", "1", "4"));
		
		list1.add(new MapTestDTO("5", null, "5"));
		list1.add(new MapTestDTO("6", "5", "6"));
		list1.add(new MapTestDTO("7", "5", "7"));
		list1.add(new MapTestDTO("8", "5", "8"));
		
		
		Map<String,List<MapTestDTO>> map1 = new HashMap<>();
		list1.forEach(dto ->{
			String parent = dto.getParent();
			if (parent != null) {
				List<MapTestDTO> dtos = map1.computeIfAbsent(parent, k -> new ArrayList<>());
				dtos.add(dto);
			}
		});
		map1.forEach((key,values)->{
			System.out.println("parent:"+key);
			values.forEach(value -> {
				System.out.println(value.getId());
			});
		});
		System.out.println("==========2==========");
		Map<String,String> map2 = new HashMap<>();
		System.out.println(map2.get(null));
		System.out.println("==========2==========");
	}
}
