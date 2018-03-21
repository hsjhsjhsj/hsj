package com.hushunjian.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hushunjian.service.RedisService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Autowired
	private RedisService redisService;
	
	@org.junit.Test
	public void redisTest(){
		System.out.println("开始测试");
		redisService.set("aa", "AA");
		System.out.println("redis存储完毕");
		System.out.println("=======================");
		redisService.get("aa");
		System.out.println("redis获取完成======="+redisService.get("aa"));
	}
	
}
