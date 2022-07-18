package com.callor.hello.persistance;

import java.util.List;

import com.callor.hello.model.AddressVO;
import com.callor.hello.service.HomeService;

public interface AddressDao{
	
	public List<AddressVO> selectAll();
	public AddressVO finById(long seq);
	
	public int insert(AddressVO vo);
	public int update(AddressVO vo);
	public int delete(AddressVO vo);

}
