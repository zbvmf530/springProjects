package com.yedam.app.upload.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class UploadController {
	// 운영시 고정 경로 사용불가
	// private String uploadPath = "D:/upload";
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	@GetMapping("formUpload")
	public void formUploadPage() { // classpath:/template/formUpload.html
		
	}
	
	@PostMapping("uploadForm")
	public String formUploadFile(@RequestPart MultipartFile[] images) {
		for(MultipartFile image : images) {
			// 1) 원래 파일이름
			log.warn(image.getOriginalFilename()); // 실제 파일 이름
			log.warn(image.getContentType()); // 개별 파일 종류
			log.warn(String.valueOf(image.getSize())); // 파일 크기
			String fileName = image.getOriginalFilename();
			
			// 2) 실제로 저장할 경로를 생성 : 서버의 업로드 경로 + 파일 이름
			String saveName = uploadPath + File.separator + fileName;
			log.debug("saveName : " + saveName);
			Path savePath = Paths.get(saveName);
			// 3) 파일 작성(파일 업로드)
			try {
				image.transferTo(savePath);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return "formUpload";
	}
}
