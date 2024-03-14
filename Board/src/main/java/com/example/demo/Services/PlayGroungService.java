package com.example.demo.Services;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Solution;

@Service
public class PlayGroungService {
	
	public Solution serve(int n, String s) {
		long ans = 0;
		long dlt = 0;
		int[][] arr = new int[2][4];
		for(int i = 0; i<n;i++) {
			if(s.charAt(i)=='1')
				arr[1][1] = arr[0][3] + arr[0][0]+1;
			else 
				arr[1][0] = arr[0][0] + arr[0][3] + 1;
			dlt+=arr[1][1];
			arr[1][3] = arr[0][2];
			arr[1][2] = arr[0][1];
			for(int j = 0; j<4;j++) {
				arr[0][j] = arr[1][j];
				arr[1][j] = 0;
				}
			ans+=dlt;
			}
		return new Solution(String.valueOf(ans)); 
	}
}
