package com.spring.study.attach.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AttachController {

	@Value("#{util['file.attach.path']}")
	String attachPath;

	@RequestMapping("/fileDownload")
	public void fileDownload(String fileName, String fileOriginName, HttpServletResponse response) {
		String atchFilePath = attachPath + File.separatorChar + fileName;

		File downloadFile = new File(atchFilePath);

		try {
			byte[] fileByte = FileUtils.readFileToByteArray(downloadFile);

			response.setContentType("application/octet-stream");
			response.setContentLength(fileByte.length);

			response.setHeader("Content-Disposition",
					"attachment; fileName=\"" + URLEncoder.encode(fileOriginName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");

			response.getOutputStream().write(fileByte);
			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
