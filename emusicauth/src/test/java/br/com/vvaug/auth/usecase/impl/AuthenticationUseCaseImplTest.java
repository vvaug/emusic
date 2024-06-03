package br.com.vvaug.auth.usecase.impl;

import br.com.vvaug.auth.mock.MockBuilder;
import br.com.vvaug.auth.request.AuthRequest;
import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.usecase.GenerateTokenUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthenticationUseCaseImplTest {

    @InjectMocks
    private AuthenticationUseCaseImpl authenticationUseCase;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private GenerateTokenUseCase generateTokenUseCase;

    @Test
    void execute() {
        AuthResponse expected = MockBuilder.buildAuthResponse();
        AuthRequest request = AuthRequest.builder()
                .username("root")
                .password("root")
                .build();
        Authentication authentication = new UsernamePasswordAuthenticationToken("root", "root");
        when(authenticationManager.authenticate(any())).thenReturn(authentication);
        when(generateTokenUseCase.execute(any())).thenReturn(expected);
        AuthResponse response = authenticationUseCase.execute(request);
        assertNotNull(response);
        assertEquals(expected.getAccessToken(), response.getAccessToken());
        verify(authenticationManager, atLeastOnce()).authenticate(any());
        verify(generateTokenUseCase, atLeastOnce()).execute(any());
    }
}