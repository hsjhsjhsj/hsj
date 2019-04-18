package com.hushunjian.iteratotTest;

import java.util.HashSet;
import java.util.Iterator;
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
		
	}
}
