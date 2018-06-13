package com.hushunjian.ListAnd;

import java.util.ArrayList;
import java.util.List;

public class ListAnd {
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		l1.add("1");
		l1.add("2");
		l1.add("3");
		List<String> l2 = new ArrayList<String>();
		l2.add("2");
		l2.add("3");
		l2.add("4");
		l1.retainAll(l2);
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		/*List<String> res = getIntersection(l1,l2);
		System.out.println(res.toString());*/
	}
	
	public static List<String> getIntersection(List<String> list1,
            List<String> list2) {
        List<String> result = new ArrayList<String>();
        for (String integer : list2) {//遍历list1
            if (list1.contains(integer)) {//如果存在这个数
                result.add(integer);//放进一个list里面，这个list就是交集
            }
        }
        return result;
    }
}
