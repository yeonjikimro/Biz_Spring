package com.callor.score.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

@Controller
@RequestMapping(value="/student")
public class StudentController {
	
	public StudentService strService;
	public StudentController(StudentService strService) {
		this.strService = strService;
	}
	
	// JSON type 으로 return
	@ResponseBody
	@RequestMapping(value={"/", ""}, method=RequestMethod.GET)
	// 학생리스트를 return 하기 위해 return type List<StudentVO>
	public List<StudentVO> home() {
		
		List<StudentVO> strList = strService.selectAll();
		
		
		return strList;
	}

}
