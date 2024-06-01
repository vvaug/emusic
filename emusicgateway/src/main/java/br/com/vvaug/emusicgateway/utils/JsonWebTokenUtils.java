package br.com.vvaug.emusicgateway.utils;

import br.com.vvaug.emusicgateway.exception.ApplicationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Objects;

@Component
@Slf4j
public class JsonWebTokenUtils {

    @Value("${jwt.secret}")
    private String secret;
    private Key key;

    @PostConstruct
    public void init(){
        byte[] keyBytes = this.secret.getBytes(StandardCharsets.UTF_8);
        key =  Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean isBearerTokenValid(String bearerToken){
        Claims claims = verifyAndGetClaimsJwt(bearerToken);
        return Objects.nonNull(claims);
    }

    public Claims verifyAndGetClaimsJwt(String jwt) {
        try {
            Claims claims = Jwts.parser().setSigningKey(this.key).build().parseClaimsJws(jwt).getPayload();
            return claims;
        } catch (Exception e) {
            throw new ApplicationException(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }
}
