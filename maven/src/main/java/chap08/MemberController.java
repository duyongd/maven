package chap08;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping("/member/index.do")
	public String index(Model model) {
		List<MemberVo> list = service.selectList();
		model.addAttribute("list", list);
		return "member/index";
	}
	
	@RequestMapping("/member/form.do")
	public String form(MemberVo vo,@CookieValue(value="cookieEmail", required=false) Cookie cookie) { //required는 null값일때도 오류가 안남
		if(cookie != null) {//spring이 알아서 MemberVo를  memberVo로 request저장소에 넣어줌 
			vo.setEmail(cookie.getValue());
			vo.setCheckEmail("check");
		}
		return "member/form";
	}
	
	@RequestMapping("/member/login.do")
	public String login(MemberVo vo, HttpSession sess, HttpServletRequest req, HttpServletResponse res) throws Exception{
		MemberVo m = service.login(vo);
		if(m != null) {
			//세션에 저장
			//세션객체를 가져오는 방법
			//1. HttpServletRequest를 통해
			//HttpSession session = req.getSession(); // 아무것도 안쓰면 false와 같음
			//getSession(true) :세션이존재하지 않으면 새로 생성해서 리턴
			//getSession(false) : 세션이 존재하지 않으면 null을 리턴
			//2. 매게변수로 HttpSession
			
			//세션에 저장(세션은 서버에 저장됨)
			sess.setAttribute("memberInfo", m);
			//쿠키에 저장
			Cookie cookie = new Cookie("cookieEmail", vo.getEmail());
			cookie.setPath("/");
			if("check".equals(vo.getCheckEmail())) {
				cookie.setMaxAge(60*60*24*365);
			} else {
				cookie.setMaxAge(0);
			}
			res.addCookie(cookie);
			return "redirect:index.do";
		} else {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('이메일과 비밀번호가 올바르지 않습니다.');");
			out.println("location.href='form.do';");
			out.println("</script>");
			return null;
		}	
		
	}
	@RequestMapping("/member/logout.do")
	public String logout(Model model,HttpSession sess, HttpServletResponse res) throws Exception {
		sess.invalidate();
		model.addAttribute("msg","로그아웃되었습니다.");
		model.addAttribute("url", "index.do");
		return "include/alert";
	}
	
	@RequestMapping("/member/mypage.do")
	public String mypage(Model model,HttpSession sess) throws Exception {
		//세션에서 MemberVo객체를 가져오기
//		MemberVo vo = (MemberVo)sess.getAttribute("memberInfo");
//		if(vo != null) {
//			MemberVo m = service.mypage(vo.getMno());
//			model.addAttribute("vo", m);
//			return "member/mypage";
//		} else {
//			model.addAttribute("msg","로그인 후 사용가능합니다.");
//			model.addAttribute("url", "index.do");
//			return "include/alert";
//		}
		return service.mypage(sess, model);
	}
	
	@RequestMapping("/member/update.do")
	public String update(Model model, MemberVo vo) {
		int r = service.update(vo);
		if(r==0) {
			model.addAttribute("msg","수정실패");
			model.addAttribute("url","mypage.do");
			return "include/alert";
		} else {
			model.addAttribute("msg","수정성공");
			model.addAttribute("url","mypage.do");
			return "include/alert";
		}
	}
}
