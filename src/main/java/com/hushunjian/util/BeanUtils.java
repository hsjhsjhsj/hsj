package com.hushunjian.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {  
	//Map转换为JavaBean
	public static <T> T map2bean(Map<String,Object> map,Class<T> clz){
		//创建JavaBean对象
		T obj = null;
		try {
			obj = clz.newInstance();
			//获取指定类的BeanInfo对象
			BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
			//获取所有的属性描述器
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pd:pds){
				Object value = map.get(pd.getName());
				Method setter = pd.getWriteMethod();
				setter.invoke(obj, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  obj;
	}
	public static Map<String,Object> bean2map(Object bean){
		Map<String,Object> map = new HashMap<>();
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(bean.getClass(), Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			for(PropertyDescriptor pd:pds){
				String key = pd.getName();
				Method getter = pd.getReadMethod();
				Object value = getter.invoke(bean);
				map.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
