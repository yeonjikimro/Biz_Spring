package com.callor.memo.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.memo.model.AddressVO;
import com.callor.memo.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value="/tel")
public class TelController {

		
		private final AddressService addrService;

		public TelController(AddressService addrService) {
			this.addrService = addrService;
		}

		@RequestMapping(value = "/tel_list", method = RequestMethod.GET)
		public String home(Model model) {

			List<AddressVO> addrList = addrService.selectAll();
			log.debug(addrList.toString());

			model.addAttribute("ADDS", addrList);

			return "home";
		}

		@RequestMapping(value = "/tel_list", method = RequestMethod.POST)
		public String info(AddressVO addressVO, Model model) {

			log.debug("받은 데이터 {}", addressVO.toString());

			addrService.insert(addressVO);

			return "redirect:/";
		}

		// 쿼리스트링 방식
		@RequestMapping(value = "/tel_detail", method = RequestMethod.GET)
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

		@RequestMapping(value="/update", method=RequestMethod.POST)
		public String update(@RequestParam("seq") long seq, AddressVO address) {
			address.setA_seq(seq);
			addrService.update(address);
			
			return "redirect:/detail?seq=" + seq;
		}
		
		@RequestMapping(value="/delete", method=RequestMethod.GET)
		public String delete(@RequestParam("seq") long seq, AddressVO address) {
			
			addrService.delete(seq);
			
			return "redirect:/";
			
		}
		
	}


