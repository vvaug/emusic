package br.com.vvaug.usecase;

import br.com.vvaug.request.CreateUserRequest;
import br.com.vvaug.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface CreateUserUseCase {

    ResponseEntity<UserResponse> execute(CreateUserRequest createUserRequest);
}
