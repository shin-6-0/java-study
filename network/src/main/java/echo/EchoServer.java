package echo;

import java.io.*;
import java.net.*;

public class EchoServer {
	private static final int PORT = 9000;
	public static void main(String[] args) {
		ServerSocket serverSocket=null;
		try {
			//1. Server Socket 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(Binding)
			//Socket에 InetSocketAddress(IPAddress + port)를 바인딩
			//IPAddress : 0.0.0.0 : 특정 호스트 IP에 바인딩 하지 않는다.
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT),10);
			log("starts...[port:"+PORT+"]");
			
			//3.accept
			Socket socket = serverSocket.accept();//blocking 

			try {
				InetSocketAddress remoteInetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress(); //반대편Socket에있는 IP 와 소켓 주소 있음
				String remoteHostAddress = remoteInetSocketAddress.getAddress().getHostAddress();
				int remotePort = remoteInetSocketAddress.getPort();
				log("connected by client["+remoteHostAddress+":"+remotePort+"]");
				
				//4.IOStream 받아오기
				OutputStream os = socket.getOutputStream();
				InputStream is = socket.getInputStream();
				
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(os,"utf-8"),true);//t/f는 autoflush로 해두면 true
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
				
				while(true) {
					String data = br.readLine();
					
					if(data==null) {//서버 끄기
						//클라이언트가 정상적으로 종료(close() 호출)
						log("closed by client");
						break;
					}

					log("received:"+data);
					pw.println(data);
				}
			}catch(SocketException e) {
				log("suddenly closed by client");
			}catch(IOException e) {
				log("error : "+e);
			}finally {
				try {
					if(socket!=null&&!socket.isClosed()) {
						socket.close();					
					}
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}catch(IOException e) {
			log("error:"+e);
		}finally {
			try {
				//close안했는데 이미 되어있는 경우 방지
				if(serverSocket !=null && serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void log(String message){
		System.out.println("[EchoServer] "+message);
	}

}
