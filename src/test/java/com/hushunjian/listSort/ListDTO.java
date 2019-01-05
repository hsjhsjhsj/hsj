package com.hushunjian.listSort;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListDTO {
	private String beamSpanNum;

	public ListDTO(String beamSpanNum) {
		super();
		this.beamSpanNum = beamSpanNum;
	}
}
