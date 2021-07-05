package aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chap05.Calculator;
import chap05.ExeAspect;
import chap05.ImplCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	@Bean
	public ExeAspect exeAspect() {
		return new ExeAspect();
	}

	@Bean
	public Calculator calculator() {
		return new ImplCalculator();
	}
}
