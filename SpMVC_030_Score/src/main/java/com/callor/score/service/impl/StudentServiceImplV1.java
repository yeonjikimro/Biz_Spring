package com.callor.score.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;
import com.callor.score.service.StudentService;

@Service
public class StudentServiceImplV1 implements StudentService {

	private final StudentDao strDao;
	public StudentServiceImplV1(StudentDao strDao) {
		this.strDao = strDao;
	}
	
	@Override
	public List<StudentVO> selectAll() {
		// TODO Auto-generated method stub
		return strDao.selectAll();
	}

	@Override
	public StudentVO findById(String id) {
		// TODO Auto-generated method stub
		return strDao.findById(id);
	}

	@Override
	public int insert(StudentVO vo) {
		// TODO Auto-generated method stub
		return strDao.insert(vo);
	}

	@Override
	public int update(StudentVO vo) {
		// TODO Auto-generated method stub
		return strDao.update(vo);
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return strDao.delete(id);
	}

	
	
}
