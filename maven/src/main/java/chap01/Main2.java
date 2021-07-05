package chap01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chap01/beans.xml"); // greeter라는 이름으로 빈등록
		
		Greeter g = (Greeter)ctx.getBean("greeter");
		System.out.println(g.greet("홍길동"));
	}
}
