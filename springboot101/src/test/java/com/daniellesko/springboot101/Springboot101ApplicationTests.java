package com.daniellesko.springboot101;

import com.daniellesko.springboot101.repositories.ProductRepository;
import com.daniellesko.springboot101.services.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class Springboot101ApplicationTests {

	@MockBean
	private ProductRepository repository;
	@Autowired
	private ProductService service;

	@BeforeAll
	public static void beforeAll(){
		System.out.println("BeforeAll");
	}
	@BeforeEach
	public void beforeEach(){
		System.out.println("BeforeEach");
	}


	@Test
	void noProductsReturned() {
		// Ak su ocakava zhodne s predpokladmi, tak je vsetko vporiadku
		// Predpoklad (mockovanie pripojenia k DB)
		given(repository.getProductNames()).willReturn(Collections.emptyList());
		// volanie metody
		List<String> res = service.getProductNamesWithEvenNoOfChar();
		// Ocakavanie
		assertTrue(res.isEmpty());
	}
	@Test
	public void moreProductsAreFound() {
		// Vstupne data
		List<String> input = Arrays.asList("aa", "bbbb", "ccc");
		// Predpoklad
		given(repository.getProductNames()).willReturn(input);
		// Volanie metody
		List<String> res = service.getProductNamesWithEvenNoOfChar();
		// Ocakavanie
		assertEquals(2, res.size());

		// Chcem si byt isty, ze metoda addProduct bola volana 2x (s akoukolvek hodnotou
		//verify(repository, times(2)).addProduct(any());
	}

}
