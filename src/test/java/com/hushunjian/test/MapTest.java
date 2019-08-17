package com.hushunjian.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.hushunjian.dataSetName.BimModelInfo;

public class MapTest {
	public static void main(String[] args) {
		BimModelInfo info = new BimModelInfo("dataSetName","bimCode","bimCodeName","partition");
		
		Map<String, BimModelInfo> map1 = new HashMap<>();
		map1.put("1", info);
		Map<String, BimModelInfo> map2 = new HashMap<>();
		map2.put("1", info);
		BimModelInfo result1 = map1.get("1");
		result1.setBimCode("test1");
		BimModelInfo result2 = map1.get("1");
		System.out.println(result2.getBimCode());
		
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.forEach(s -> {
			if (StringUtils.equals(s, "1")) {
				return;
			}
			System.out.println(s);
		});
	}
}
