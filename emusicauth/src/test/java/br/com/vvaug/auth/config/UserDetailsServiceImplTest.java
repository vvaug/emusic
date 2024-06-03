package br.com.vvaug.auth.config;

import br.com.vvaug.auth.gateway.GetUserGateway;
import br.com.vvaug.auth.mock.MockBuilder;
import br.com.vvaug.auth.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private GetUserGateway getUserGateway;

    @Test
    void loadUserByUsername() {
        UserResponse expected = MockBuilder.buildUserResponse();
        when(getUserGateway.getUser("root")).thenReturn(expected);
        UserResponse userResponse = (UserResponse) userDetailsService.loadUserByUsername("root");
        assertNotNull(userResponse);
        assertEquals(expected.getUsername(), userResponse.getUsername());
        assertEquals(expected.getPassword(), userResponse.getPassword());
        verify(getUserGateway, atLeastOnce()).getUser(any());
    }
}