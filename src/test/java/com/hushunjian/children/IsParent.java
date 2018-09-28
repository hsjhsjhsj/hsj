package com.hushunjian.children;

import lombok.Data;

@Data
public class IsParent {
	private String classifyCodeName;
	
	private String floorName;
	
	private String subregion;
	
	private String category;

	public IsParent(String classifyCodeName, String floorName, String subregion, String category) {
		super();
		this.classifyCodeName = classifyCodeName;
		this.floorName = floorName;
		this.subregion = subregion;
		this.category = category;
	}
}
