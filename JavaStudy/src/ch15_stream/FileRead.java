package ch15_stream;

import java.io.FileReader;
import java.io.IOException;

public class FileRead {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		
		String helloPath = path+"\\src\\ch01_start\\HelloWorld.java";
		
		StringBuffer total = new StringBuffer();
		
		try {
			FileReader reader = new FileReader(helloPath);
			
			char[] word = new char[1];
			
			while(true) {
				int count = reader.read(word);
				if(count==-1) {
					break;
				}
				
				String data = new String(word);
				total.append(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(total);
	}
}