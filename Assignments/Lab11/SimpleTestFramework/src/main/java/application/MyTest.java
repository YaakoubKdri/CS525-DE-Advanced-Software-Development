package application;

import framework.Before;
import framework.Test;
import framework.TestClass;

import static framework.Asserts.assertEquals;

@TestClass
public class MyTest {
    // part a
    /*
    @Before
    public void init(){
        System.out.println("perform initialization");
    }

	@Test
	public void testMethod1() {
		System.out.println("perform test method 1");
	}

	@Test
	public void testMethod2() {
		System.out.println("perform test method 2");
	}
    */
    Calculator calculator;

    @Before
    public void init(){
        calculator = new CalculatorImpl();
    }

    @Test
    public void testMethod1() {
        assertEquals(calculator.add(3), 3);
        assertEquals(calculator.add(6), 9);
    }

    @Test
    public void testMethod2() {
        assertEquals(calculator.add(3), 3);
        assertEquals(calculator.subtract(6), -1);
    }
}
