package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class KeyboardTest {

	public static void main(String[] args) throws IOException {
		BufferedReader br=null;
		try {
			//1. 기반스트림(표준입력, stdin(Standard In)
			
			
			//2. 보조스트림 (byte|byte|byte -> char 로 바꿔줌)
			InputStreamReader isr = new InputStreamReader(System.in, "UTF-8");
			
			//3. 보조스트림2 (char1|char2|char3|\n = "char1char2char3"(String형으로변경))
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line = br.readLine())!=null) {
				if("quit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
		}catch(UnsupportedEncodingException e) {
			System.out.println("Error : "+e);
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
