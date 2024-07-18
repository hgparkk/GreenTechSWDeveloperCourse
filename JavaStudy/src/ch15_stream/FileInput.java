package ch15_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInput {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");

		String helloPath = path + File.separatorChar + "src" + File.separatorChar + "ch01_start" + File.separatorChar
				+ "HelloWorld.java";

		File hello = new File(helloPath);

		System.out.println(hello.exists());

		FileInputStream fis = null; // InputStream, OutputStream 은 byte 단위로 데이터를 읽고 쓰기 때문에 텍스트 파일을 읽고 쓰기에는 적합하지 않다.

		try {
			fis = new FileInputStream(helloPath);
			byte[] bucket = new byte[fis.available()];

			while (true) {
				int count = fis.read(bucket);

				if (count == -1) {
					break;
				}

				String data = new String(bucket);
				System.out.print(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}