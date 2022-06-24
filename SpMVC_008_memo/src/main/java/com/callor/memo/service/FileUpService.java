package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface FileUpService {
	// 한개 파일 업로드
	public String fileUp(MultipartFile file) throws Exception;
	
	// 파일 삭제
	public boolean fileDelete(String fileName) throws Exception;

}
