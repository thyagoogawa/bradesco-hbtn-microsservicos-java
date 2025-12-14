package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

// Annotation @Component necessário para disponibilizar a classe no teste
@Component
public class Calculator {

    public Double sum(Double number1, Double number2) {
    	
    		if (isInvalidNumbers(number1, number2)) {
    			throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    		}
    		
    		return Double.sum(number1, number2);
    }

	public Double sub(Double number1, Double number2) {
		
		if (isInvalidNumbers(number1, number2)) {
			throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
		}
		
    		return number1 - number2;
	}

    public Double divide (Double number1, Double number2)  {
       
    		if (isInvalidNumbers(number1, number2)) {
			throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
		}
    		
    		if (isDividerZero(number2)) {
    			throw new ArithmeticException("Divisão por zero não é permitido.");
    		}
    		
    		return number1 / number2;
    }

	public Integer factorial(Integer number) {
		
		if (isInvalidNumber(number)) {
			throw new NullPointerException("Número é obrigatório.");
		}
		
    		return calculateFatorial(number);
    }

    public String integerToBinary(Integer integer) {
    		return Integer.toBinaryString(integer);
    }   

    public String integerToHexadecimal(Integer integer) {
    		return Integer.toHexString(integer);
    }

    public long calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
    		return date1.until(date2, ChronoUnit.DAYS);
    }
    
    private boolean isInvalidNumbers(Double number1, Double number2) {
		if (number1 == null) {
			return true;
		}
		if (number2 == null) {
			return true;
		}
		
		return false;
	}
    
    private boolean isInvalidNumber(Integer factorial) {
    		if (factorial == null) {
			return true;
		}
	    	return false;
    }
    
    private boolean isDividerZero(Double number2) {
    		if (number2 == null || number2.equals(0.0d)) {
			return true;
		}
    		
		return false;
	}

    private int calculateFatorial(int number) {
	    	if (number == 0 || number == 1) {
	    		return 1;
	    	}
	    	return number * calculateFatorial(number - 1);
    	}
    
}