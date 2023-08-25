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
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {
//git check
    private Frame frame;
    private Panel pannel;
    private Button buttonSend;
    private TextField textField;
    private TextArea textArea;

    private Socket socket;
    private PrintWriter printWriter;

    public ChatWindow(String name, Socket socket) {
        frame = new Frame(name);
        pannel = new Panel();
        buttonSend = new Button("Send");
        textField = new TextField();
        textArea = new TextArea(30, 80);
        this.socket = socket;
    }

    public void show() {
        buttonSend.setBackground(Color.GRAY);
        buttonSend.setForeground(Color.WHITE);
        buttonSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        textField.setColumns(80);
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyCode = e.getKeyChar();
                if (keyCode == KeyEvent.VK_ENTER) {
                    sendMessage();
                }
            }
        });

        pannel.setBackground(Color.LIGHT_GRAY);
        pannel.add(textField);
        pannel.add(buttonSend);
        frame.add(BorderLayout.SOUTH, pannel);

        textArea.setEditable(false);
        frame.add(BorderLayout.CENTER, textArea);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                finish();
            }
        });
        frame.setVisible(true);
        frame.pack();

        try {
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
            new ChatClientThread(socket).start();
        } catch (SocketException e) {
            log("socket" + e);
        } catch (IOException e) {
            log("error: " + e);
        }
    }

    private void finish() {
        try {
        	//종료내용작성
            if (socket != null && socket.isClosed()) {
                socket.close();
            }
            printWriter.println( "quit" );
            System.exit(0);
        } catch (Exception e) {
           log("error: " + e);
        }
    }

    private void sendMessage() {
        String message = textField.getText();
        printWriter.println("message:" + message);
        textField.setText("");
        textField.requestFocus();
    }

    private void updateTextArea(String message) {
        textArea.append(message);
        textArea.append("\n");
    }

    private class ChatClientThread extends Thread {
        private BufferedReader bufferedReader;
        private Socket socket;

        public ChatClientThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                while (true) {
                    String message = bufferedReader.readLine();
                    if (message == null) {
                        break;
                    }
                    updateTextArea(message);
                }
            } catch (SocketException e) {
                log("socket" + e);
            } catch (IOException e) {
                log("error: " + e);
            } finally {
                finish();
            }
        }
    }

    private static void log(String message) {
        System.out.println("[ChatWindow] " + message);
    }
}