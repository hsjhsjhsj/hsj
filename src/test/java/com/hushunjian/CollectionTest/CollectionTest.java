package com.hushunjian.CollectionTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.assertj.core.util.Lists;

public class CollectionTest {
	public static void main(String[] args) {
		System.out.println("==========1==========");
		List<String> last = Lists.newArrayList();
		last.add("文件1");
		last.add("文件2");
		List<String> cur = Lists.newArrayList();
		cur.add("文件2");
		cur.add("文件3");
		Collection retainAll = CollectionUtils.retainAll(last, cur);
		System.out.println("两个版本中相同的:" + retainAll);
		Collection removeAll = CollectionUtils.removeAll(last, cur);
		System.out.println("新版本中删除的:" + removeAll);
		Collection removeAll2 = CollectionUtils.removeAll(cur, last);
		System.out.println("新版本中添加的:" + removeAll2);
		System.out.println("==========1==========");
		List<String> aa = Collections.singletonList("aa");
		aa.add("bb");
		System.out.println(aa);
		System.out.println("=================================");
		List<String> savedImportantTasks = Arrays.asList("dd");
		savedImportantTasks.add("a");
		
	}
}
