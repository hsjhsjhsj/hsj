package com.hushunjian.MyThread2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行账户
 * @author Administrator
 *
 */
public class Account {
	private Lock accountLock = new ReentrantLock();
	private double balance;//账户余额
	
	/**
	 * 存款
	 * @param money  存入金额
 	 */
	public  void deposit(double money){
		accountLock.lock();
		try {
			double newBalance = balance + money;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = newBalance;
		} 
		finally{
			accountLock.unlock();
		}
		
	}
	
	/**
	 * 获取账户余额
	 * @return
	 */
	public double getBalance(){
		return balance;
	}
}
