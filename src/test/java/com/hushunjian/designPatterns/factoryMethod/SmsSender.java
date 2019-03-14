package com.hushunjian.designPatterns.factoryMethod;

public class SmsSender implements Sender {

	@Override
	public void send() {
		System.out.println("sms");
	}

}
