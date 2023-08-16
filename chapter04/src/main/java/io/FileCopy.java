package io;
import java.io.*;
public class FileCopy {
	public static void main(String[] args) {
		InputStream is =null;
		OutputStream os=null;
		try {
			is = new FileInputStream("IMG_0379.png");
			os = new FileOutputStream("IMG_0379.png");
			
			int data = is.read();
			while(data != -1) {
				os.write(data);
			}
		}catch(FileNotFoundException e) {
			System.out.println("file not found: "+e);
		}catch(IOException e){
			System.out.println("error : "+e);
		}finally {
			if(is!= null) {
				try {
					is.close();
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
