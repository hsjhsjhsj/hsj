package com.hushunjian.sql;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SelectInsert {
	
	public static void main(String[] args) {
		List<String> rebarSql = new ArrayList<>();
		//钢筋胎位sql
		for(int i = 1;i<=5;i++){
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			StringBuffer insertParent = new StringBuffer("INSERT INTO `PF_REBAR_POSITION_T`(ID,VERSION,level,order_num,parent_id,position_name,position_num,is_pedestal) VALUES ('");
			insertParent.append(id).append("', 0, 0, ").append(i).append(", NULL, '").append(i).append("#生产线', '生产线").append(i).append("', 0);");
			rebarSql.add(insertParent.toString());
			for(int j = 1;j<=8;j++){
				String childId = UUID.randomUUID().toString().replaceAll("-", "");
				StringBuffer insertChild = new StringBuffer("INSERT INTO `PF_REBAR_POSITION_T`(ID,VERSION,level,order_num,parent_id,position_name,position_num,is_pedestal) VALUES ('");
				insertChild.append(childId).append("', 0, 1, ").append(j).append(", '").append(id).append("', '").append(j).append("#钢筋绑扎胎位', '钢筋绑扎胎位").append(i).append("-").append(j).append("', 1);");
				rebarSql.add(insertChild.toString());
			}
		}
		System.out.println("## ==========钢筋胎位sql开始==========");
		for(String sql : rebarSql){
			System.out.println(sql);
		}
		System.out.println("## ==========钢筋胎位sql结束==========");
		
		List<String> makingPedestalSql = new ArrayList<>();
		//制梁台座sql
		for(int i = 1;i<=5;i++){
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			StringBuffer insertParent = new StringBuffer("INSERT INTO `PF_BEAM_MAKING_PEDESTAL_T`(ID,VERSION,level,name,order_num,parent_id,pedestal,is_pedestal) VALUES ('");
			insertParent.append(id).append("', 0, 0, '").append(i).append("#生产线', ").append(i).append(", NULL, '生产线").append(i).append("', 0);");
			makingPedestalSql.add(insertParent.toString());
			for(int j = 1;j<=12;j++){
				String childId = UUID.randomUUID().toString().replaceAll("-", "");
				StringBuffer insertChild = new StringBuffer("INSERT INTO `PF_BEAM_MAKING_PEDESTAL_T`(ID,VERSION,level,name,order_num,parent_id,pedestal,is_pedestal) VALUES ('");
				insertChild.append(childId).append("', 0, 1, '").append(j).append("#制梁台座', ").append(j).append(", '").append(id).append("', '制梁台座").append(i).append("-").append(j).append("', 1);");
				makingPedestalSql.add(insertChild.toString());
			}
		}
		System.out.println("## ==========制梁台座sql开始==========");
		for(String sql : makingPedestalSql){
			System.out.println(sql);
		}
		System.out.println("## ==========制梁台座sql结束==========");
		
		//存梁台座sql
		List<String> storagePedestalSql = new ArrayList<>();
		for(int i=1;i<=5;i++){
			//1区
			String id1 = UUID.randomUUID().toString().replaceAll("-", "");
			StringBuffer insertParent1 = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T`(ID,VERSION,level,order_num,parent_id,storage_pedestal_name,storage_pedestal_num,is_pedestal) VALUES ('");
			insertParent1.append(id1).append("', 0, 0, ").append(i).append(", NULL, '").append(i).append("#生产线', '生产线").append(i).append("', 0);");
			storagePedestalSql.add(insertParent1.toString());
			for(int j=1;j<=3;j++){
				//第1块
				String id2 = UUID.randomUUID().toString().replaceAll("-", "");
				StringBuffer insertParent2 = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T`(ID,VERSION,level,order_num,parent_id,storage_pedestal_name,storage_pedestal_num,is_pedestal) VALUES ('");
				insertParent2.append(id2).append("', 0, 1, ").append(j).append(", '").append(id1).append("', '第").append(a(j)).append("列', '").append("第").append(a(j)).append("列', 0);");
				storagePedestalSql.add(insertParent2.toString());
				for(int k=1;k<=59;k++){
					//第1列
					String id3 = UUID.randomUUID().toString().replaceAll("-", "");
					StringBuffer insertParent3 = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T`(ID,VERSION,level,order_num,parent_id,storage_pedestal_name,storage_pedestal_num,is_pedestal) VALUES ('");
					insertParent3.append(id3).append("', 0, 2, ").append(k).append(", '").append(id2).append("', '").append(k).append("#台座', '存梁台座").append(i).append("-").append(j).append("-").append(k).append("', 1);");
					storagePedestalSql.add(insertParent3.toString());
				}
			}
		}
		System.out.println("## ==========存梁台座sql开始==========");
		for(String sql : storagePedestalSql){
			System.out.println(sql);
		}
		System.out.println("## ==========存梁台座sql结束==========");
	}
	
	private static String a(int i){
		String b = null;
		switch (i) {
		case 1:
			b = "一";
			break;
		case 2:
			b = "二";
			break;
		case 3:
			b = "三";
			break;
		default:
			break;
		}
		return b;
	}
}
