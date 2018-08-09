package com.hushunjian.testEquest;

public class TestEquals {
	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(1L);
		user1.setUserName("张三");
		user1.setAge(19);
		User user2 = new User();
		user2.setId(1L);
		user2.setUserName("张三");
		user2.setAge(19);
		
		if(user1.equals(user2)){
			System.out.println("相同的对象");
		}else{
			System.out.println("不同的对象");
		}
	}
	
	


}
