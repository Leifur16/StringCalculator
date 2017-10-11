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
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}
	
	@Test
	public void testMultipleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}
	
	@Test
	public void testNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}
	
		
	@Test
	public void testOneNegativeNumber() {
		RuntimeException exception = null;
		try {
			Calculator.add("-1,2");
		} catch (RuntimeException e) {
			exception = e;
		}
		assertEquals("Negative not allowed: -1", exception.getMessage());
	}
	
	@Test
	public void testMultipleNegativeNumbers() {
		RuntimeException exception = null;
		try {
			Calculator.add("-1,-2,-3,4");
		} catch (RuntimeException e) {
			exception = e;
		}
		assertEquals("Negative not allowed: -1,-2,-3", exception.getMessage());
	}
	
	@Test
	public void testNumbersGreaterThanThousand() {
		assertEquals(2, Calculator.add("1001,2"));
	}
	
	@Test
	public void testChangeDeliminator () {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}
}
 