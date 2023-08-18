package echo;

import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
	private static final String SERVER_IP="127.0.0.1";
	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;
		try {
			//1. 소켓 생성
			socket = new Socket();
			
			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP,EchoServer.PORT));
			
			//3. io stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4.Scanner 사용해서 읽기
			scanner = new Scanner(System.in);
			while(true) {
				System.out.print(">");
				String line = scanner.nextLine();
				
				if("exit".equals(line)) {
					break;
				}
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(os,"utf-8"),true);//t/f는 autoflush로 해두면 true
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
				
				pw.println(line);
				String data = br.readLine();
				
				if(data == null) {
					log("closed by server");
					break;
				}
				
				System.out.println("<"+data);
			}

		} catch (SocketException e) {
			log(" suddenly closed by server");
		} catch (IOException e) {
			log(" error:"+e);
		}finally {
			try {
				if(socket!=null && socket.isClosed()) {
					socket.close();
				}
				if(scanner!=null) {
					scanner.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void log(String message){
		System.out.println("[EchoClient] "+message);
	}

}
