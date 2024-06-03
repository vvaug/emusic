package br.com.vvaug.auth.usecase.impl;

import br.com.vvaug.auth.mock.MockBuilder;
import br.com.vvaug.auth.response.AuthResponse;
import br.com.vvaug.auth.response.UserResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GenerateTokenUseCaseImplTest {

    private final GenerateTokenUseCaseImpl generateTokenUseCase = new GenerateTokenUseCaseImpl();

    @BeforeEach
    void before(){
        ReflectionTestUtils.setField(generateTokenUseCase, "secret", "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQ" +
                "C1h0FL7aiYlRaTP8faKDlF8S7kxqmY3dcjzrvvMJTUeV+ltgq/2vPLD0klrk/r9xuvlNTmFy4RG3zMR+zQ+0zP97An0Ycg0npOtdYWb" +
                "40xVNwrYrVMiWRGxkJdX0c6DtGiblpJfi2+8xX8Y65Rg1MAdf/n2fUlIxWYbcNIi5OTNlQIDAQAB");
        generateTokenUseCase.init();
    }

    @Test
    void execute() {
        UserResponse userResponse = MockBuilder.buildUserResponse();
        Authentication authentication = new UsernamePasswordAuthenticationToken(userResponse, "root");
        AuthResponse response = generateTokenUseCase.execute(authentication);
        assertNotNull(response);
    }
}