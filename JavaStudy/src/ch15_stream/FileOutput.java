package ch15_stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		String idPath = path + "\\src\\files\\건우\\id.txt";

		try (FileOutputStream fos = new FileOutputStream(idPath)) { // FileOutPutStream 의 생성자에 두 번째 파라미터(append)에 true를 넣으면 기존 파일에 내용이 추가된다.
			String data = "이름 : 도건우";
			byte[] byteData = data.getBytes();

			fos.write(byteData);

			fos.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("========================================================");
		
		String tempPath = "C:\\Temp\\Temp.txt";
		
		try (FileOutputStream fos = new FileOutputStream(tempPath)){
			String data = "Temp는 Temporary의 약자이다.";
			fos.write(data.getBytes());
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}