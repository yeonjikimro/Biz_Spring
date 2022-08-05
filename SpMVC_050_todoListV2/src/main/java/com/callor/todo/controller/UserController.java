package com.callor.todo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.UserVO;
import com.callor.todo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		
		return "user/login";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		
		return "user/join";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(UserVO userVO) {
		
		log.debug("회원가입 데이터 : {}", userVO);
		
		userService.insert(userVO);
		
		return "redirect:/login";
	}
	
	@PreAuthorize("hasAnyRole(['ROLE_USER', 'ROLE_ADMIN'])")
	@RequestMapping(value="/mypage", method=RequestMethod.GET)
	public String mypage(Principal principal) {
		
		String username = principal.getName();
		
		return "user/mypage";
	}

}
