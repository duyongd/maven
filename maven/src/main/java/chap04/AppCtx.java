package chap04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"chap04"})
public class AppCtx {
	
//	@Bean
//	public MemberDao memberDao() {
//		return new MemberDao();
//	}
	
	@Bean
	public MemberRegisterService regSvc() {
		return new MemberRegisterService();
	}
	
	@Bean
	public ChangePasswordService pwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		//pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	
	@Bean
	public MemberListService listSvc() {
		return new MemberListService();
	}
	
	@Bean
	public MemberInfoService infoSvc() {
		return new MemberInfoService();
	}
}
