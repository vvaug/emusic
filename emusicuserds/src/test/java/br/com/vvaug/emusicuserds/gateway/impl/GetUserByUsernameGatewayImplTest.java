package br.com.vvaug.emusicuserds.gateway.impl;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.mock.MockBuilder;
import br.com.vvaug.emusicuserds.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetUserByUsernameGatewayImplTest {

    @InjectMocks
    private GetUserByUsernameGatewayImpl getUserByUsernameGateway;
    @Mock
    private UserRepository userRepository;
    private static final String USERNAME = "root";

    @Test
    void getUser() {
        User expected = MockBuilder.buildUser();
        when(userRepository.findUserByUsername(any())).thenReturn(Optional.of(expected));
        User response = getUserByUsernameGateway.getUser(USERNAME);
        assertNotNull(response);
        assertEquals(expected.getUsername(), response.getUsername());
        assertEquals(expected.getPassword(), response.getPassword());
        verify(userRepository, atLeastOnce()).findUserByUsername(any());
    }
}