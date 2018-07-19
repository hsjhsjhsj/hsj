package com.hushunjian.sql;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class InsertSql {
	
	public static void main(String[] args) {
		List<String> rebarSql = new ArrayList<>();
		//钢筋胎位sql
		for(int i = 1;i<=5;i++){
			String id = UUID.randomUUID().toString().replaceAll("-", "");
			StringBuffer insertParent = new StringBuffer("INSERT INTO `PF_REBAR_POSITION_T` VALUES ('");
			insertParent.append(id).append("', 0, NULL ,'").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
			insertParent.append(" NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, ").append(i).append(", NULL, '").append(i).append("#生产线', 'GJTW").append(i).append("');");
			rebarSql.add(insertParent.toString());
			for(int j = 1;j<=8;j++){
				String childId = UUID.randomUUID().toString().replaceAll("-", "");
				StringBuffer insertChild = new StringBuffer("INSERT INTO `PF_REBAR_POSITION_T` VALUES ('");
				insertChild.append(childId).append("', 0, NULL ,'").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
				insertChild.append(" NULL, NULL, NULL, NULL, NULL, 0, 1, NULL, ").append(j).append(", '").append(id).append("', '").append(j).append("#钢筋绑扎胎位', 'GJBZTW").append(i).append("-").append(j).append("');");
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
			StringBuffer insertParent = new StringBuffer("INSERT INTO `PF_BEAM_MAKING_PEDESTAL_T` VALUES ('");
			insertParent.append(id).append("', 0, NULL ,'").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
			insertParent.append(" NULL, NULL, NULL, 0, '").append(i).append("#生产线', NULL, ").append(i).append(", NULL, 'ZLTZ").append(i).append("');");
			makingPedestalSql.add(insertParent.toString());
			for(int j = 1;j<=12;j++){
				String childId = UUID.randomUUID().toString().replaceAll("-", "");
				StringBuffer insertChild = new StringBuffer("INSERT INTO `PF_BEAM_MAKING_PEDESTAL_T` VALUES ('");
				insertChild.append(childId).append("', 0, NULL ,'").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
				insertChild.append(" NULL, NULL, NULL, 1, '").append(j).append("#制梁台座', NULL, ").append(j).append(", '").append(id).append("', 'ZLTZ").append(i).append("-").append(j).append("');");
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
		for(int i=1;i<=3;i++){
			//1区
			String id1 = UUID.randomUUID().toString().replaceAll("-", "");
			StringBuffer insertParent1 = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T` VALUES ('");
			insertParent1.append(id1).append("', 0, NULL, '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
			insertParent1.append(" NULL, NULL, NULL, NULL, NULL, 0, 0, NULL, ").append(i).append(", NULL, '").append(i).append("区', '").append("CLTZ").append(i).append("');");
			storagePedestalSql.add(insertParent1.toString());
			for(int j=1;j<=3;j++){
				//第1块
				String id2 = UUID.randomUUID().toString().replaceAll("-", "");
				StringBuffer insertParent2 = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T` VALUES ('");
				insertParent2.append(id2).append("', 0, NULL, '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
				insertParent2.append(" NULL, NULL, NULL, NULL, NULL, 1, 0, NULL, ").append(j).append(", '").append(id1).append("', '第").append(j).append("块', 'CLTZ").append(i).append("-").append(j).append("');");
				storagePedestalSql.add(insertParent2.toString());
				for(int k=1;k<=3;k++){
					//第1列
					String id3 = UUID.randomUUID().toString().replaceAll("-", "");
					StringBuffer insertParent3 = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T` VALUES ('");
					insertParent3.append(id3).append("', 0, NULL, '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
					insertParent3.append(" NULL, NULL, NULL, NULL, NULL, 2, 0, NULL, ").append(k).append(", '").append(id2).append("', '第").append(k).append("列', 'CLTZ").append(i).append("-").append(j).append("-").append(k).append("');");
					storagePedestalSql.add(insertParent3.toString());
					for(int z=1;z<=30;z++){
						//存梁台座
						String id4 = UUID.randomUUID().toString().replaceAll("-", "");
						StringBuffer insertChild = new StringBuffer("INSERT INTO `PF_STORAGE_PEDESTAL_T` VALUES ('");
						insertChild.append(id4).append("', 0, NULL, '").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("',");
						insertChild.append(" NULL, NULL, NULL, NULL, NULL, 3, 0, NULL, ").append(z).append(", '").append(id3).append("', '").append(z).append("#存梁台座', 'CLTZ").append(i).append("-").append(j).append("-").append(k).append("-").append(z).append("');");
						storagePedestalSql.add(insertChild.toString());
					}
				}
			}
		}
		System.out.println("## ==========存梁台座sql开始==========");
		for(String sql : storagePedestalSql){
			System.out.println(sql);
		}
		System.out.println("## ==========存梁台座sql结束==========");
	}
}
