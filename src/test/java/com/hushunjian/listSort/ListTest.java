package com.hushunjian.listSort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
/*		list.add("1.1.1.1");
		list.add("1.1");
		list.add("1.2");
		list.add("1.4.3.1");
		list.add("1.2.1");
		list.add("1.1.1");
		list.add("1.3");
		list.add("1.4.2");
		list.add("1.3.1");*/
		
/*		list.add("1");
		list.add("1.1");
		list.add("1.2");*/
		
		list.add("1.2");
		list.add("1.1");
		
		list.forEach(s -> System.out.println(s));
		List<String> parent = parent(list);
		System.out.println("==========1==========");
		parent.forEach(par -> System.out.println(par));
		System.out.println("==========2==========");
		List<String> parentFromPaths = getParentFromPaths(list);
		parentFromPaths.forEach(par -> System.out.println(par));
	}
	
	private static List<String> parent(List<String> source){
		Collections.sort(source);
		if (source != null && source.size() > 1) {
			String a = source.get(0) + ".";
			Iterator<String> iterator = source.iterator();
			while(iterator.hasNext()){
				String next = iterator.next();
				if(next.startsWith(a)){
					iterator.remove();
				}else{
					a = next + ".";
				}
			}
			return source;
		}
		return source;
	}
	
    /**
     * 取得集合中各层级的最高父级
     * 如[1, 1.1, 1.2]   返回 [1]
     * 如[1.1, 1.2]      返回 [1.1, 1.2]
     * 如[1.1, 1.1.1, 1.2.1, 1.2.2]    返回 [1.1, 1.2.1, 1.2.2]
     * @param paths
     * @return
     */
    public static List<String> getParentFromPaths(Collection<String> paths) {
        List<String> parentPaths = new ArrayList<>();
        /**
         * 根据长度分组
         * 长度最短的可能为父级
         * 遍历其他长度的分组,判断该父级是否已在parentPaths(startsWith),不在则添加
         */
        Map<Integer, List<String>> map = paths.stream().collect(Collectors.groupingBy(String::length));
        map.keySet().stream().sorted().forEach(
                key -> {
                    if (CollectionUtils.isEmpty(parentPaths)) {
                        parentPaths.addAll(map.get(key));
                    } else {
                        List<String> tempList = map.get(key);
                        for (String path : tempList) {
                            boolean exits = false;
                            for (String topParent : parentPaths) {
                                if (path.startsWith(topParent)) {
                                    exits = true;
                                    break;
                                }
                            }
                            if (!exits) {
                                parentPaths.add(path);
                            }
                        }
                    }
            }
        );
        return parentPaths;
    }



}
