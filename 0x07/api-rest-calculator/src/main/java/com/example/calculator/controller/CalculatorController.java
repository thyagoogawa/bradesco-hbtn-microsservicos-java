package com.example.calculator.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.calculator.model.Calculator;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
	
	private final Calculator calculator;
	
	// Construtor do controller ecessário para funcionar a injeção de dependência do Calculator 
	// no teste unitário e de integração
	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
	}

    @GetMapping("/welcome")
    public String messageWelcome() {
    		return "Bem vindo à CALCULATOR API REST.";
    }

    @GetMapping("/addNumbers")
    public String addNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
    		return calculator.sum(n1, n2).toString();
    }

    @GetMapping("/subNumbers")
    public String subNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
    		return String.valueOf(calculator.sub(n1, n2));
    }

    @GetMapping("/divideNumbers")
    public String divideNumbers(@RequestParam(name = "number1") Double n1, @RequestParam(name = "number2") Double n2) {
    		return String.valueOf(calculator.divide(n1, n2));
    }

    @GetMapping("/factorial")
    public String factorial(@RequestParam(name = "number") Integer number) {
    		return String.valueOf(calculator.factorial(number));
    }

    @GetMapping("/calculeDayBetweenDate")
    public String calculeDayBetweenDate(
            @RequestParam("localDate1") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate1,
            @RequestParam("localDate2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate2) {
    		return String.valueOf(calculator.calculeDayBetweenDate(localDate1, localDate2));
    }

    @GetMapping("/integerToBinary")
    public String integerToBinary(@RequestParam(name = "number") Integer n1) {
		return calculator.integerToBinary(n1);
    }

    @GetMapping("/integerToHexadecimal")
    public String integerToHexadecimal(@RequestParam(name = "number") Integer n1) {
		return calculator.integerToHexadecimal(n1);
    }
}
