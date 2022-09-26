package com.wixis.bigidy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import java.util.ArrayList;
import java.util.Random;

class BigidyApplicationTests {

	public static void main(String[] args) {

		String refresh_token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqb2huQGdtYWlsLmNvbSIsImlzcyI6Ii9hcGkvdjEvbG9naW4iLCJleHAiOjE2NjM1NzM2NzN9.-ASbKSVaiZyTS2HOySP7m6nUEs8If5EKWlXRtQkB4AY";
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedJWT = verifier.verify(refresh_token);
		System.out.println(decodedJWT.getSubject());
	}
}
