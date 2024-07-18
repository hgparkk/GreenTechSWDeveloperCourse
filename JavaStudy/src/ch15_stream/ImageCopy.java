package ch15_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
	public static void main(String[] args) {
		String dogPath = "C:\\Users\\phg2559\\Downloads\\20191225170826943516.jpg";
		String copyPath = "C:\\Temp\\dog.jpg";
		
		File dogFile = new File(dogPath);

		try (FileInputStream fis = new FileInputStream(dogFile);
				FileOutputStream fos = new FileOutputStream(copyPath)) {
			
			byte[] bucket = new byte[1];
			
			while(true) {
				int count = fis.read(bucket);
				if(count == -1) {
					break;
				}
				fos.write(bucket);
				fos.flush();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dogFile.delete();
	}
}