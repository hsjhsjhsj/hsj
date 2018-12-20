package com.hushunjian.tree;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TreeTest {

	private final static List<Tree> list = new ArrayList<>();

	static {
		list.add(new Tree(1, "单位工程", null, BigDecimal.TEN, "1"));
		list.add(new Tree(2, "子单位工程", 1, BigDecimal.TEN, "1.1"));
		list.add(new Tree(3, "分部工程", 2, BigDecimal.TEN, "1.1.1"));
		list.add(new Tree(4, "楼层1", 3, BigDecimal.TEN, "1.1.1.1"));
		list.add(new Tree(5, "分区1", 4, BigDecimal.TEN, "1.1.1.1.1"));
		list.add(new Tree(7, "构件组1", 5, BigDecimal.ONE, "1.1.1.1.1.1"));
		list.add(new Tree(8, "构件组2", 5, BigDecimal.ONE, "1.1.1.1.1.2"));
		list.add(new Tree(9, "构件组3", 5, BigDecimal.ONE, "1.1.1.1.1.3"));
		list.add(new Tree(6, "分区2", 4, BigDecimal.TEN, "1.1.1.1.2"));
		list.add(new Tree(10, "构件组1", 6, BigDecimal.ONE, "1.1.1.1.2.1"));
		list.add(new Tree(11, "构件组2", 6, BigDecimal.ONE, "1.1.1.1.2.2"));
		list.add(new Tree(12, "构件组3", 6, BigDecimal.ONE, "1.1.1.1.2.3"));
		list.add(new Tree(13, "楼层2", 3, BigDecimal.TEN, "1.1.1.2"));
		list.add(new Tree(14, "分区1", 13, BigDecimal.TEN, "1.1.1.2.1"));
		list.add(new Tree(15, "构件组1", 14, BigDecimal.ONE, "1.1.1.2.1.1"));
		list.add(new Tree(16, "构件组2", 14, BigDecimal.ONE, "1.1.1.2.1.2"));
		list.add(new Tree(17, "构件组3", 14, BigDecimal.ONE, "1.1.1.2.1.3"));
	}

	public static void main(String[] args) {
		Map<Tree, List<Tree>> map = toMap(list);
		List<Tree> keys = map.keySet().stream().sorted(Comparator.comparing(Tree::getOutLineNum).reversed())
				.collect(Collectors.toList());
		for (Tree key : keys) {
			System.out.println("计算前父级数据:" + key.getDesignNumber());
			List<Tree> keyValues = map.get(key);
			BigDecimal designNumber = BigDecimal.ZERO;
			for (Tree tree : keyValues) {
				designNumber = designNumber.add(tree.getDesignNumber());
			}
			key.setDesignNumber(designNumber);
			System.out.println("计算后父级数据:" + key.getDesignNumber());
		}

	}

	/*
	 * 将list组装成key为父对象,value为子集对象集合的map
	 */
	public static Map<Tree, List<Tree>> toMap(List<Tree> list) {
		Map<Tree, List<Tree>> map = new HashMap<>();
		Map<Integer, Tree> collect = list.stream().collect(Collectors.toMap(Tree::getId, tree -> tree));
		list.forEach(tree -> {
			Integer parent = tree.getParent();
			if (parent == null) {
				// 最顶级元素
				map.put(tree, new ArrayList<>());
			} else {
				Tree parentTree = collect.get(parent);
				if (parentTree != null) {
					if (map.containsKey(parentTree)) {
						map.get(parentTree).add(tree);
					} else {
						map.put(parentTree, new ArrayList<>(Arrays.asList(tree)));
					}
				}
			}
		});
		return sortByKeyOutLineNum(map);
	}

	/**
	 * 按照outLineNum长度排序
	 * 
	 * @param map
	 * @return
	 */
	public static Map<Tree, List<Tree>> sortByKeyOutLineNum(Map<Tree, List<Tree>> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<Tree, List<Tree>> sortMap = new TreeMap<Tree, List<Tree>>(new OutLineNumComparator());
		sortMap.putAll(map);
		return sortMap;
	}
}
