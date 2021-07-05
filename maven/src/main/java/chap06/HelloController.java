package chap06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	
	
	@RequestMapping(value = "/hello.do", method=RequestMethod.GET ) // get방식으로만 접속됨
	public String hello(Model model) {
		model.addAttribute("name", "홍길동"); // model 은 저장소임
		return "hello";
	}
	
	@PostMapping("/hello2.do") //get 은 get방식으로만 처리가능 리퀘스트는 get post 둘다 됨
	public String hello2(Model model) {
		model.addAttribute("name", "홍길동"); // model 은 저장소임
		return "hello";
	}
	
	@GetMapping("/board/write.do") 
	public String write(Model model) {
		model.addAttribute("name", "홍길동"); 
		return "hello";
	}
	
	@PostMapping("/board/write.do") 	//반드시post방식으로 해야될때가 있음
	public String write2(Model model) {
		model.addAttribute("name", "홍길동"); 
		return "hello";
	}
}
