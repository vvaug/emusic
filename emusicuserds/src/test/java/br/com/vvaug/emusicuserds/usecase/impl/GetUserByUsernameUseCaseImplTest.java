package br.com.vvaug.emusicuserds.usecase.impl;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.gateway.GetUserByUsernameGateway;
import br.com.vvaug.emusicuserds.mock.MockBuilder;
import br.com.vvaug.emusicuserds.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GetUserByUsernameUseCaseImplTest {

    @InjectMocks
    private GetUserByUsernameUseCaseImpl getUserByUsernameUseCase;
    @Mock
    private GetUserByUsernameGateway getUserByUsernameGateway;
    private static final String USERNAME = "root";

    @Test
    void execute() {
        User expected = MockBuilder.buildUser();
        when(getUserByUsernameGateway.getUser(any())).thenReturn(expected);
        UserResponse response = getUserByUsernameUseCase.execute(USERNAME);
        assertTrue(Objects.nonNull(response));
        assertEquals(expected.getUsername(), response.getUsername());
        assertEquals(expected.getPassword(), response.getPassword());
        verify(getUserByUsernameGateway, atLeastOnce()).getUser(any());
    }
}