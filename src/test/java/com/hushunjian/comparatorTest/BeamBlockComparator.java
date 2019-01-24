package com.hushunjian.comparatorTest;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * 梁节按照梁跨大小进行排序
 * @author hushunjian
 */
public class BeamBlockComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (StringUtils.isBlank(o1) || StringUtils.isBlank(o2)){
            return 0;
        }
        String[] split1 = o1.split("-");
        String[] split2 = o2.split("-");
        if (split1.length < 3 || split2.length < 3){
            return 0;
        }
        return Integer.valueOf(split1[1]) - Integer.valueOf(split2[1]);
    }
}
