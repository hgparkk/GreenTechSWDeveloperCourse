package ch15_stream;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");

		String idPath = path + "\\src\\files\\경희\\id.txt";

		try (FileWriter writer = new FileWriter(idPath)) {
			String msg = "이름 : 이경희";

			writer.write(msg);
			writer.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}