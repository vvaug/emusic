package br.com.vvaug.emusicregister.usecase;

import br.com.vvaug.emusicregister.request.CreateUserRequest;
import br.com.vvaug.emusicregister.response.UserResponse;

public interface RegisterNewUserUseCase {

    UserResponse execute(CreateUserRequest createUserRequest);
}
