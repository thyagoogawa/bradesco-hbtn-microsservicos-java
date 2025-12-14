package com.example.calculator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import com.example.calculator.model.Calculator;

@WebMvcTest(CalculatorController.class)
// Annotation @Import necessário para disponibilizar o bean no teste
@Import(Calculator.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Test
    void messageWelcomeTest() throws Exception {
    		RequestBuilder request = get("/calculator/welcome");
    		MvcResult result = mvc.perform(request).andReturn();
    		assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbersTest() throws Exception {
    		RequestBuilder request = get("/calculator/addNumbers?number1=32&number2=64");
    		MvcResult result = mvc.perform(request).andReturn();
    		assertEquals("96.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbersTest() throws Exception {
    		RequestBuilder request = get("/calculator/subNumbers?number1=96&number2=64");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("32.0", result.getResponse().getContentAsString());
    }
    
    @Test
    void divideNumbersTest() throws Exception {
    		RequestBuilder request = get("/calculator/divideNumbers?number1=76&number2=32");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("2.375", result.getResponse().getContentAsString());
    }
    
    @Test
    void factorialTest() throws Exception {
    		RequestBuilder request = get("/calculator/factorial?number=9");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("362880", result.getResponse().getContentAsString());
    }
    
    @Test
    void calculeDayBetweenDateTest() throws Exception {
    		RequestBuilder request = get("/calculator/calculeDayBetweenDate?localDate1=2020-03-15&localDate2=2021-04-29");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("410", result.getResponse().getContentAsString());
    }
    
    @Test
    void integerToBinaryTest() throws Exception {
    		RequestBuilder request = get("/calculator/integerToBinary?number=46");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("101110", result.getResponse().getContentAsString());
    }
    
    @Test
    void integerToHexadecimalTest() throws Exception {
    		RequestBuilder request = get("/calculator/integerToHexadecimal?number=380");
		MvcResult result = mvc.perform(request).andReturn();
		assertEquals("17c", result.getResponse().getContentAsString());
    }
    
}
