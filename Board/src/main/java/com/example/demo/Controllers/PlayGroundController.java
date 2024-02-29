package com.example.demo.Controllers;

import java.sql.SQLException;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Playground.ThingDoer;

@RestController
public class PlayGroundController {
	
	private final ThingDoer td;
	
	PlayGroundController(ThingDoer td){
		this.td = td;
	}
	
	@GetMapping("/api/v1/play")
	public String play() throws SQLException{
		return td.doThing();
	}
}
