package com.hushunjian.reflex;

import java.util.ArrayList;
import java.util.List;

public class ReflexTest {
	public static void main(String[] args) {
		List<Class> a = new ArrayList<>();
		a.add(ReflexClassA.class);
		a.add(ReflexClassB.class);
		
		for(Class tclass : a){
			ImportSheet importSheet = (ImportSheet) tclass.getAnnotation(ImportSheet.class);
			if(importSheet != null){
				System.out.println(importSheet.sheet());
			}
		}
	}
}
