package com.callor.memo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.memo.model.MemoVO;
import com.callor.memo.persistance.MemoDao;
import com.callor.memo.service.FileUpService;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemoServiceImplV1 implements MemoService {

	protected final MemoDao memoDao;
	protected final FileUpService fileService;

	public MemoServiceImplV1(MemoDao memoDao, FileUpService fileService) {
		this.memoDao = memoDao;
		this.fileService = fileService;
	}

	@Autowired
	@Override
	public void create_memo_table() {
		log.debug("CREATE TABLE");

		try {
			memoDao.create_memo_table();
			log.debug("MEMO TABLE 생성 완료");
		} catch (Exception e) {
			// TODO: handle exception
			log.debug("BOOK TABLE 생성 실패");
		}

	}

	@Override
	public List<MemoVO> selectAll() {
		// TODO Auto-generated method stub
		
		return memoDao.selectAll();
	}

	@Override
	public int insert(MemoVO vo) {
		// TODO Auto-generated method stub

		int ret = memoDao.insert(vo);
		return ret;
	}

	@Override
	public int update(MemoVO vo) {
		int ret = memoDao.update(vo);
		return ret;
	}


	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return memoDao.delete(id);
	}

	

	@Override
	public MemoVO findById(Long id) {
		
		return memoDao.findById(id);
	}

	@Override
	public String insertMemoAndFile(MemoVO memoVO, MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertMemoAndFiles(MemoVO memoVO, MultipartHttpServletRequest files) {
		// TODO Auto-generated method stub
		return null;
	}

	




}
