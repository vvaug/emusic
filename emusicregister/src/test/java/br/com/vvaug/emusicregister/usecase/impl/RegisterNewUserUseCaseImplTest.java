package br.com.vvaug.emusicregister.usecase.impl;

import br.com.vvaug.emusicregister.gateway.RegisterNewUserGateway;
import br.com.vvaug.emusicregister.mock.MockBuilder;
import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterNewUserUseCaseImplTest {

    @InjectMocks
    private RegisterNewUserUseCaseImpl registerNewUserUseCase;
    @Mock
    private RegisterNewUserGateway registerNewUserGateway;

    @Test
    void execute(){
        CreateUserRequest request = MockBuilder.buildCreateUserRequest();
        UserResponse expected = MockBuilder.buildUserResponse();
        when(registerNewUserGateway.register(any())).thenReturn(expected);
        UserResponse response = registerNewUserUseCase.execute(request);
        assertNotNull(response);
        assertEquals(expected.getUsername(), response.getUsername());
        assertEquals(expected.getPassword(), response.getPassword());
        verify(registerNewUserGateway, atLeastOnce()).register(any());
    }
}