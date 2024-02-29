package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class XPSPasswordEncoder implements PasswordEncoder{

	private final long x;
	private final long mod;
	private static XPSPasswordEncoder instance;
	
	
	public static XPSPasswordEncoder getInstance() {
		if(instance == null)
			instance = new XPSPasswordEncoder(49424261l,96794321929l);
		return instance;
	}
	
	public String h2s(long hash) {
		StringBuilder sb = new StringBuilder();
		while(hash>0) {
			sb.append((char)(hash%26+'a'));
			hash/=26;
		}
		return sb.toString();
	}
	
	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		int n = rawPassword.length();
		long[] block = new long[n/7];
		long xp = x;
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i<n;i+=5) {
			long val = 0;
			for(int j = i; j<Math.max(i+5, n);j++) {
				val = (val + xp*(rawPassword.charAt(j)-'a'))%mod;
				xp = xp*x%mod;
			}
			block[i] = val;
			val = 0;
		}
		
		for(long hash:block) {
			sb.append(h2s(hash));
		}
		return sb.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		System.out.println(encodedPassword);
		return encode(rawPassword).equals(encodedPassword);
	}
	
}
