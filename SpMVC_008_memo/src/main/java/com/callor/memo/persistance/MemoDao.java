package com.callor.memo.persistance;

import java.util.List;

import com.callor.memo.model.MemoVO;

public interface MemoDao {
	
	public List<MemoVO> selectAll();
	public MemoVO findById(Long seq);
	public int insert(MemoVO memo);
	public int update(MemoVO memo);
	public int delete(Long seq);
	
	public List<MemoVO> findByMemo(String memo);
	public List<MemoVO> findByAuthor(String author);
	
	public void create_memo_table();

}