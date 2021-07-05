package chap09;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages= {"chap09"}) //chap06 모두 뒤져서 component 붙어있는걸 빈으로 등록
@EnableWebMvc //Enable 켜다 //스프링의 webmvc기능을 사용하겠다라는 뜻
@EnableTransactionManagement
public class MvcConfig implements WebMvcConfigurer{
	
	@Value("${db.driver}")
	private String driver;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")	
	private String password;
	
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
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
		ssfb.setDataSource(dataSource());
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		ssfb.setMapperLocations(resolver.getResources("classpath://mapper/**/*.xml"));
		return ssfb.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception{
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
	}
	
	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry reg) {
		reg.addInterceptor(loginInterceptor()).addPathPatterns("/member/mypage.do");
		
		//excludePathPatterns()
		//관리자 : .addPathPatterns("/admin/**").excludePathPatterns("/admin/index.do")
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		PropertySourcesPlaceholderConfigurer conf = new PropertySourcesPlaceholderConfigurer();
		conf.setLocations(new ClassPathResource("db.properties"));
		return conf;
	}
	
	@Bean
	public PlatformTransactionManager txmanager() {
		DataSourceTransactionManager ptm = new DataSourceTransactionManager();
		ptm.setDataSource(dataSource());
		return ptm;
	}
}
