package chap06;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller // 이걸 깜박하고 안넣으면 빈에 등록이 안됨 
public class FormController {
	
//	@RequestMapping("/index.do")
//	public String index() {
//		return "index";
//	}
	//리턴이 없으면 매핑된 url과 동일한 경로로 jsp를 포워딩
	//서블릿으로 응답 가능
	@RequestMapping("/test.do")
	public void test(HttpServletResponse res) throws IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.print("<script>alert('정상적으로 저장되었습니다.');</script>");
	}
	
	@RequestMapping("/")
	public String index() {
		return "redirect:index.do";
	}
	
	@RequestMapping("/form.do")
	public String form() {
		return "form";
	}
	
	@RequestMapping("/send.do")
	public String send(Model model, HttpServletRequest req, @RequestParam(value = "name",required = false) String name2,
						@RequestParam(value="email",required=false) String email2,
						@RequestParam(value="no",required=false, defaultValue="0") int no, //defaultValue 이것은 기본자료형이기때문에 null값이 안됨으로 0값으로 초기화해준것
						MemberVo vo) {//HttpServletRequest 파라미터로 넣어주면 자동으로 spring이 넣어줌
		//파라미터를 받는방법				// 	@RequestParam("name") 이것은 null값을 받을 수 없음 그래서 ,required = false이것을 써주면 null값이 들어가도 오류안남
		//1.HttpServletrequest		//	@RequestParam(value="no"와 MemberVo 는 Integer.parseInt를 할 필요 없다 
		String name=req.getParameter("name"); // MemberVo vo 는 자동으로 request.setAttribute가 됨으로 ${memberVo} 로 사용가능
		String email=req.getParameter("email");
		//2.@RequestParam
		// @RequestParam("파라미터명") : 매개변수에 지정
		
		System.out.println(vo.getHobby().length);
		for(int v : vo.getHobby()) {
			System.out.println(v);
		}
		
		//3.커맨드객체 MemberVo vo
		model.addAttribute("name1",name);
		model.addAttribute("email1",email);
		model.addAttribute("name2",name2);
		model.addAttribute("email2",email2);
		model.addAttribute("no",no);
		//model.addAttribute("vo",vo);
	
		if(email == null || "".equals(email)) {
			return "form";
		}
		
		return "send";
	}
	
	//ModelAndView 객체 리턴
	@RequestMapping("/main.do")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("name","홍길동");
		mav.setViewName("main");
		return mav;
	}
}
