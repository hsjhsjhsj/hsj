package com.hushunjian.folder;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

public class FolderTest {

    private static final List<Folder> folders = Lists.newArrayList();

    static {
        folders.add(new Folder("文件夹1111", "文件夹1-文件夹11-文件夹111", "1.1.1.1", 4, 1, "1-1.1-1.1.1"));
        folders.add(new Folder("文件夹11213", "文件夹1-文件夹11-文件夹112-文件夹1121", "1.1.2.1.3", 5, 3, "1-1.1-1.1.2-1.1.2.1"));
        folders.add(new Folder("文件夹111", "文件夹1-文件夹11", "1.1.1", 3, 2, "1-1.1"));
        folders.add(new Folder("文件夹11", "文件夹1", "1.1", 2, 1, "1"));
        folders.add(new Folder("文件夹11113", "文件夹1-文件夹11-文件夹111-文件夹1111", "1.1.1.1.3", 5, 3, "1-1.1-1.1.1-1.1.1.1"));
        folders.add(new Folder("文件夹111110", "文件夹1-文件夹11-文件夹111-文件夹1111", "1.1.1.1.10", 5, 10, "1-1.1-1.1.1-1.1.1.1"));
        folders.add(new Folder("文件夹1121", "文件夹1-文件夹11-文件夹112", "1.1.2.1", 4, 1, "1-1.1-1.1.2"));
        folders.add(new Folder("文件夹11111", "文件夹1-文件夹11-文件夹111-文件夹1111", "1.1.1.1.1", 5, 1, "1-1.1-1.1.1-1.1.1.1"));
        folders.add(new Folder("文件夹112", "文件夹1-文件夹11", "1.1.2", 3, 1, "1-1.1"));
        folders.add(new Folder("文件夹11112", "文件夹1-文件夹11-文件夹111-文件夹1111", "1.1.1.1.2", 5, 2, "1-1.1-1.1.1-1.1.1.1"));
        folders.add(new Folder("文件夹11211", "文件夹1-文件夹11-文件夹112-文件夹1121", "1.1.2.1.1", 5, 1, "1-1.1-1.1.2-1.1.2.1"));
        folders.add(new Folder("文件夹1", "", "1", 1, 1, ""));
        folders.add(new Folder("文件夹11212", "文件夹1-文件夹11-文件夹112-文件夹1121", "1.1.2.1.2", 5, 2, "1-1.1-1.1.2-1.1.2.1"));
        folders.add(new Folder("文件夹120", "文件夹1", "1.20", 2, 20, "1"));
        folders.add(new Folder("文件夹12030", "文件夹1-文件夹120", "1.20.30", 3, 30, "1-1.20"));
        folders.add(new Folder("文件夹1203031", "文件夹1-文件夹120-文件夹12030", "1.20.30.31", 4, 31, "1-1.20-1.20.30"));
    }

    public static void main(String[] args) {
    	System.out.println("----------------------");
        folders.sort(new FolderCompparator());
        folders.forEach(folder -> System.out.println(folder.getPath()));
        System.out.println("--------排序前--------");
        folders.forEach(folder -> System.out.println(folder.getPath()));
        System.out.println("--------排序前--------");
        folders.sort(Comparator.comparing(Folder::getLevel).thenComparing(Folder::getParentPath).thenComparing(Folder::getOrderNum));
        System.out.println("--------排序后--------");
        folders.forEach(folder -> System.out.println(folder.getPath()));
        System.out.println("--------排序后--------");
    }

}
