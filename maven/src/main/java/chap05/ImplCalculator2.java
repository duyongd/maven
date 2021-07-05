package chap05;

public class ImplCalculator2 implements Calculator {

	@Override
	public long factorial(long num) {
		// 4! -> 4*(4-1)*(3-1)*(2-1)
		// 재귀호출
		//long start = System.currentTimeMillis();
		try {
			if(num == 0) {
				return 1;
			} else {
				return num*factorial(num-1);
			}
		} finally {
			//long end = System.currentTimeMillis();
			//System.out.println("재귀 : " + (end-start));
		}
		
		
	}

}
