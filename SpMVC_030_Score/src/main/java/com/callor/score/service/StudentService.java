package com.callor.score.service;

import java.util.List;

import com.callor.score.model.StudentVO;
import com.callor.score.persistance.StudentDao;

public interface StudentService  extends StudentDao{	
	
	public List<StudentVO> selectAll();
}
