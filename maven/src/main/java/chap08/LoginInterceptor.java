package chap08;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	
	/*
	 prehandle : 컨트롤러 실행 전 // 보통은 이거 많이씀
	 postHandle : 컨트롤러 실행 후 (뷰 리턴전)
	 afterCompletion :뷰 실행 후
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {
		//세션객체에서 memberinfo 를 가지고 와서 있으면(로그인되어 있으면 ) true
		//없으면 (미 로그인) false
		HttpSession sess = req.getSession();
		MemberVo vo=(MemberVo)sess.getAttribute("memberInfo");
		if(vo == null) {
			res.setContentType("text/html;charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인후 사용가능합니다.');");
			out.println("location.href='index.do';");
			out.println("</script>");
			return false;
		} else {
			return true;
		}
	}
}
