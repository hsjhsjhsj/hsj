package com.hushunjian.plan;

import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PlanTest {

    public static List<Plan> plans = Lists.newArrayList();


    static {
        plans.add(new Plan("1", "1", null, "1", 3));
        plans.add(new Plan("2", "2", null, "2", 2));
        plans.add(new Plan("3", "3", null, "3", 1));

        plans.add(new Plan("1.1", "1.1", "1", "1.1", 1));
        plans.add(new Plan("1.2", "1.2", "1", "1.2", 2));
        plans.add(new Plan("1.3", "1.3", "1", "1.3", 3));
        plans.add(new Plan("1.10", "1.10", "1", "1.10", 20));
        plans.add(new Plan("1.20", "1.20", "1", "1.20", 10));


        plans.add(new Plan("2.1", "2.1", "2", "2.1", 1));
        plans.add(new Plan("2.2", "2.2", "2", "2.2", 2));
        plans.add(new Plan("2.3", "2.3", "2", "2.3", 3));
        plans.add(new Plan("2.10", "2.10", "2", "2.10", 10));


        plans.add(new Plan("1.1.1", "1.1.1", "1.1", "1.1.1", 1));
        plans.add(new Plan("1.1.2", "1.1.2", "1.1", "1.1.2", 2));
        plans.add(new Plan("1.1.3", "1.1.3", "1.1", "1.1.3", 3));
        plans.add(new Plan("1.1.10", "1.1.10", "1.1", "1.1.10", 10));
        plans.add(new Plan("1.1.20", "1.1.20", "1.1", "1.1.20", 20));


    }

    public static void main(String[] args) {
        System.out.println("==========1==========");
        //plans.forEach(plan -> System.out.println(plan.getOutLine()));
        System.out.println("==========2==========");
        //plans.sort(Comparator.comparing(Plan::getOutLine));
        //plans.forEach(plan -> System.out.println(plan.getOutLine()));
        System.out.println("==========3==========");
        //plans.sort(Comparator.comparing(Plan::getOutLine));
        //plans.sort(new PlanComparator());
        //plans.forEach(plan -> System.out.println(plan.getOutLine()));
        System.out.println("==========4==========");
        List<Plan> result = order(plans);
        result.forEach(i -> System.out.println(i.getOutLine()));
    }

    public static List<Plan> order(List<Plan> plans){
        List<Plan> result = Lists.newArrayList();
        Map<String, List<Plan>> parentChildrenMap = Maps.newHashMap();
        List<Plan> roots = Lists.newArrayList();
        plans.forEach(plan -> {
            if (StringUtils.isBlank(plan.getParentId())) {
                roots.add(plan);
            } else {
                parentChildrenMap.computeIfAbsent(plan.getParentId(), v -> Lists.newArrayList()).add(plan);
            }
        });
        // 顶层排序
        roots.sort(Comparator.comparing(Plan::getOrderNum));
        // 循环递归
        roots.forEach(root -> {
            result.add(root);
            addChildren(root, parentChildrenMap, result);
        });
        return result;
    }

    public static void addChildren(Plan parent, Map<String, List<Plan>> parentChildrenMap, List<Plan> result){
        List<Plan> children = parentChildrenMap.get(parent.getId());
        if (CollectionUtils.isEmpty(children)) {
            return;
        }
        // 排序
        children.sort(Comparator.comparing(Plan::getOrderNum));
        children.forEach(child -> {
            result.add(child);
            addChildren(child, parentChildrenMap, result);
        });
    }
}
