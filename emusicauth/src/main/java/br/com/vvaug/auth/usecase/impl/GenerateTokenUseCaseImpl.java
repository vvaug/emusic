package br.com.vvaug.auth.usecase.impl;

import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.response.UserResponse;
import br.com.vvaug.auth.usecase.GenerateTokenUseCase;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateTokenUseCaseImpl implements GenerateTokenUseCase {

    @Value("${jwt.secret}")
    private String secret;
    private Key key;

    private static final Long TTL_VALID_JWT_DAY_IN_MILLISECONDS = 86400000L;


    @PostConstruct
    public void init(){
        byte[] keyBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        key =  Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public AuthResponse execute(Authentication authentication) {
        UserResponse user = (UserResponse) authentication.getPrincipal();
        String jwt = generateJwt(user);
        return AuthResponse.builder().accessToken(jwt).build();
    }


    public String generateJwt(UserResponse user) {
        Long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Long expMillis = nowMillis + TTL_VALID_JWT_DAY_IN_MILLISECONDS;
        Date expirationDate = new Date(expMillis);

        return Jwts
                .builder()
                .id(UUID.randomUUID().toString())
                .issuer("emusicauth")
                .issuedAt(now)
                .notBefore(now)
                .expiration(expirationDate)
                .signWith(this.key)
                .compact();
    }

}
