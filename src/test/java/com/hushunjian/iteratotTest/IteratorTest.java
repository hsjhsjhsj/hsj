package com.hushunjian.iteratotTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

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
	}
}
