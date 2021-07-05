package chap06;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages= {"chap06"}) //chap06 모두 뒤져서 component 붙어있는걸 빈으로 등록
@EnableWebMvc //Enable 켜다 //스프링의 webmvc기능을 사용하겠다라는 뜻
public class MvcConfig implements WebMvcConfigurer{
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
		conf.enable(); //css,js파일을 불러올수 있게 해줌 매핑되지 않은 것들을 불러올수 있게 해줌 /이걸로 설정했기 때문에
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry reg) {
		//(jsp가 있는 경로[시작경로], 확장자)
		reg.jsp("/WEB-INF/view/", ".jsp"); // jsp 경로를 설정 // return "/WEB-INF/view/  member/MemberList  .jsp"
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		//비즈니스로직이 필요없는(디자인만 있는 페이지) url과 jsp매핑
		// index.do 요청이 들어올때 index를 매핑한것
		reg.addViewController("/index.do").setViewName("index");
	}
}
