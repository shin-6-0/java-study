package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClientApp {
	private static final String SERVER_IP="127.0.0.1";
	private static final int PORT=8000;
	public static void main(String[] args) {
		String name = null;
		Scanner scanner = null;
		Socket socket = null; //UDP 데이터그램은 java.net.DatagramPacket 클래스로 추상화한 것
		
		try {
			//1. create socket
			socket = new Socket();
			//2. connect server
			socket.connect(new InetSocketAddress(SERVER_IP, PORT));
			log("connected");
			scanner = new Scanner(System.in);
			
			PrintWriter pw = new PrintWriter( new OutputStreamWriter(socket.getOutputStream(),"UTF-8" ), true );
			BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream(),"UTF-8"));
			
			while( true ) {
				
				System.out.println("대화명을 입력하세요.");
				System.out.print(">>> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false ) {
					break;
				}
				
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			
				//3. join protocol 진행
				pw.println("join:"+name);
				String line = br.readLine();
				if("join:ok".equals(line)) {
					//이름 뿐 아니라 소켓도 보내기 
					new ChatWindow(name,socket,pw).show();
				}
			}
		} catch (SocketException e) {
			log( "소켓 오류 :" + e );
		} catch (Exception ex) {
			log( "다음 이유로 프로그램을 종료 합니다 :" + ex );	
		} /*
			 * finally { if( socket != null && socket.isClosed() == false ){ try {
			 * socket.close(); } catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } } }
			 */
	
	}
	public static void log(String msg) {
		System.out.println("[Chat Client] "+msg);
	}
}
