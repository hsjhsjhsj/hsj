package com.hushunjian.folder;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

public class FolderComparator implements Comparator<Folder> {
    @Override
    public int compare(Folder o1, Folder o2) {
        int compare = o1.getPath().compareTo(o2.getPath());
        if (compare < 0 && StringUtils.equals(o1.getParentPath(), o2.getParentPath())){
                compare = o1.getOrderNum() - o2.getOrderNum();
        }
        return compare;
    }
}
