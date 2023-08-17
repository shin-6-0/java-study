package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhonList01 {
	//출력조건 이름:000-0000-0000
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			File file  = new File("phone.txt");
			
			if(!file.exists()) {
				System.out.println("File Not Found");
				return;
			}
			System.out.println("============ 파일정보 ============");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length()+" bytes");
			Long timestamp = file.lastModified();
			Date d = new Date(timestamp);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(d);
			String date2= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
			//date, date2 똑같음
			System.out.println(date);
			
			System.out.println("============ 전화번호 ============");
			//1. 기반스트림(표준입력, stdin(Standard In)
			FileInputStream fis = new FileInputStream(file);
			
			//2. 보조스트림 (byte|byte|byte -> char 로 바꿔줌)
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			
			//3. 보조스트림2 (char1|char2|char3|\n = "char1char2char3"(String형으로변경))
			br = new BufferedReader(isr);
			
			//4. 처리
			String line = null;
			while((line=br.readLine())!=null) {
				StringTokenizer st = new StringTokenizer(line,"\t ");
				
				int index=0;
				while(st.hasMoreElements()) {
					String token=st.nextToken();
					if(index==0) {
						System.out.print(token +":");
					}else if(index==1||index==2) {
						System.out.print(token+"-");
					}else if(index==3) {
						System.out.println(token);
					}
					index++;
				}
				//System.out.println(line);
			}
		}catch(UnsupportedEncodingException e) {
			System.out.println("Error : "+e);
		}catch(IOException e) {
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
