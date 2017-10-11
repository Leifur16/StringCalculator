package is.ru.stringcalculator;

public class Calculator {
	
	public static int add(String text) {
		if(text == "")
			return 0;
		else {
			if(text.contains(",") || text.contains("\n")) {
				String numbers[] = text.split(",|\n");
				for(String number : numbers) {
					if(number < 0){
						throw new IllegalArgumentException("Negative not allowed: " + number);
					}
				}
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
			total += toInt(number);
		}
		return total;
	}
}