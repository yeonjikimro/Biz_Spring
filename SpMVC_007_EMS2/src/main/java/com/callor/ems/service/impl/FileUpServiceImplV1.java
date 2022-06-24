package com.callor.ems.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.ems.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileUpServiceImplV1 implements FileUpService {

	@Autowired
	private String upPath;
	 
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		if(file == null) {
			return null;
		}
		
		File dir = new File(upPath);
		if(!dir.exists()) {
			dir.mkdir();
		}
		
		String fileName = file.getOriginalFilename();
		
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", strUUID, fileName);
		log.debug("변경된 파일이름 {}", fileName);
		
		File upLoadFile = new File(upPath, fileName);
		file.transferTo(upLoadFile);
		
		return fileName;
	}

	@Override
	public List<String> filesUp(MultipartHttpServletRequest mFile) {
		List<String> retFiles = new ArrayList<>();
		
		List<MultipartFile> fileList = Files.getFileStore("mFiles");
		
		
		for(MultipartFile file : fileList) {
			
			String originName = file.getOriginalFilename();
			String uuName = this.fileUp(file);
			
			
		}
		
		return null;
	}

}
