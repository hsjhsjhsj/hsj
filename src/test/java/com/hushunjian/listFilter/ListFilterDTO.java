package com.hushunjian.listFilter;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListFilterDTO {

	private String id;
	
	private String name;
	
	public ListFilterDTO test(String name){
		if(StringUtils.equals(name, "2")){
			return null;
		}
		return this;
	}
	
}
