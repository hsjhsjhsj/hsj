package com.hushunjian.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class GetIP {
	
	public static void main(String[] args) {
	//	System.out.println(getServerIp());
		
		try {
		       InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
		       String hostAddress = address.getHostAddress();//192.168.0.121      
		       System.out.println(hostAddress);
		       InetAddress address1 = InetAddress.getByName("www.wodexiangce.cn");//获取的是该网站的ip地址，比如我们所有的请求都通过nginx的，所以这里获取到的其实是nginx服务器的IP地 
		       String hostAddress1 = address1.getHostAddress();//124.237.121.122 
		       InetAddress[] addresses = InetAddress.getAllByName("www.baidu.com");//根据主机名返回其可能的所有InetAddress对象 
		       for(InetAddress addr:addresses){ 
		       System.out.println(addr);//www.baidu.com/14.215.177.38 
		       //www.baidu.com/14.215.177.37 
		      } 
		    } catch (UnknownHostException e) { 
		       e.printStackTrace();
		   } 
	}

	@SuppressWarnings("unchecked")
	  public static String getServerIp(){
	    String SERVER_IP = null;
	    try {
	      Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
	      InetAddress ip = null;
	      while (netInterfaces.hasMoreElements()) {
	        NetworkInterface ni = (NetworkInterface) netInterfaces.nextElement();
	        ip = (InetAddress) ni.getInetAddresses().nextElement();
	        SERVER_IP = ip.getHostAddress();
	        if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
	            && ip.getHostAddress().indexOf(":") == -1) {
	          SERVER_IP = ip.getHostAddress();
	          break;
	        } else {
	          ip = null;
	        }
	      }
	    } catch (SocketException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	  
	    return SERVER_IP;
	  }
}
