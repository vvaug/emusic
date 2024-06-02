package br.com.vvaug.emusicregister.gateway.impl;

import br.com.vvaug.emusicregister.client.EmusicUserDsClient;
import br.com.vvaug.emusicregister.gateway.RegisterNewUserGateway;
import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RegisterNewUserGatewayImpl implements RegisterNewUserGateway {
    private final EmusicUserDsClient emusicUserDsClient;
    @Override
    public UserResponse register(CreateUserRequest createUserRequest) {
        log.info("Calling emusicuserds service to create new User: {}", createUserRequest.toString());
        return emusicUserDsClient.createNewUser(createUserRequest);
    }
}
