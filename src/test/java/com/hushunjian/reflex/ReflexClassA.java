package com.hushunjian.reflex;

import lombok.Data;

@ImportSheet(sheet = 1)
@Data
public class ReflexClassA {
	
	@ImportColumn(column = 1)
	private String column;

}
