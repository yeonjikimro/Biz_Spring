package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.AddressVO;

public interface AddressDao {

	public void create_addr_table();
	public List<AddressVO> selectAll();
	public AddressVO findById(long a_seq);
	public int insert(AddressVO address);
	public int update(AddressVO address);
	public int delete(long a_seq);
 
	
}
