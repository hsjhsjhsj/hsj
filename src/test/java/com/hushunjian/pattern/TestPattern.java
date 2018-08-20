package com.hushunjian.pattern;

public class TestPattern {
	public static void main(String[] args) {
		String url = "/apiPlan/exportConstructionLedger?&beamBlockStart=none&beamBlockEnd=none&date=none&_t=1533883091";
		String pattern = "\\?&";
		System.out.println(url.replaceAll(pattern, "?"));
	}
}
