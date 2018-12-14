package com.hushunjian.reflex;

import lombok.Data;

@Data
public class ReflexClassB {
	
	@ImportColumn(column = 2)
	private String column;

}
