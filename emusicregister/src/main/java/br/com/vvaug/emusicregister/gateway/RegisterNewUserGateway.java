package br.com.vvaug.emusicregister.gateway;

import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;

public interface RegisterNewUserGateway {

    UserResponse register(CreateUserRequest createUserRequest);
}
