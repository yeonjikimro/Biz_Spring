package com.callor.score.controller.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.callor.score.model.StudentVO;
import com.callor.score.service.StudentService;

import lombok.extern.slf4j.Slf4j;

/*
 * @Controller 클래스는 request(요청)에 대하여 보통 view(.jsp) 파일을
 * rendering 하여 response(응답) 하도록 설계하는 Router 클래스이다
 * 
 * 이 클래스에 @ResponseBody 를 부착하면 View 를 response 하는 대신에
 * 직접 문자열을 전송하거나 객체 (List, VO)를 JSON type 으로 response 하도록
 * method 에 적용을 한다.
 * 
 *  @RestController 클래스는 request 에 대해서 기본값으로
 *  JSON 을 Response 하도록 설게하는 Router 클래스이다.
 *  
 *  모든 method 에 마치 @ResponseBody가 부착된 것처럼 작동을 한다.
 *  Spring RestController를 통하여 JSON 데이터를 response 하기 위해서는
 *  JackBind Dependency가 거의 필수적으로 요구된다.
 *  
 *  RestController 는 view를 rendering 하지 않는다.
 */

// CORS 오류로 인한 문제를 서버 차원에서 개발하여 처리하기
@CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000", "http://192.168.0.*:3000"})
@RestController
@RequestMapping(value="/api/student")
@Slf4j
public class APIStudentController {

	private final StudentService stService;

	public APIStudentController(StudentService stService) {
		this.stService = stService;
	}
	
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public List<StudentVO> student() {
		return stService.selectAll();			
	}
	
	@RequestMapping(value="/{st_num}/check", method=RequestMethod.GET)
	public String stNumCheck(@PathVariable("st_num") String st_num) {
		
		StudentVO stVO = stService.findById(st_num);
		
		if(stVO == null) {
			return "OK";
		} else {
			return "FAIL";
		}
		
	}
	
	@RequestMapping(value="/{st_num}", method=RequestMethod.GET)
	public StudentVO getStudent(@PathVariable("st_num") String st_num) {
		
		return stService.findById(st_num);
	}
	
	/*
	 * http://localhost:8080/score/api/student/학번/delete 로 요청을 했을 때
	 * 학번에 해당하는 학생의 데이터를 삭제할 수 있도록 method 생성
	 * stService.delete(학번), stDao.delete(학번), student-mapper.xml.delete 를
	 * 작성하여 학생의 데이터를 삭제할 수 있도록 코드 작성 
	 */
	
	
	/*
	 * Client 에서 fetch, Ajax 데이터를 POST 보낼 때
	 * 데이터를 Serialize(직렬화) 하여 BODY에 담아서 전송을 한다
	 * Serialize 된 POST BODY에 담긴 데이터를 Controller 에서 VO 로 받을 때는
	 * 반드시 @RequestBody 속성을 추가하여 주어야 한다.
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@RequestBody StudentVO stVO) {
		log.debug("전달받은 데이터 {}", stVO.toString());
		int ret = stService.insert(stVO);
		if(ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}
	}
	 
		@RequestMapping(value="/upadate", method=RequestMethod.POST)
		public String update(@RequestBody StudentVO stVO) {
			log.debug("전달받은 데이터 {}", stVO.toString());
			int ret = stService.update(stVO);
			if(ret > 0) {
				return "OK";
			} else {
				return "FAIL";
			}
		}
		
	
	@RequestMapping(value="/{st_num}/delete", method=RequestMethod.GET)
	public String delete(@PathVariable("st_num") String st_num, StudentVO stVO) {
		
		/*
		 * mybatis 에서 delete 를 수행한 후 몇 개의 데이터가 삭제되었느지를 return 해준다
		 * 여기서는 pk 를 기준으로 삭제하기 때문에
		 * return 값은 삭제가 되었으니 1이 될 것이고,
		 * 삭제에 실패했으면 1 미만의 값이 return
		 */
		int ret = stService.delete(st_num);
		
		if(ret > 0) {
			return "OK";
		} else {
			return "FAIL";
		}

	}
	
	
	
	
	/*
	 * method 의 return type
	 * 
	 * void type : 아무것도 아닌 값을 return(return;) 하거나 return을 하지 않는다.
	 * public void voidMethod() {
	 * 		return;
	 * }
	 * 
	 * primitive type : 정수, 실수, 문자 등등 기본 type 의 값을 return
	 * public int intMethod() {
	 * 		return 0;
	 * }
	 * 
	 * class(참조) type : String, VO. DTO, List 등의 클래스(객체) type return
	 * public String strMethod() {
	 * 		return null; // return 할 값이 없으면 최소 null 이라도 return
	 * }
	 * 
	 */

	
	
	
	
	
}
