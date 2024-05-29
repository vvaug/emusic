package br.com.vvaug.auth.usecase.impl;

import br.com.vvaug.auth.request.AuthRequest;
import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.usecase.AuthenticationUseCase;
import br.com.vvaug.auth.usecase.GenerateTokenUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {
    private final AuthenticationManager authenticationManager;
    private final GenerateTokenUseCase generateTokenUseCase;
    @Override
    public AuthResponse execute(AuthRequest authRequest) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        authentication = authenticationManager.authenticate(authentication);
        return generateTokenUseCase.execute(authentication);
    }
}
