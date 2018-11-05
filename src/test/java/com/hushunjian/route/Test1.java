package com.hushunjian.route;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static List<String> paths = new ArrayList<String>();

	public static ArrayList<A> list = null;
	public static void main(String[] args) {
		 list = new ArrayList<A>() {
			{
				add(new A(1, 0));
				add(new A(2, 0));
				add(new A(3, 1));
				add(new A(5, 3));
				add(new A(6, 5));
				add(new A(6, 4));
				add(new A(4, 1));
				add(new A(4, 2));
				add(new A(7, 4));
			}
		};
		ArrayList<A> first = new ArrayList<A>() {
			{
				add(new A(1, 0));
				add(new A(2, 0));
			}
		};
		for(A data:first){
			String path = "";
			findAllPaths(data,path);
		}
		for(int i=0;i<paths.size();i++){
			System.out.println("路径"+i+":"+paths.get(i));
		}

	}

	public static void findAllPaths(A a, String path) {
		path += a.getId() + "->";
		if (a == null || findChild(a).size() == 0) {
			String leafPath = path;
			paths.add(leafPath);
			return;
		}

		for (int i = 0; i < findChild(a).size(); i++) {
			findAllPaths(findChild(a).get(i), path);
		}

	}
	public static List<A> findChild(A a){
		List<A> dataList = new ArrayList<A>();
		for(A data:list){
			if(data.getParentId() == a.getId()){
				dataList.add(data);
			}
		}
		return dataList;
	}

}
