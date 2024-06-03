package br.com.vvaug.emusicuserds.usecase;

import br.com.vvaug.emusicuserds.request.CreateUserRequest;
import br.com.vvaug.emusicuserds.response.UserResponse;
import org.springframework.http.ResponseEntity;

public interface CreateUserUseCase {

    ResponseEntity<UserResponse> execute(CreateUserRequest createUserRequest);
}
