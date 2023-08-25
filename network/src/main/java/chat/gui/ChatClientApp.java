package chat.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatServer;

public class ChatClientApp {
	public static final String SERVER_IP = "192.168.0.145";

	public static void main(String[] args) {
		Socket socket = null;
		String name = null;
		Scanner scanner = null;

		try {

			scanner = new Scanner(System.in);

			while (true) {
				System.out.println("대화명을 입력하세요.");
				System.out.print("> ");
				name = scanner.nextLine();

				if (name.isEmpty() == false) {
					break;
				}

				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}

			scanner.close();

			// 1. create socket
			socket = new Socket();
			// 2. connect server
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");

			PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

			// 3. join protocol 진행
			printWriter.println("join:" + name);
			printWriter.flush();

			String ack = bufferedReader.readLine();
			if ("join:ok".equals(ack)) {
				new ChatWindow(name, socket).show();
			}
		} catch (SocketException e) {
			log("Socket error:" + e);
		} catch (IOException e) {
			log("error:" + e);
		} finally {

			if (scanner != null) {
				scanner.close();
			}
		}

	}

	private static void log(String message) {
		System.out.println("[ChatClientApp] " + message);
	}
}