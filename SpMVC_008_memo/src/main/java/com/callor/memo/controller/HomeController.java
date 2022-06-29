package com.callor.memo.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

<<<<<<< HEAD
=======
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 60bc61ab5f327f32b0c405442bc3fee930d635b8
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.memo.model.MemoVO;
import com.callor.memo.service.MemoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	private final MemoService memoService;
	public HomeController(MemoService memoService) {
		
		this.memoService = memoService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession httpSession) {
		
		String username = (String) httpSession.getAttribute("USERNAME");
		if(username != null) {
			List<MemoVO> memos = memoService.findByAuthor(username);
			model.addAttribute("MEMOS", memos);
		}
		
		
		return "home";
	}
<<<<<<< HEAD
	
}
=======

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpSession httpSession) {

		String username = (String) httpSession.getAttribute("USERNAME");
		if(username == null) {
			return "redirect:/user/login";
		}
		
		return "insert";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(Model model, @ModelAttribute("memoVO") MemoVO memoVO,
			@RequestParam("fileup") MultipartFile fileup, SessionStatus status) {
		log.debug(fileup.toString());

		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		try {
			String fileName = fileupService.fileUp(fileup);
			memoVO.setM_image(fileName);
		} catch (Exception e) {
			e.printStackTrace();
		}

		log.debug("여기확인" + memoVO.toString());
		memoVO.setM_date(dayFormat.format(date));
		memoVO.setM_time(timeFormat.format(date));

		memoService.insert(memoVO);
		status.setComplete();
		return "redirect:/";

	}

	@RequestMapping(value = "/{seq}/detail", method = RequestMethod.GET)
	public String detail(@PathVariable("seq") long seq, Model model) {
		MemoVO memoVO = memoService.findById(seq);
		model.addAttribute("MEMO", memoVO);

		return "detail";
	}

	@RequestMapping(value = "/{seq}/update", method = RequestMethod.GET)
	public String update(@PathVariable("seq") long m_seq, Model model) {

		MemoVO memoVO = memoService.findById(m_seq);
		model.addAttribute("MEMO", memoVO);

		return "insert";
	}

	@RequestMapping(value = "/{seq}/update", method = RequestMethod.POST)
	public String update(MemoVO memoVO) {
		log.debug("여기두번" + memoVO.toString());
		int ret = memoService.update(memoVO);
		
		log.debug("여기"+ ret);
		
		
		
//		log.debug(up_file.toString());
//
//		Date date = new Date(System.currentTimeMillis());
//		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
//
//		try {
//			String fileName = fileupService.fileUp(up_file);
//			memoVO.setM_image(fileName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		memoVO.setM_date(dayFormat.format(date));
//		memoVO.setM_time(timeFormat.format(date));
//		memoService.update(memoVO);
//
//		status.setComplete();

		return "redirect:/";
	}

	@RequestMapping(value = "/{seq}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("seq") long id) {

		memoService.delete(id);
		return "redirect:/";
	}

	@ModelAttribute("memoVO")
	private MemoVO memoVO() {
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

		return MemoVO.builder().m_date(dayFormat.format(date))
					.m_time(timeFormat.format(date))
					.m_author("ddd").build();
	}

}
>>>>>>> 60bc61ab5f327f32b0c405442bc3fee930d635b8
