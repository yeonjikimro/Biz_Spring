package com.callor.address.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	private final AddressService addrService;

	public HomeController(AddressService addrService) {
		this.addrService = addrService;
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, @RequestParam(name = "pageno", required = false, defaultValue = "0") int pageno) {

		// List<AddressVO> addrList = addrService.selectAll();
		// limit : 한페이지 당 보여지는 데이터 수
		// offset : 클릭할 페이지 수
		SearchPage searchpage = SearchPage.builder().a_name("").limit(10).offset(pageno * 10).build();
		
		searchpage.setCurrentPageNo(pageno);
		
		// 페이지 계산
		addrService.searchAndPage(model, searchpage);
		
		// 데이터 가져오기
		List<AddressVO> addrList = addrService.searchAndPage(searchpage);

		log.debug(addrList.toString());

		model.addAttribute("ADDS", addrList);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String info(AddressVO addressVO, Model model) {

		log.debug("받은 데이터 {}", addressVO.toString());

		addrService.insert(addressVO);

		return "redirect:/";
	}

	// 쿼리스트링 방식
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(@RequestParam("seq") String strSeq, Model model, AddressVO addressVO) {
		/*
		 * 숫자형 매개변수를 사용하면서 400 오류를 방지하는 코드( 이 코드를 더 권장)
		 * 
		 * @RequestPara(name = "seq", required = false, defaultValue = "0") long a_seq)
		 */
		log.debug("SEQ {}", strSeq);

		long a_seq = Long.valueOf(strSeq);
		log.debug("SEQ {}", a_seq);

		AddressVO add = addrService.findById(a_seq);

		model.addAttribute("ADD", add);
		return "detail";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(@RequestParam(name = "seq", required = false, defaultValue = "0") long a_seq, Model model) {

		AddressVO add = addrService.findById(a_seq);
		model.addAttribute("ADD", add);

		return "home";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestParam("seq") long seq, AddressVO address) {
		address.setA_seq(seq);
		addrService.update(address);

		return "redirect:/detail?seq=" + seq;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("seq") long seq, AddressVO address) {

		addrService.delete(seq);

		return "redirect:/";

	}

}
