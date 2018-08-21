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
		//System.out.println(l1.toString());
		//System.out.println(l2.toString());
		/*List<String> res = getIntersection(l1,l2);
		System.out.println(res.toString());*/
		
		System.out.println("=============================");
		List<String> originalPersonId1 = new ArrayList<>();
		originalPersonId1.add("张三");
		originalPersonId1.add("李四");
		originalPersonId1.add("田七");
		originalPersonId1.add("赵六");
		List<String> originalPersonId2 = new ArrayList<>();
		originalPersonId2.add("张三");
		originalPersonId2.add("李四");
		originalPersonId2.add("田七");
		originalPersonId2.add("赵六");
		List<String> newPersonId1 = new ArrayList<>();
		newPersonId1.add("张三");
		newPersonId1.add("王五");
		newPersonId1.add("赵六");
		List<String> newPersonId2 = new ArrayList<>();
		newPersonId2.add("张三");
		newPersonId2.add("王五");
		newPersonId2.add("赵六");
		originalPersonId1.retainAll(newPersonId1);
		System.out.println("发送会议修改消息:"+originalPersonId1.toString());
		originalPersonId2.removeAll(newPersonId1);
		System.out.println("发送移除人员消息:"+originalPersonId2.toString());
		newPersonId2.removeAll(originalPersonId1);
		System.out.println("发送会议邀请消息:"+newPersonId2.toString());
		
		
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
