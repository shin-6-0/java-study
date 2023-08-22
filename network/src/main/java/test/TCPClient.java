package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class TCPClient {
	private static final String SERVER_IP="127.0.0.1";
	private static final int SERVER_PORT=12345;
	public static void main(String[] args) {
		Socket socket = null;
		try {
			//1. 소켓 생성
			socket = new Socket();
			
			//1-1. 소켓 버퍼 사이즈 확인
			int rcvBufferSize = socket.getReceiveBufferSize();
			int sndBufferSize = socket.getSendBufferSize();
			
			System.out.println(rcvBufferSize+":"+sndBufferSize);
			
			//1-3. SO_NODELAY(Nagle Algorithm off)
			socket.setTcpNoDelay(true);
			
			//1-4. SO_TIMEOUT
			socket.setSoTimeout(3000);//3초!
			
			//1-2. 소켓 버퍼사이즈 변경
			socket.setReceiveBufferSize(1024*10);
			socket.setSendBufferSize(1024*10);
			rcvBufferSize = socket.getReceiveBufferSize();
			sndBufferSize = socket.getSendBufferSize();
			System.out.println(rcvBufferSize+":"+sndBufferSize);

			//2. 서버 연결
			socket.connect(new InetSocketAddress(SERVER_IP,SERVER_PORT));
			
			//3. io stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			//4. 쓰기
			String data = "안뇽 서버";
			os.write(data.getBytes("utf-8"));
			
			//5. 읽기
			byte[] buffer = new byte[256];
			int readByteCount = is.read(buffer); //blocking
			if(readByteCount == -1) {
				//서버가 정상적으로 close() 호출
				System.out.println("[client] closed by server");
				return;
			}
			data =new String(buffer, 0, readByteCount,"utf-8");
			System.out.println("[client] received:"+data);
			
			//so_timeout 옵션 테스트용
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//6. 데이터 쓰기
			os.write(data.getBytes("utf-8"));
		} catch(SocketTimeoutException e) {
			System.out.println("[client] timeout!! ");
		}catch (SocketException e) {
			System.out.println("[client] suddenly closed by server");
		} catch (IOException e) {
			System.out.println("[client] error:"+e);
		}finally {
			try {
				if(socket!=null && socket.isClosed()) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
