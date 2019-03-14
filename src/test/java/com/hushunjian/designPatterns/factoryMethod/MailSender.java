package com.hushunjian.designPatterns.factoryMethod;

public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("mail");
	}

}
