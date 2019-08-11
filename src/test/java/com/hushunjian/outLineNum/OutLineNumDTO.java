package com.hushunjian.outLineNum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutLineNumDTO {
	
	private String outLineNum;


	private Integer level;


	private Integer orderNum;


	public String getParentOutLineNum(){
		if (!outLineNum.contains(".")){
			return "";
		}else {
			int lastIndexOf = outLineNum.lastIndexOf(".");
			return outLineNum.substring(0, lastIndexOf);
		}
	}
}
