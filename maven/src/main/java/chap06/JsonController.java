package chap06;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//jackson 검색 dependency 추가

@RestController //json 데이타로 자동으로 만들어줌
public class JsonController {

	@GetMapping("/api/test")
	public MemberVo test() {
		MemberVo vo = new MemberVo();
		vo.setName("홍길동");
		vo.setEmail("hong");
		vo.setNo(1);
		return vo;
	}
	
	//파라미터를 받는 4번째 방법
	//@PathVariable
	// /api/list/1 ->1페이지
	// /api/list/2 -> 2페이지
	
	@GetMapping("/api/list/{page}/{searchWord}")
	public List<MemberVo> list(@PathVariable int page, 
								@PathVariable String searchWord) {
		System.out.println("page: " + page);
		System.out.println("searchWord:" + searchWord);
		
		MemberVo vo = new MemberVo();
		vo.setName("홍길동");
		vo.setEmail("hong");
		vo.setNo(1);
		List<MemberVo> list = new ArrayList<MemberVo>();
		list.add(vo);
		list.add(vo);
		return list;
	}
	
}
