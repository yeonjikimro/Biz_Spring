package com.callor.hello.service;

import com.callor.hello.model.AddressVO;

public interface HomeService {
	
	public String hello();
	public String hello(String name);
	public String goodBye() ;
	public String goodBye(String name);
	
	public int insert(String ad_name, String ad_tel, String ad_addr);
	public int insert(AddressVO address);
	
	public AddressVO findByName(String ad_name);
	
}