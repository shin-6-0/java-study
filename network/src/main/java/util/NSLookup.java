package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			boolean isTrue=true;
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.print(">> ");
				String line = sc.nextLine();
				if("quit".equals(line)) {
					break;
				}
				InetAddress aArr[] = null;
				aArr=InetAddress.getAllByName(line);
				//System.out.println("arr 길이 : "+aArr.length);
				for(int i=0;i<aArr.length;i++) {
					System.out.println(aArr[i].getHostName()+" : "+aArr[i].getHostAddress());
				}
			}
		}catch(UnknownHostException e) {
			System.out.println("Error : "+e);
		}
		
	}
	//String host (도메인네임) 출력
	

}
