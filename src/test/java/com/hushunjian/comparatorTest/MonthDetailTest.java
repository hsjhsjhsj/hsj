package com.hushunjian.comparatorTest;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MonthDetailTest {
	public static void main(String[] args) {
		List<MonthDetailDTO> monthDetailDTOs = new ArrayList<>();
		MonthDetailDTO monthDetailDTO1 = new MonthDetailDTO();
		monthDetailDTO1.setErectionTime(ZonedDateTime.of(2018, 12, 17, 17, 22, 22, 22, ZoneId.systemDefault()));
		monthDetailDTO1.setMileage("DK49+521.305-DK49+551.305");
		
		MonthDetailDTO monthDetailDTO2 = new MonthDetailDTO();
		monthDetailDTO2.setErectionTime(ZonedDateTime.of(2018, 12, 17, 17, 22, 22, 22, ZoneId.systemDefault()));
		monthDetailDTO2.setMileage("DK49+581.305-DK49+611.305");
		
		
		MonthDetailDTO monthDetailDTO3 = new MonthDetailDTO();
		monthDetailDTO3.setErectionTime(ZonedDateTime.of(2018, 12, 17, 17, 22, 22, 22, ZoneId.systemDefault()));
		monthDetailDTO3.setMileage("DK49+551.305-DK49+581.305");
		
		
		MonthDetailDTO monthDetailDTO4 = new MonthDetailDTO();
		monthDetailDTO4.setErectionTime(ZonedDateTime.of(2018, 12, 18, 17, 22, 22, 22, ZoneId.systemDefault()));
		monthDetailDTO4.setMileage("DK49+521.305-DK49+551.305");
		
		MonthDetailDTO monthDetailDTO5 = new MonthDetailDTO();
		monthDetailDTO5.setErectionTime(ZonedDateTime.of(2018, 12, 19, 17, 22, 22, 22, ZoneId.systemDefault()));
		monthDetailDTO5.setMileage("DK49+581.305-DK49+611.305");
		
		
		MonthDetailDTO monthDetailDTO6 = new MonthDetailDTO();
		monthDetailDTO6.setErectionTime(ZonedDateTime.of(2018, 12, 20, 17, 22, 22, 22, ZoneId.systemDefault()));
		monthDetailDTO6.setMileage("DK49+551.305-DK49+581.305");
		
		MonthDetailDTO monthDetailDTO7 = new MonthDetailDTO();
		
		monthDetailDTOs.add(monthDetailDTO1);
		monthDetailDTOs.add(monthDetailDTO2);
		monthDetailDTOs.add(monthDetailDTO3);
		monthDetailDTOs.add(monthDetailDTO4);
		monthDetailDTOs.add(monthDetailDTO5);
		monthDetailDTOs.add(monthDetailDTO6);
		monthDetailDTOs.add(monthDetailDTO7);
		
		sort(monthDetailDTOs);
		System.out.println("==============================");
		monthDetailDTOs.forEach(monthDetail -> System.out.println(monthDetail));
	}
	
	private static void sort(List<MonthDetailDTO> monthDetailDTOs){
		monthDetailDTOs.sort(Comparator.comparing(MonthDetailDTO::getErectionTime,Comparator.nullsLast(ZonedDateTime::compareTo)).thenComparing(MonthDetailDTO::getMileage,Comparator.nullsLast(String::compareTo)));
		monthDetailDTOs.forEach(monthDetail -> System.out.println(monthDetail));
	}
	
}
