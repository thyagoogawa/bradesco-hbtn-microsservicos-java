package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
	
	Calculator calculator = new Calculator();

    @Test
    void sumTest() {
    		Double result = calculator.sum(33d, 45d);
    		assertEquals(78d, result);
    }

    @Test
    public void numbersNullSumTest() {
    		NullPointerException ex =  assertThrows(NullPointerException.class, () -> calculator.sum(null, 45d));
    		assertEquals("Número 1 e número 2 são obrigatórios.", ex.getMessage());
    }

    @Test
    void subTest() {
    		Double result = calculator.sub(32d, 24d);
    		assertEquals(8d, result);
    }

    @Test
    void divideTest() {
    		Double result = calculator.divide(8d, 4d);
    		assertEquals(2d, result);
    }

    @Test
    public void divisionByZeroTest() {
    		ArithmeticException ex = assertThrows(ArithmeticException.class, () -> calculator.divide(8d, 0d));
    		assertEquals("Divisão por zero não é permitido.", ex.getMessage());
    }

    @DisplayName("Teste do método factorial(Integer)")
    @ParameterizedTest(name = "[{index}] O número inteiro {0} deve ter o fatorial {1}")
    @CsvSource({
		"5, 120", 
		"6, 720", 
		"7, 5040", 
		"8, 40320", 
		"9, 362880"
    })
    void factorialTest(Integer number, Integer factorial) {
    		Integer factorialReturned = calculator.factorial(number);
    		assertEquals(factorial, factorialReturned);
    }

    @DisplayName("Teste do método integerToBinary(Integer)")
    @ParameterizedTest(name = "[{index}] O número binário do inteiro {0} deve ser {1}")
    @CsvSource({
		"1, 1", 
		"5, 101", 
		"20, 10100", 
		"46, 101110", 
		"329, 101001001"
    })
    void integerToBinaryTest(Integer number, String binary) {
    		String binaryConverted = calculator.integerToBinary(number);
    		assertEquals(binary, binaryConverted);
    }

    	@DisplayName("Teste do método integerToHexadecimal(Integer)")
    @ParameterizedTest(name = "[{index}] O número hexadecimal do inteiro {0} deve ser {1}")
    @CsvSource({
    		"1, 1", 
    		"5, 5", 
    		"170, aa", 
    		"380, 17c", 
    		"542, 21e"
	})
    void integerToHexadecimalTest(int number, String hex) {
    		String hexConverted = calculator.integerToHexadecimal(number);
    		assertEquals(hex, hexConverted);
    }

    @DisplayName("Teste do método calculeDayBetweenDate(LocalDate, LocalDate)")
    	@ParameterizedTest(name = "[{index}] O número de dias entre as datas {0} e {1} deve ser {2} dias")
    @CsvSource({
    		"2020-03-15, 2020-03-29, 14",
    		"2020-03-15, 2020-04-29, 45",
    		"2020-03-15, 2021-04-29, 410"
    })
    void calculeDayBetweenDateTest(ArgumentsAccessor arguments) {
    	
    		LocalDate date1 = arguments.get(0, LocalDate.class);
    		LocalDate date2 = arguments.get(1, LocalDate.class);
    		long numeroDias = arguments.getLong(2); 
    		
    		long daysReturned = calculator.calculeDayBetweenDate(date1, date2);
    		assertEquals(numeroDias, daysReturned);
    }
    
}