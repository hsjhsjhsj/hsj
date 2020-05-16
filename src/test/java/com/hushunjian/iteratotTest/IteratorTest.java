package com.hushunjian.iteratotTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Maps;

public class IteratorTest {
	public static void main(String[] args) {
		
		//1.set集合元素的添加
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        System.out.println("... " + set.size());
        //2.Iterator迭代器的使用
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
        	String next = iterator.next();
        	if (StringUtils.equals(next, "b")) {
                //3.set集合元素的删除
                iterator.remove();
			}

        }
        
        System.out.println("... " + set.size());
        
        
        System.out.println("+++++++++++++1+++++++++++++");
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        Iterator<String> iterator2 = list.iterator();
        while(iterator2.hasNext()){
        	String next = iterator2.next();
        	if (StringUtils.equals(next, "3")) {
				iterator2.remove();
			}
        }
		System.out.println(list);
		System.out.println("+++++++++++++2+++++++++++++");
		List<String> strs = new ArrayList<>();
		strs.add("str1");
		strs.add("str2");
		strs.add("str3");
		strs.add("str4");
		Set<String> strSet = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			List<String> a = new ArrayList<>();
			strs.forEach(str -> a.add(str));
			strSet.add(a.toString());
		}
		System.out.println("数据条数:" + strSet.size());
		strSet.forEach(str -> {
			System.out.println("===========" + str);
		});
		System.out.println("+++++++++++++3+++++++++++++");
		
		int num = 1;
		Map<String, String> map = Maps.newHashMap();
		for (int i = 0;i <= 10; i++) {
			map.put(String.valueOf(i), String.valueOf(num++));
		}
		map.forEach((key, value) -> {
			System.out.println("key=" + key + "===>value=" + value);
		});
	}
}
