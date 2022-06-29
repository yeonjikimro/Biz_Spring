package com.callor.memo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;

public interface MemoService {
	
	public List<MemoVO> selectAll();
	
	public int insertAndUpdate(MemoVO memo, MultipartFile file);
	
	public int delete(Long seq);
	
	public MemoVO findById(Long seq);

	public List<MemoVO> findByAuthor(String username);

}