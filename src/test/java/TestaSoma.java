package test.java;

import junit.framework.TestCase;
import main.java.Calc;

import org.junit.Test;

public class TestaSoma extends TestCase  {

	@Test
	public void testaSoma()  {

		Calc cal = new Calc();
		
		double resultado = cal.soma(10.1, 10.1);
		
		assertEquals(20.2,resultado);
		
	}

}
