package com.callor.memo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/memo")
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@RequestMapping(value="/memo_home", method=RequestMethod.GET)
	public String memo_home(HttpSession httpSession, Model model) {
		
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username != null) {
			List<MemoVO> memos = memoService.findByAuthor(username);
			model.addAttribute("MEMOS", memos);
		}
		return null;
		
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert(@ModelAttribute("memo") MemoVO memo, 
			HttpSession httpSession) {
		
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		memo.setM_author(username);
		
		
		return "memo/insert";
	}
	
	@RequestMapping(value="/{seq}/detail", method=RequestMethod.GET)
	public String detail(@PathVariable("seq") String seq,
					@ModelAttribute("memo") MemoVO memoVO, Model model) {
		long m_seq = Long.valueOf(seq);
		memoVO = memoService.findById(m_seq);
		model.addAttribute("MEMO", memoVO);
		
		return "memo/detail";
		
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, Model model) {
		
		// 전달받은 seq 에 해당하는 데이터 select
		MemoVO memo = memoService.findById(Long.valueOf(seq));
		model.addAttribute("MEMO", memo);
		
		return "memo/insert";                                                                                                                                                                                                                                                                      
		
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.POST)
	public String update(
			@PathVariable("seq") String seq,
			@ModelAttribute("memo") MemoVO memoVO, 
			MultipartFile file,
			HttpSession httpSession) {
	
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		
		// 로그인된 사용자의 이름을 memoDTO 에 setting 하기
		memoVO.setM_author(username);
		
		// 주소에 따라온 seq 변수값을 추출하여 memoDTO 에 setting 하기
		long m_seq = Long.valueOf(seq);
		memoVO.setM_seq(m_seq);
				
		log.debug(memoVO.toString());
		
		memoService.insertAndUpdate(memoVO, file);
		
		
		return String.format("redirect:/memo/%s/detail", seq);
		
	}
		
	
	@RequestMapping(value="/{seq}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("seq") String seq) {
		
		memoService.delete(Long.valueOf(seq));
		return "redirect:/memo/memo_home";
		
	}

	/*
	 * 첨부파일이 있는 프로젝트에서
	 * form 의 file input box 의 이름은 절대 VO(DTO) 클래스에 선언된 이름을 사용하면 안된다.
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(
			@ModelAttribute("memo")
			MemoVO memo, MultipartFile file, HttpSession httpSession) {
		
		// 메모를 저장하기 전에 현재 session 에 저장된 username 가져오기
		String username = (String)httpSession.getAttribute("USERNAME");
		// 저장할 메모 정보에 username 세팅
		memo.setM_author(username);
		
		memoService.insertAndUpdate(memo, file);
		
		log.debug("메모 {}", memo.toString());
		log.debug("파일 {}", file.getOriginalFilename());
		
		return "redirect:/memo/memo_home";
	}
	
	@ModelAttribute("memo")
	private MemoVO memoVO() {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat toDay = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat toTime = new SimpleDateFormat("HH:mm:SS");
		
		MemoVO memo = MemoVO.builder()
						.m_date(toDay.format(date))
						.m_time(toTime.format(date))
						.build();
		
		return memo;
		
	}
	
}