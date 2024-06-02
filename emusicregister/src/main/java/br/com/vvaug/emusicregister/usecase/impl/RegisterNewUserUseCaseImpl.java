package br.com.vvaug.emusicregister.usecase.impl;

import br.com.vvaug.emusicregister.gateway.RegisterNewUserGateway;
import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import br.com.vvaug.emusicregister.usecase.RegisterNewUserUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegisterNewUserUseCaseImpl implements RegisterNewUserUseCase {
    private final RegisterNewUserGateway registerNewUserGateway;
    @Override
    public UserResponse execute(CreateUserRequest createUserRequest) {
        return registerNewUserGateway.register(createUserRequest);
    }
}
