package chat.gui;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				//System.out.println("click");//액션이 일어나면 클릭을 입력
				sendMessage();
			}
		});
		buttonSend.addActionListener((ActionEvent e)->{
			//이 메소드는 액션이벤트가 들어가야하니까 actionPerformed를 알아서 소환&추론
		});
		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if(keyCode==KeyEvent.VK_ENTER) {
					
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				//System.exit(0);
			}

		});
		frame.setVisible(true);
		frame.pack();
		
		//IOStream  받아오기
		//ChatClientThread 생성하고 실행
		
	}
	private void finish() {
		//quit 프로토콜 구현하기
		
		
		//exit java(JVM)
		System.exit(0);//JVM 끄는 명령어
	}
	private void sendMessage() {
		String message = textField.getText();
		System.out.println("메세지를 보내는 프로토콜 구현:"+message);
		//보낸 다음엔 창에 있는걸 지워야함!
		textField.setText("");
		textField.requestFocus();
		
		//ChatClientThread 에서 서버로부터 받은 메세지가 있다고 치고, ~~
		//소켓에서 받아온 글자를 입력해보기
		updateTextArea("마이콜 : "+message);
	}
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	//클래스를 내부에 만듬
	private class ChatClientThread extends Thread{
		@Override
		public void run() {
			sendMessage();
		}
	}
}