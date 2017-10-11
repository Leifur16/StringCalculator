package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	
	@Test
	public void testEmpyString() {
		assertEquals(0, Calculator.add(""));
	}
	
	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}
	
	@Test
	public void testTwoNumber() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testMultipleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n,3"));
	}
}

// clean: $ rm -r classes/*
// compile: $ javac src/main/java/is/ru/stringcalculator/*.java -d classes
// compile test: javac -classpath "src/test/resources/junit-4.11.jar;classes/" src/test/java/is/ru/stringcalculator/CalculatorTest.java -d classes
// run: $ java -cp "classes/;src/test/resources/junit-4.11.jar;src/test/resources/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore is.ru.stringcalculator.CalculatorTest
 