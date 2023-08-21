package chat;

import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {
	//통신을 위한 스트림을 얻어오기 위해 Socket객체를 저장해야 한다.
	//연결된 클라이언트의 닉네임을 저장하고 있어야 한다.
	private String nickname;
	private Socket socket;
	private List<PrintWriter> pwList;
	public ChatServerThread() {}
	public ChatServerThread(Socket socket,List<PrintWriter> pwList) {
		this.socket=socket;
		this.pwList=pwList;
	}
	
	@Override
	public void run() {
		//main thread로 부터 전달받은 socket을 통해 IO Stream을 받아오는데,
		//문자 단위처리와 라인 단위 처리를 알기 위해 보조 스트림 객체를 생성
		BufferedReader br=null;
		PrintWriter pw=null;
		
		try {
			//1. Remote Host 정보
			InetSocketAddress remoteSocketAddress=(InetSocketAddress)socket.getLocalSocketAddress();
			ChatServer.log("호스트와 연결되었습니다. ["+remoteSocketAddress.getAddress().getHostAddress()+":"+remoteSocketAddress.getPort()+"]");
			//2. Stream 얻기
			br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
			
			//3. Request 처리
			while(true) {
				String request = br.readLine();

				if(request == null) {
					doQuit(pw);
					ChatServer.log("클라이언트로부터 연결이 끊겼습니다.");
					break;
				}
				String[] tokens = request.split(":");
				//System.out.println("tokens[0]="+tokens+", tokens[1]="+tokens[1]);
				//System.out.println("pw = "+pw);
				if("join".equals(tokens[0])) {
					doJoin(tokens[1],pw);
				}else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				}else if("quit".equals(tokens[0])) {
					doQuit(pw);
					break;
				}else {
					ChatServer.log("에러:알 수 없는 요청("+tokens[0]+")");
				}
			}
	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	private void doQuit(PrintWriter pw) {
		//OOO님이 퇴장하였습니다. 메세지가 브로드캐스팅 되어야 한다.
		//현재 스레드의 writer를 WriterPool에서 제거한 후, 브로드캐스팅 하자
		removeWriter(pw);
		if(nickname!=null) {
			String data=nickname+"님이 퇴장 하였습니다.";
			broadcastMsg(data);
		}
	}
	private void removeWriter(PrintWriter pw) {
		//현재 스레드의 writer를 WriterPool에서 제거하는 함수
		synchronized(pwList) {
			pwList.remove(pw);
		}
	}
	private void doMessage(String msg) {
		//메세지 보냈을 때 보여줄 내용 [닉네임:내용] 양식
		broadcastMsg(this.nickname+":"+msg);
	}
	private void doJoin(String nickName, PrintWriter writer) {
		//한 사용자가 채팅방 참여시, 다른 사용자들에게 OOO님이 입장하였습니다. 라는 말을 브로드캐스팅. 
		//ack를 보내 방 참여가 성공했다는 것을 클라이언트에게 알려주기
		
		this.nickname=nickName;
		String msg=nickname+"님이 입장했습니다.";
		broadcastMsg(msg);
		
		//writer pool에 저장
		addWriter(writer);
		
		//ack
		writer.println("join:OK");
		writer.flush();
	}
	private void broadcastMsg(String msg) {
		synchronized(pwList) {
			for(PrintWriter wt:pwList) {
				wt.println(msg);
			}
		}
	}
	private void addWriter(PrintWriter writer) {
		synchronized(pwList) {
			pwList.add(writer);
		}//synchronized 키워드는 여러 스레드가 하나의 공유 객체에 접근할 때 동기화를 보장해준다.
	}
	
}
