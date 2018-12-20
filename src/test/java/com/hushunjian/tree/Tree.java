package com.hushunjian.tree;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Tree {
	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 父级
	 */
	private Integer parent;
	
	/**
	 * 设计量
	 */
	private BigDecimal designNumber;
	
	/**
	 * outLineNum
	 */
	private String outLineNum;

	public Tree(Integer id, String name, Integer parent, BigDecimal designNumber, String outLineNum) {
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.designNumber = designNumber;
		this.outLineNum = outLineNum;
	}
}
