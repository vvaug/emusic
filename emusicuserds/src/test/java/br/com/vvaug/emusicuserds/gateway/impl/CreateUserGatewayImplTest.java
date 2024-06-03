package br.com.vvaug.emusicuserds.gateway.impl;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.mock.MockBuilder;
import br.com.vvaug.emusicuserds.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateUserGatewayImplTest {

    @InjectMocks
    private CreateUserGatewayImpl createUserGateway;
    @Mock
    private UserRepository userRepository;

    @Test
    void createUser() {
        User expected = MockBuilder.buildUser();
        when(userRepository.save(any())).thenReturn(expected);
        User response = createUserGateway.createUser(expected);
        assertNotNull(response);
        assertEquals(expected.getUsername(), response.getUsername());
        assertEquals(expected.getPassword(), response.getPassword());
        verify(userRepository, atLeastOnce()).save(any());
    }
}