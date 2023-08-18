package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalHost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();//프로그램이 돌고 있는 것
			
			String hostname = inetAddress.getHostName();
			String hostIpAddress = inetAddress.getHostAddress();
			
			System.out.println(hostname);
			System.out.println(hostIpAddress);
			
			byte[] IpAddresses = inetAddress.getAddress();
			for(byte IpAddress : IpAddresses) {
				System.out.println(IpAddress&0x000000ff);//왜 0x000000ff를 곱해둔걸까
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
