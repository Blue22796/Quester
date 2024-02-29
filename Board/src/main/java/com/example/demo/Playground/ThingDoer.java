package com.example.demo.Playground;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;

@Component
public class ThingDoer{
	
	public String doThing() throws SQLException {
		String s = "Thing done successfully";
		System.out.println(s);
		return s;
	}
	
}
