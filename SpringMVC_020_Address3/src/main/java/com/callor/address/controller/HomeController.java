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
	public String home(Model model, 
			@RequestParam(name = "pageno", required = false, defaultValue = "0") int pageno,
			SearchPage searchPage

			) {
		
		
		// List<AddressVO> addrList = addrService.selectAll();
		// limit : 한페이지 당 보여지는 데이터 수
		// offset : 클릭할 페이지 수
		
		searchPage.setCurrentPageNo(pageno);		
		// 페이지 계산
		addrService.searchAndPage(model, searchPage);
		
		// 데이터 가져오기
		List<AddressVO> addrList = addrService.searchAndPage(searchPage);

		log.debug(addrList.toString());

		model.addAttribute("ADDS", addrList);

		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(AddressVO addressVO) {

		log.debug("받은 데이터 {}", addressVO.toString());

		addrService.insert(addressVO);

		return "redirect:/";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		return "write";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(AddressVO addr) {
		addrService.insert(addr);
		
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

		return "write";
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
	
	/*
	 * Controller 의 method 에서 문자열을 return 하면
	 * tiles/layout.xml 파일에서 해당하는 문자열로 선언된 definition 을 찾는다(order = 1)
	 * 해당하는 문자열로 선언된 definition 이 있으면 layout.xml 에 설정된
	 * tiles 가 작동되어 layout을 만들고 rendering 하여 응답을 한다
	 * 
	 * 만약 layout.xml에 해당하는 definition 이 없으면 
	 * InternalResourceViewResolver 가 작동되어 /views/문자열.jsp 파일을 찾아서(order = 2)
	 * rendering 하여 응답한다.
	 */
	@RequestMapping(value="/about", method=RequestMethod.GET)
	public String about() {
		return "about";		
	}

}
