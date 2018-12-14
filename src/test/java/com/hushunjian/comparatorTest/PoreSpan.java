package com.hushunjian.comparatorTest;

import lombok.Data;

@Data
public class PoreSpan {
	
	private Integer a;
	
	private Integer b;

	public PoreSpan(Integer a, Integer b) {
		super();
		this.a = a;
		this.b = b;
	}

	public PoreSpan() {
	}
}
