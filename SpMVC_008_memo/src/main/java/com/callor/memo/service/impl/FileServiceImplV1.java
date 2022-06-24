package com.callor.memo.service.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.service.FileUpService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FileServiceImplV1 implements FileUpService{

	private final String upLoadFolder;
	public FileServiceImplV1(String upLoadFolder) {
			this.upLoadFolder = upLoadFolder;
	}

	
	@Override
	public String fileUp(MultipartFile file) throws Exception {
		
		if(file == null) {
			return null;
		}
		
		File dir = new File(upLoadFolder);
		if( !dir.exists()) {
			dir.mkdirs();
		}
		
		String fileName = file.getOriginalFilename();
		log.debug("업로드 폴더 {}", upLoadFolder);

		
		String strUUID = UUID.randomUUID().toString();
		
		fileName = String.format("%s-%s", strUUID, fileName);
		log.debug("변경된 파일이름 {}", fileName);
		
	
		
		File upLoadFile = new File(upLoadFolder, fileName);
		file.transferTo(upLoadFile);
		
		return fileName;
	}


	@Override
	public boolean fileDelete(String fileName) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
