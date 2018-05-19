package com.hushunjian.MyThread;

/**
 * 银行账户
 * @author Administrator
 *
 */
public class Account {
	private double balance;//账户余额
	
	/**
	 * 存款
	 * @param money  存入金额
 	 */
	public  void deposit(double money){
			double newBalance = balance + money;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance = newBalance;
	}
	
	/**
	 * 获取账户余额
	 * @return
	 */
	public double getBalance(){
		return balance;
	}
}
