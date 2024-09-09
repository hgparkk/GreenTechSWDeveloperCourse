package com.spring.study.common.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.spring.study.attach.dto.AttachDTO;

@Component
public class FileUploadUtils {

	@Value("#{util['file.attach.path']}")
	String uploadPath;

	private String transferFancySize(long size) {
		if (size < (long) (Math.pow(2.0, 10.0)))
			return size + "Byte";
		else if (size < (long) (Math.pow(2.0, 20.0)))
			return (size / (long) (Math.pow(2.0, 10.0))) + "KB";
		else if (size < (long) (Math.pow(2.0, 30.0)))
			return (size / (long) (Math.pow(2.0, 20.0))) + "MB";
		else
			return (size / (long) (Math.pow(2.0, 30.0))) + "GB";
	}

	public AttachDTO saveFile(MultipartFile file) throws IOException {
		String atchFileName = UUID.randomUUID().toString();

		String atchPath = uploadPath + File.separatorChar + atchFileName;

		file.transferTo(new File(atchPath));

		AttachDTO result = new AttachDTO();
		result.setAtchFileName(atchFileName);
		result.setAtchOriginalName(file.getOriginalFilename());
		result.setAtchFileSize(file.getSize());
		result.setAtchFancySize(transferFancySize(file.getSize()));
		result.setAtchContentType(file.getContentType());
		result.setAtchPath(atchPath);
		return result;
	}
}