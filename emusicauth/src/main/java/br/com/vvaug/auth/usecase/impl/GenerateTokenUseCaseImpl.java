package br.com.vvaug.auth.usecase.impl;

import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.response.UserResponse;
import br.com.vvaug.auth.usecase.GenerateTokenUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class GenerateTokenUseCaseImpl implements GenerateTokenUseCase {
    @Override
    public AuthResponse execute(Authentication authentication) {
        UserResponse user = (UserResponse) authentication.getPrincipal();
        JsonWebSignature jws;
        String jwt;
        try {
            jws = getJsonWebSignature(user);
            jwt = jws.getCompactSerialization();
        } catch (JoseException ex){
            log.error("Error occurred while serializing JWT: {}", ex.getMessage());
            //TODO create exceptions and handler
            throw new RuntimeException();
        }
        return AuthResponse.builder().accessToken(jwt).build();
    }

    private static JsonWebSignature getJsonWebSignature(UserResponse user) throws JoseException {
        JwtClaims claims = new JwtClaims();
        claims.setIssuer(user.getUsername());
        claims.setExpirationTimeMinutesInTheFuture(10);
        claims.setIssuedAtToNow();
        claims.setSubject(user.getFirstName() + " " + user.getLastName());
        claims.setClaim("premium", user.isPremium());
        claims.setClaim("active", user.isActive());
        claims.setClaim("documentNumber", user.getDocumentNumber());
        JsonWebSignature jws = new JsonWebSignature();
        RsaJsonWebKey rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        jws.setKey(rsaJsonWebKey.getPrivateKey());
        jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
        return jws;
    }
}
