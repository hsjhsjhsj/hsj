package com.hushunjian.mapTest;

import java.util.ArrayList;
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
	}
}
