package br.com.vvaug.emusicregister.gateway.impl;

import br.com.vvaug.emusicregister.client.EmusicUserDsClient;
import br.com.vvaug.emusicregister.mock.MockBuilder;
import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegisterNewUserGatewayImplTest {

    @InjectMocks
    private RegisterNewUserGatewayImpl registerNewUserGateway;
    @Mock
    private EmusicUserDsClient emusicUserDsClient;

    @Test
    void register(){
        UserResponse expected = MockBuilder.buildUserResponse();
        when(emusicUserDsClient.createNewUser(any())).thenReturn(expected);
        UserResponse response = registerNewUserGateway.register(CreateUserRequest.builder().build());
        assertNotNull(response);
        assertEquals(expected.getUsername(), response.getUsername());
        assertEquals(expected.getPassword(), response.getPassword());
        verify(emusicUserDsClient, atLeastOnce()).createNewUser(any());

    }


}