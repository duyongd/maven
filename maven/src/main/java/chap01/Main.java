package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class); // greeter라는 이름으로 빈등록
		
		//Greeter g = (Greeter)ctx.getBean("greeter");
		Greeter g = (Greeter)ctx.getBean("greeter", Greeter.class);
		System.out.println(g.greet("홍길동"));
	}

}
