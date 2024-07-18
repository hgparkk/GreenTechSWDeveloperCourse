package ch15_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageRename {
	public static void main(String[] args) {
		String basicPath = "C:\\Temp";
		String dogPath = basicPath + "\\dog.jpg";
		String puppyPath = basicPath + "\\puppy.jpg";

		File dogFile = new File(dogPath);

		try (FileInputStream fis = new FileInputStream(dogFile);
				FileOutputStream fos = new FileOutputStream(puppyPath)) {

			byte[] bucket = new byte[1];

			while (true) {
				int count = fis.read(bucket);
				if (count == -1) {
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