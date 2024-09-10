package com.spring.study.attach.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.spring.study.attach.dto.AttachDTO;
import com.spring.study.common.util.FileUploadUtils;
import com.spring.study.member.dto.MemberDTO;
import com.spring.study.member.service.MemberService;

@Controller
public class AttachController {

	@Value("#{util['file.attach.path']}")
	String attachPath;

	@Autowired
	MemberService memberService;

	@Autowired
	FileUploadUtils fileUploadUtils;

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

	@ResponseBody
	@RequestMapping(value = "/uploadProfile", method = RequestMethod.POST)
	public String uploadProfile(MultipartFile file, HttpSession session) {

		String uuid = "";

		try {
			AttachDTO profileImg = fileUploadUtils.saveFile(file);
			System.out.println(profileImg);

			uuid = profileImg.getAtchFileName();

			MemberDTO login = (MemberDTO) session.getAttribute("login");

			MemberDTO member = new MemberDTO();
			member.setMemId(login.getMemId());
			member.setMemProfileImg(uuid);

			memberService.updateProfile(member);

			login.setMemProfileImg(uuid);
			session.setAttribute("login", login);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return uuid;
	}

	@RequestMapping(value = "/displayImage")
	public ResponseEntity<byte[]> displayImage(String fileName) {
		String imgPath = attachPath + File.separatorChar + fileName;

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.IMAGE_PNG);

		ResponseEntity<byte[]> result = null;

		try (FileInputStream fis = new FileInputStream(imgPath)) {
			byte[] data = IOUtils.toByteArray(fis);

			result = new ResponseEntity<byte[]>(data, headers, HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}

		return result;
	}
}
