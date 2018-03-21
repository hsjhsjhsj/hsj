package com.hushunjian;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.hushunjian.interceptor.MyInterceptor1;
import com.hushunjian.interceptor.MyInterceptor2;

/**
 * @author hushunjian
 *	2018/3/21
 *
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter  {
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new MyInterceptor1()).addPathPatterns("/**");
        registry.addInterceptor(new MyInterceptor2()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
