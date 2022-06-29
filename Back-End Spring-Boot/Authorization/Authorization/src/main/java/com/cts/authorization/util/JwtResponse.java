package com.cts.authorization.util;

import lombok.Data;

@Data
public class JwtResponse {
	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}