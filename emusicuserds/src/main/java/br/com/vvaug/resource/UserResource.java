package br.com.vvaug.resource;

import br.com.vvaug.request.CreateUserRequest;
import br.com.vvaug.request.GetUserDataRequest;
import br.com.vvaug.response.UserResponse;
import br.com.vvaug.usecase.CreateUserUseCase;
import br.com.vvaug.usecase.GetUserDataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final GetUserDataUseCase getUserDataUseCase;
    private final CreateUserUseCase createUserUseCase;

    @PostMapping
    public ResponseEntity<UserResponse> getUserData(@RequestBody GetUserDataRequest getUserDataRequest){
        return getUserDataUseCase.execute(getUserDataRequest);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){
        return createUserUseCase.execute(createUserRequest);
    }
}
