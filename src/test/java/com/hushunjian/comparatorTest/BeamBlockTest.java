package com.hushunjian.comparatorTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class BeamBlockTest {
	public static void main(String[] args) {
		List<String> beamBlocks = new ArrayList<>();
		beamBlocks.add("YY30Z-002-D1");
		beamBlocks.add("YY30Z-004-D1");
		beamBlocks.add("YY30Z-003-D1");
		beamBlocks.add("YY30Z-001-D1");
		beamBlocks.add("YY30Z-005-D1");
		beamBlocks.add("YY30Z-008-D1");
		beamBlocks.add("YY30Z-006-D1");
		beamBlocks.add("YY30Z-007-D1");
		beamBlocks.sort(new BeamBlockComparator().reversed());
		beamBlocks.forEach(beamBlock -> System.out.println(beamBlock));
		
		StringUtils.equalsAny("NO", "No1","");
		System.out.println(StringUtils.isNoneBlank("","a"));
		
		System.out.println(StringUtils.containsAny("4-2-48上 ", "上"));
	}
}
