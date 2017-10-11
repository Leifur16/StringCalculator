rm -r classes/*
javac src/main/java/is/ru/stringcalculator/*.java -d classes
javac -classpath "src/test/resources/junit-4.11.jar;classes/" src/test/java/is/ru/stringcalculator/CalculatorTest.java -d classes
java -cp "classes/;src/test/resources/junit-4.11.jar;src/test/resources/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore is.ru.stringcalculator.CalculatorTest

