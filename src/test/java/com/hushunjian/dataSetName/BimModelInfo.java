package com.hushunjian.dataSetName;

import lombok.Data;

@Data
public class BimModelInfo {
	
	// 分区
	private String dataSetName;
	
	// BIM标准码
	private String bimCode;
	
	// BIM标准名称
	private String bimCodeName;
	
	// 所属分区
	private String partition;
	
	public BimModelInfo(String dataSetName, String bimCode, String bimCodeName, String partition) {
		super();
		this.dataSetName = dataSetName;
		this.bimCode = bimCode;
		this.bimCodeName = bimCodeName;
		this.partition = partition;
	}

	public BimModelInfo() {
	}
	
	
}
