package com.rltx.biz.center.components;

import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class SpringMvcUrlUtil implements ServletContextListener {

    @Autowired
    private RequestMappingHandlerMapping handlerMapping;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("============================lisen2");
        Set<RequestMappingInfo> rmSet = handlerMapping.getHandlerMethods().keySet();
        for (RequestMappingInfo rm : rmSet) {
            System.out.println(rm.getPatternsCondition().toString());
        }


    }
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}