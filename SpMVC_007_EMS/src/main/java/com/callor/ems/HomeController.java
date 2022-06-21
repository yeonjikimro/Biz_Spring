package com.callor.ems;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Value("#{naver['naver.username']}")
	private String naver_username;
	
	@Value("#{app['my.app']}")
	private String myApp;
	
	@Autowired
	private StandardPBEStringEncryptor pbEnc;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		Pattern PATT_BLACKET = Pattern.compile("\\([^\\(\\)]+\\)");
		Matcher matcher = PATT_BLACKET.matcher(naver_username);
		if(matcher.find()) {
			int startIndex = matcher.start();
			int endIndex = matcher.end();
			String findText = naver_username.substring(startIndex + 1, endIndex - 1);
			String user = pbEnc.decrypt(findText);
			log.debug("NaverUser {}", user);
		}
		
		log.debug("Naver User Name {}", naver_username);
		log.debug("앱 이름 {}", myApp);
		return "home";
	}
	
}
