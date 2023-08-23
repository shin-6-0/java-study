package chat;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "192.168.0.3";
	private static final int SERVER_PORT = 8080;
	
	public static void main(String[] args) {
		Scanner sc = null;
		Socket socket = null;
		try {
			//1. 키보드 연결
			sc=new Scanner(System.in);
			//2. 소켓 생성
			socket=new Socket();

			//3. 연결
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			log("채팅 서버 연결 완료");
			
			//4. reader/writer 생성
			PrintWriter pw = new PrintWriter( new OutputStreamWriter(socket.getOutputStream(),"UTF-8" ), true );
			BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			//5. join 프로토콜
			System.out.print("닉네임 설정 >>");
			String nickname=sc.nextLine();
			pw.println("join:"+nickname);
			String ack=br.readLine();
			if( "join:OK".equals( ack ) ) {
				System.out.println( "채팅에 입장하였습니다. 즐거운 채팅 되세요!" );
			}
			
			//6. ChatClientReceiveThread 시작
			new ChatClientThread( socket ).start();
			
			//7. 키보드 입력 처리
			while(true) {
				if(sc.hasNextLine() == false) {
					continue;
				}
				System.out.print(">>");
				String input=sc.nextLine();
				if("quit".equals(input)) {
					//8. quit 프로토콜 처리
					pw.println("quit");
					break;
				}
				if("".equals(input)==false){
					//9. 메시지 처리
					pw.println("message:"+input);
				}
			}
		} catch (ConnectException ex) {
			log( "서버[" + SERVER_IP + ":" + SERVER_PORT + "]에 연결할 수 없습니다." );	
		} catch (Exception ex) {
			log( "다음 이유로 프로그램을 종료 합니다 :" + ex );	
		}finally {
			try {
				if( sc != null ) {
					sc.close();
				}
				if( socket != null && socket.isClosed() == false ){
					socket.close();
				}
			} catch (IOException e) {
				log("오류가 발생하여 프로그램을 종료합니다. 오류내용 : "+e);
			}
		}
	}

	public static void log(String msg) {
		System.out.println("\n[Chat Client] "+msg);
	}

}
