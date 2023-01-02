package com.example.javajwtdemo.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.javajwtdemo.exception.GenericException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class TokenService {
    @Value("${jwt-variables.KEY}")
    private String KEY;

    @Value("${jwt-variables.ISSUER}")
    private String ISSUER;

    @Value("${jwt-variables.EXPIRES_ACCESS_TOKEN_MINUTE}")
    private Integer EXPIRES_ACCESS_TOKEN_MINUTE;

    public String generateToken(Authentication authentication){
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        return JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() * EXPIRES_ACCESS_TOKEN_MINUTE * 60 * 1000))
                .withIssuer(ISSUER)
                //.withClaim("email", "email@gmail.com")
                .sign(Algorithm.HMAC256(KEY.getBytes()));
    }

    // var decodedToken = verifier.verify(token);
    // var email = decodedToken.getClaims.get("email");
    public DecodedJWT verifyJWT(String token) {
        Algorithm algorithm = Algorithm.HMAC256(KEY.getBytes());
        JWTVerifier verifier = JWT.require(algorithm)
                .acceptExpiresAt(20) //The token is valid for a certain second after the EXPIRES_ACCESS_TOKEN_MINUTE expires
                .build();
        try {
            return verifier.verify(token);
        } catch (Exception e) {
            throw GenericException.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .errorMessage(e.getMessage())
                    .build();
        }
    }
}
