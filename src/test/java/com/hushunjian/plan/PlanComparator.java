package com.hushunjian.plan;

import org.apache.commons.lang.StringUtils;

import java.util.Comparator;

public class PlanComparator implements Comparator<Plan> {
    @Override
    public int compare(Plan o1, Plan o2) {
        int compare = o1.getOutLine().compareTo(o2.getOutLine());
        if (StringUtils.equals(o1.getParentId(), o2.getParentId())) {
            compare = o1.getOrderNum() - o2.getOrderNum();
        }
        return compare;
    }
}
