package com.hushunjian.test;

import java.util.Arrays;

public class Sort {

	private Integer SIZE = 10;
	
	private Integer[] array1 = {1,2,3,4};
	
	private Integer[] array2 = new Integer[]{1,2,3,4};
	
	private Integer[] arrayInit(Integer size){
		Integer[] array3 = new Integer[size>0?size:SIZE];
		for(int i = 0;i<array3.length;i++){
			array3[i]=(int) (Math.random()*100);
		}
		System.out.println(Arrays.toString(array3));
		return array3;
	}
	
	private Integer[] arraySort1(Integer[] array){
		for(int i = 0;i<array.length;i++){
			for(int j = i;j<array.length;j++){
				if(array[j]>array[i]){
					Integer tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	private Integer[] arraySort2(Integer[] array){
		for(int i = 0;i<array.length;i++){
			for(int j = 0;j<array.length-1-i;j++){
				if(array[j]>array[j+1]){
					array[j] = array[j] ^ array[j+1];
					array[j+1] = array[j+1] ^ array[j];
					array[j] = array[j] ^ array[j+1];
				}
			} 
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	private Integer[] arraySort3(Integer[] array){
		for(int i = 0;i<array.length;i++){
			for(int j = i;j<array.length;j++){
				if(array[j]<array[i]){
					Integer tmp = array[j];
					array[j] = array[i];
					array[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
		return array;
	}
	
	public static void main(String[] args) {
		Sort sort = new Sort();
		Integer[] array = sort.arrayInit(10);
		System.out.println("=====开始冒泡排序arraySort1=====");
		sort.arraySort1(array);
		System.out.println("=====开始冒泡排序arraySort2=====");
		sort.arraySort2(array);
		System.out.println("=====开始冒泡排序arraySort3=====");
		sort.arraySort3(array);
	}
}
