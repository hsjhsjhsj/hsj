package com.hushunjian.listFilter;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxTest {
    public static void main(String[] args) {
        System.out.println("================");
        List<ZonedDateTime> list1 = new ArrayList<>();
        list1.add(null);
        list1.add(ZonedDateTime.now());
        System.out.println(Collections.max(list1));
    }
}
