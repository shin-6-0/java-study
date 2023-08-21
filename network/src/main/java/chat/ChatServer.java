package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 8080;
	public static void main(String[] args) {
		List<PrintWriter> pwList = new ArrayList<PrintWriter>();
		ServerSocket serverSocket=null;
		try {
			//1. 서버 소켓 생성
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			
			//2. 바인딩
			String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress(hostAddress,PORT),5);
			log("연결 Loading : "+hostAddress+PORT);
			
			while(true) {
				//3.연결 시도
				Socket socket = serverSocket.accept();
				
				Thread thread = new ChatServerThread(socket,pwList);
				thread.start();
			}
		} catch (IOException e) {
			log("IOException : "+e);
		}finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				log("IOException : "+e);
			}
		}
	}
	public static void log(String msg) {
		System.out.println("[Chat Server]"+msg);
	}

}
