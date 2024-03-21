package com.example.demo.Models;

public class Solution {
	private String solution;
	
	public String getText() {
		return solution;
	}
	
	public Solution(String solution) {
		this.solution = solution;
	}
	
	public boolean equals(Object other) {
		
		if(other.getClass() != this.getClass())
			return false;
		Solution otherSolution = (Solution)other;
		System.out.println(this.solution + " " + otherSolution.solution);
		return this.solution.equals(otherSolution.solution);
	}
	
}
