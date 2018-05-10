package com.rltx.biz.center.components;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;


@Component
public class MyListenerProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        if (methods != null) {
            for (Method method : methods) {
            	FunctionPoint permissionOperation = AnnotationUtils.findAnnotation(method, FunctionPoint.class);
                if (null != permissionOperation) {
                    //插入到数据中
                    System.out.println(permissionOperation.code());
                    System.out.println(permissionOperation.url());
                    System.out.println(permissionOperation.description());
                }
            }
        }
        return bean;
    }
}