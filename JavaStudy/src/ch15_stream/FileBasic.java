package ch15_stream;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileBasic {
	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		System.out.println(path);

		String srcPath = path + "\\src";
		System.out.println(srcPath);

		srcPath = path + File.separatorChar + "src";
		System.out.println(srcPath);

		File src = new File(srcPath); // 경로에 있는 폴더나 파일을 불러온다.

		System.out.println(src); // File 에 대해서는 그 File 의 경로를 출력한다.

		System.out.println(src.isDirectory());

		File[] fileArray = src.listFiles();

		for (File f : fileArray) {
			System.out.println(f);
			System.out.println(f.getName());
		}

		System.out.println(fileArray[0]);

		File hello = new File(fileArray[0] + "\\HelloWorld.java");

		System.out.println(hello);

		File faker = new File(fileArray[0] + "\\faker.java");
		System.out.println(faker);

		System.out.println(hello.exists());
		System.out.println(faker.exists());

		System.out.println(hello.length()); // 파일의 바이트 단위 크기

		System.out.println(hello.lastModified());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a h:mm");

		System.out.println(sdf.format(hello.lastModified()));

		System.out.println(faker.length());
		System.out.println(faker.lastModified());

		try {
			faker.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		File filesFolder = new File(srcPath + "\\files");

		filesFolder.mkdir();

		System.out.println("========================================================");

		ArrayList<String> stuList = new ArrayList<>();

		stuList.add("재민");
		stuList.add("동희");
		stuList.add("주형");
		stuList.add("효신");
		stuList.add("경희");
		stuList.add("건우");
		stuList.add("상욱");

		for (String s : stuList) {
			File stuFile = new File(filesFolder + "\\" + s);
			stuFile.mkdir();
		}

		for (String s : stuList) {
			File stuFile = new File(filesFolder + "\\" + s + "\\id.txt");
			try {
				stuFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}