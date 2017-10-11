package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text) {
		int sum = 0;
		if(text == "")
			return sum;
		else {
			String deliminator = ",";
			if(text.length() >= 3) {
				String fyrstTwo = text.substring(0,2);
				if(fyrstTwo.equals("//")) {
					deliminator = text.substring(2,3);
					text = text.substring(4,text.length());
				}
			}
			
			if(text.contains(deliminator) || text.contains("\n")) {
				String numbers[] = text.split(deliminator+"|\n");
				
				
				negativeNumbersCheck(numbers);
				
				sum = sum(numbers);	
			}
			else {
				sum = Integer.parseInt(text);
			}
		}
		return sum;
	}
	
	private static int toInt(String number) {
		return Integer.parseInt(number);	
	}
	
	private static int sum(String [] numbers) {
		int total = 0;
		for(String number : numbers) {
			if(toInt(number) < 1000) {
				total += toInt(number);
			}
		}
		return total;
	}
	
	private static void negativeNumbersCheck(String [] numbers) {
		String negativeNumbers = "";
		for(String number : numbers) {
					
			if(toInt(number) < 0){
				negativeNumbers = negativeNumbers + number + ","; 
			}
		}
		if(negativeNumbers.length() > 0) {
			if(negativeNumbers.length() > 1)
			{
				 negativeNumbers = negativeNumbers.substring(0, negativeNumbers.length() - 1);
			}
			throw new RuntimeException("Negative not allowed: " + negativeNumbers);
		}	
	}
}