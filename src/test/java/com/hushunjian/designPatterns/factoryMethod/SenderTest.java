package com.hushunjian.designPatterns.factoryMethod;

public class SenderTest {
	public static void main(String[] args) {
		MailSender mailSender = new MailSender();
		mailSender.send();
		
		SmsSender smsSender = new SmsSender();
		smsSender.send();
	}
}
