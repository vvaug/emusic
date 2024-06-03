package br.com.vvaug.auth.gateway.impl;

import br.com.vvaug.auth.client.EmusicUserDsClient;
import br.com.vvaug.auth.mock.MockBuilder;
import br.com.vvaug.auth.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetUserGatewayImplTest {

    @InjectMocks
    private GetUserGatewayImpl getUserGateway;
    @Mock
    private EmusicUserDsClient emusicUserDsClient;

    @Test
    void getUser() {
        UserResponse expected = MockBuilder.buildUserResponse();
        when(emusicUserDsClient.getUser(any())).thenReturn(expected);
        UserResponse response = (UserResponse) getUserGateway.getUser("root");
        assertNotNull(response);
        assertEquals(expected.getUsername(), response.getUsername());
        assertEquals(expected.getPassword(), response.getPassword());
        verify(emusicUserDsClient, atLeastOnce()).getUser(any());
    }
}