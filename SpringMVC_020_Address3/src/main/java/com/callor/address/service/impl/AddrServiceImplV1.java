package com.callor.address.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.callor.address.config.QualifyConfig;
import com.callor.address.model.AddressVO;
import com.callor.address.model.SearchPage;
import com.callor.address.persistance.AddressDao;
import com.callor.address.service.AddressService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service(QualifyConfig.SERVICE.ADDR_V1)
public class AddrServiceImplV1 implements AddressService {

	/*
	 * Service interface 에서 Dao 를 상속받고 있는 상태에서 ServiceImpl 클래스에서 Dao 를 생성자로 주입받는 경우
	 * 생성자에서 오류가 발생하는 경우가 있다 ** circular reference: 무한 반복 주입 오류, 순환참조 오류 이 오류가 발생하는
	 * 경우 생성자 주입 대신 setter 주입으로 변경하면 오류가 발생하지 않는다
	 */

	// setter 주입 시 final 사용 금지
	// @Autowired
	// private AddressDao addrDao;
	// public AddrServiceImplV1() { }

	private AddressDao addDao;

	public AddrServiceImplV1(AddressDao addrDao) {
		this.addDao = addrDao;
	}

	// 프로젝트가 시작될 때 table 을 자동으로 생성하기 위한 자동실행 method
	@Autowired
	public void create_table() {
		addDao.create_addr_table();
	}

	@Override
	public List<AddressVO> selectAll() {
		// TODO Auto-generated method stub

		return addDao.selectAll();
	}

	@Override
	public AddressVO findById(long a_seq) {
		// TODO Auto-generated method stub
		AddressVO add = addDao.findById(a_seq);
		return add;
	}

	@Override
	public int insert(AddressVO address) {
		// TODO Auto-generated method stub
		addDao.insert(address);
		log.debug("서비스에서 받은 데이터 {}", address.toString());

		return 0;
	}

	@Override
	public int update(AddressVO address) {
		// TODO Auto-generated method stub
		return addDao.update(address);
	}

	@Override
	public int delete(long a_seq) {
		// TODO Auto-generated method stub
		return addDao.delete(a_seq);
	}

	/*
	 * 이 method 에서 dao 의 create_addr_table() method 를 호출하여 table 을 생성해도 된다
	 * 
	 * 이 method 에서 dao 같은 이름의 method 를 호출하면 여기에서도 circular reference 오류가 발생하는 경우가 있다
	 * 
	 * 때문에 이 method 를 사용하지 않고 별도의 method 를 만들어 사용한다.
	 */
	@Override
	public void create_addr_table() {

	}

	/*
	 * search 문자열이 null 일 경우 전체 데이터를 조회할 수 있도록 만드는 코드를
	 * Controller 에서 Service 로 이동
	 * 
	 */
	@Override
	public List<AddressVO> searchAndPage(SearchPage searchPage) {

		return addDao.searchAndPage(searchPage);
	}

	// 한 페이지에 보여질 데이터 리스트 개수
	private static final long LIST_PER_PAGE = 10;
	
	// 화면 하단에 페이지 번호 출력 개수
	private static final long PAGE_NO_COUNT = 10;
	
	/*
	 * 조건에 맞는 데이터를 가져와서 pagination 을 그리기 위한 SearchPage 클래스이 데이터를 만들 것
	 * 
	 */
	@Override
	public void searchAndPage(Model model, SearchPage searchPage) {
		
		// pagination 을 구현하기 위하여 전체 데이터 가져오기로 개수를 임시로 세팅
		searchPage.setOffset(0);
		searchPage.setLimit(addDao.selectAll().size());
		
		// 1. 전체 데이터 개수가 몇 개인지를 알아야 pagination 을 구현할 수 있다
		// 		화면 하단의 페이지 번호를 자동으로 계산하기 위함이다

		// 검색어 없이 요청이 될 경우 SearchPage 객체의 search 값이 null 이 되어
		// 데이터가 검색이 되지 않는다
		// 그렇기 때문에 SearchPage 객체의 search 변수값을 "" 으로 세팅
		String search = searchPage.getSearch();
		search = search == null ? "" : search;
		searchPage.setSearch(search);

		
		// 검색어 조건에 맞는 모든 데이터를 일단 select;
		List<AddressVO> addrList = addDao.searchAndPage(searchPage);

		long totalCount = addrList.size();
		if(totalCount < 1) return ;
		
		// 전체 데이터의 총 페이지 수
		// 전체 데이터 개수를 한 페이지에 보여질 데이터 개수로 나누기
		// 		만약 전체 데이터가 37 개이고 한 페이지에 10개를 보여준다면
		// 		finalPageNo 는 3이 될 것이다		
		long finalPageNo = totalCount / LIST_PER_PAGE;
		
		// 화면 하단의 페이지 번호를 클릭 했을 때 전달되는 값
		// 요청한 페이지가 마지막 페이지보다 크면 마지막페이지를 currnetPage 에 저장하게 한다.
		// 삼항연산자 사용
		long currentPageNo = searchPage.getCurrentPageNo();
		
		currentPageNo = currentPageNo > finalPageNo ? finalPageNo : currentPageNo;
		
		// 요청한 페이지가 1보다 작을 때 1을 담아라.
		currentPageNo = currentPageNo > 1?
						(currentPageNo > finalPageNo ? finalPageNo : currentPageNo) : 1;
		
		
		// if 문 사용
		//첫번째
		if(currentPageNo > finalPageNo) {
			currentPageNo = finalPageNo;
		}
		//두번째
		if(currentPageNo < 1 ) {
			currentPageNo = 1;
		}
		
		// 선택된 페이지 번호에 따라 화면하단 번호 리스트를 유동적으로 보여주기 위한 연산
		
		// 선택된 페이지가 맨 앞으로 나오게, 범위가 벗어나면 유효한 범위로 나타나게 설정
		long startPageNo = (currentPageNo / PAGE_NO_COUNT) * PAGE_NO_COUNT;
		startPageNo = startPageNo < 1 ? 1 : startPageNo;
		
		
		long endPageNo = startPageNo + PAGE_NO_COUNT;
		endPageNo = endPageNo > finalPageNo ? finalPageNo : endPageNo;
		
		
		searchPage.setStartPageNo(startPageNo);
		searchPage.setEndPageNo(endPageNo);
		searchPage.setLimit(LIST_PER_PAGE);
		searchPage.setPageNoCount(PAGE_NO_COUNT);
		searchPage.setOffset( (currentPageNo - 1) * PAGE_NO_COUNT);
		searchPage.setFinalPageNo(finalPageNo);
		
		// JSP 로 보내기 위해서 model 에 담기
		model.addAttribute("PAGE", searchPage);
	}

}
