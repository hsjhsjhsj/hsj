package com.hushunjian.outLineNum;

import java.util.*;

public class OutLineNumTest {
	public static void main(String[] args) {
		List<OutLineNumTestDTO> list = new ArrayList<>();
		list.sort(new OutLineNumComparator());
		
		
		// String outLineNum = "1.2.3.6.44.555";
		String outLineNum = "1";
		String[] split = outLineNum.split("\\.");
		Set<String> parent = new HashSet<>();
		String s = split[0];
		for(int i = 1; i< split.length -1; i++){
			s = String.format("%s.%s", s, split[i]);
			parent.add(s);
		}
		System.out.println(parent);
		
		System.out.println("------------------");
		String path = "1.2";
		System.out.println(path.substring(0, path.lastIndexOf(".")));
		System.out.println("------------------");

		List<OutLineNumDTO> outLineNumDTOs = new ArrayList<>();
		outLineNumDTOs.add(new OutLineNumDTO("1", 1, 1));
		outLineNumDTOs.add(new OutLineNumDTO("1.1", 2, 1));
		outLineNumDTOs.add(new OutLineNumDTO("1.1.2", 3, 2));
		outLineNumDTOs.add(new OutLineNumDTO("1.1.1.1", 4, 1));
		outLineNumDTOs.add(new OutLineNumDTO("1.1.1.2", 4, 2));
		outLineNumDTOs.add(new OutLineNumDTO("1.1.1.1.1", 5, 1));
		outLineNumDTOs.add(new OutLineNumDTO("1.2", 2, 2));
		outLineNumDTOs.add(new OutLineNumDTO("1.3", 2, 3));
		outLineNumDTOs.add(new OutLineNumDTO("1.1.1", 3, 1));

		outLineNumDTOs.sort(Comparator.comparing(OutLineNumDTO::getParentOutLineNum).thenComparing(OutLineNumDTO::getOrderNum));
		outLineNumDTOs.forEach(outLineNumDTO -> {
			System.out.println(outLineNumDTO.getOutLineNum());
		});
	}
}
