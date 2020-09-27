package com.prueba.springboot.rest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.springboot.rest.utility.ValidatorRUT;

@SpringBootTest
class PtEjerciciosJavaSpringApplicationTests {
	
	@Test
	public void validatorRutTest() {
		ValidatorRUT validator = new ValidatorRUT();
		boolean resultValidator = validator.validarRut("26.938.034-9");
		System.out.println("..::resultValidator" + resultValidator);
	}

}
