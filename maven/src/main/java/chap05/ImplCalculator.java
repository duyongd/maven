package chap05;

public class ImplCalculator implements Calculator {

	@Override
	public long factorial(long num) {
		// 4! -> 4*(4-1)*(3-1)*(2-1)
		//long start = System.currentTimeMillis();
		long result = 1;
		for(long i=1; i<=num; i++) {
			result *= i;
		}
		//long end = System.currentTimeMillis();
		//System.out.println("for문 : " + (end-start));
		return result;
	}

}
