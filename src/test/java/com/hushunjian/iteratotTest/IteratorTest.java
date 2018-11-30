package com.hushunjian.iteratotTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorTest {
	public static void main(String[] args) {
		
		//1.set集合元素的添加
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        //2.Iterator迭代器的使用
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
                //3.set集合元素的删除
                iterator.remove();
        }
        
        System.out.println("... " + set.size());
		
	}
}
