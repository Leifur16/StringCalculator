package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text) {
		if(text == "")
			return 0;
		else {
			if(text.contains(",") || text.contains("\n")) {
				String numbers[] = text.split(",|\n");
				
				negativeNumbersCheck(numbers);
				
				return sum(numbers);	
			}	
		}
		return 1;
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