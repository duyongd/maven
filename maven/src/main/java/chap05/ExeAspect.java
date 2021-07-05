package chap05;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExeAspect {
	
	@Pointcut("execution(public * chap05..*(..))") //chap05에 있는 모든 public 메소드
	private void publicTarget() {}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long end = System.nanoTime();
			System.out.println("AOP : " + (end-start));
		}
	}
}
