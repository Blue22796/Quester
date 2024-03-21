package com.example.demo.Controllers;

import java.sql.SQLException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Solution;
import com.example.demo.Playground.ThingDoer;
import com.example.demo.Services.PlayGroungService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PlayGroundController {
	
	private final ThingDoer td;
	private final PlayGroungService service;

	
	@GetMapping("/api/v1/play")
	public String play() throws SQLException{
		return td.doThing();
	}
	
	@GetMapping("/api/v1/play/{n}/{str}")
	public String slv(@PathVariable("n")String num,@PathVariable("str") String s) {
		return service.serve(Integer.parseInt(num), s).getText();
	}
}
