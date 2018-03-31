package com.hushunjian.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class ScheduleTask {

	@Scheduled(cron = "0/5 * * * * *")
	public void execute(){
		System.out.println("定时任务执行！");
	}
	
}
