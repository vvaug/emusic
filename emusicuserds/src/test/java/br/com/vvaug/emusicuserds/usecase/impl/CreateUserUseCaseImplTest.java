package br.com.vvaug.emusicuserds.usecase.impl;

import br.com.vvaug.emusicuserds.entity.User;
import br.com.vvaug.emusicuserds.gateway.impl.CreateUserGatewayImpl;
import br.com.vvaug.emusicuserds.mock.MockBuilder;
import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import br.com.vvaug.emusicuserds.response.UserResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateUserUseCaseImplTest {

    @InjectMocks
    private CreateUserUseCaseImpl createUserUseCase;
    @Mock
    private CreateUserGatewayImpl createUserGateway;

    @Test
    void execute() {
        User expected = MockBuilder.buildUser();
        CreateUserRequest request = MockBuilder.buildCreateUserRequest();
        when(createUserGateway.createUser(any())).thenReturn(expected);
        ResponseEntity<UserResponse> response = createUserUseCase.execute(request);
        UserResponse responseBody = Objects.requireNonNull(response.getBody());
        assertEquals(expected.getUsername(), responseBody.getUsername());
        assertEquals(expected.getPassword(), responseBody.getPassword());
        verify(createUserGateway, atLeastOnce()).createUser(any());
    }
}