package com.hushunjian.comparatorTest;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ComparatorTest {
	
	public static void main(String[] args) {
		
		Map<PoreSpan,String> map = new HashMap<>();
		map.put(new PoreSpan(1,1), "1-1");
		map.put(new PoreSpan(2,3), "2-3");
		map.put(new PoreSpan(1,3), "1-3");
		map.put(new PoreSpan(2,1), "2-1");
		map.put(new PoreSpan(1,2), "1-2");
		map.put(new PoreSpan(2,2), "2-2");
		
		Map<PoreSpan,String> resMap = sortMapByKey(map);
		for(Map.Entry<PoreSpan, String> entry : resMap.entrySet()){
			System.out.println(entry.getKey() + "==" + entry.getValue());
		}
	}
	
	public static Map<PoreSpan,String> sortMapByKey(Map<PoreSpan,String> map){
		if(map == null || map.isEmpty()){
			return null;
		}
		Map<PoreSpan,String> sortMap = new TreeMap<PoreSpan,String>(new PoreSpanComparator());
		sortMap.putAll(map);
		return sortMap;
	}
}
