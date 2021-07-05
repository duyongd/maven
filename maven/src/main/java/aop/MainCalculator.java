package aop;

import chap05.Calculator;
import chap05.ExeCalculator;
import chap05.ImplCalculator;

public class MainCalculator {

	public static void main(String[] args) {
		Calculator cal = new ExeCalculator(new ImplCalculator());
		
		long r = cal.factorial(10);
		
		System.out.println(r);
		

	}

}
