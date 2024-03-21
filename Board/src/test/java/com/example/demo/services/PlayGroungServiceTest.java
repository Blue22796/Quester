package com.example.demo.services;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Models.Solution;
import com.example.demo.Services.PlayGroungService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlayGroungServiceTest {

	@Autowired
	public PlayGroungService service;
	
	@Test
	public void sampleTest1() {
		Solution result = service.serve(1, "1");
		assertEquals(result, new Solution("1"));
	}
	
	@Test
	public void sampleTest2() {
		Solution result = service.serve(20, "11110110000000111111");
		assertEquals(result, new Solution("346"));
	}
}
