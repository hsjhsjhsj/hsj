package com.hushunjian.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class ScheduleTask {

	@Scheduled(cron = "0/5 * * * * *")
	public void execute1(){
		System.out.println("定时任务执行！");
	}
	
	@Scheduled(cron = "0 0 18 ? L ?")
	public void execute2(){
		System.out.println("定时任务执行！");
	}
}
