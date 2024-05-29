package br.com.vvaug.resource;

import br.com.vvaug.request.CreateUserRequest;
import br.com.vvaug.request.GetUserDataRequest;
import br.com.vvaug.response.UserResponse;
import br.com.vvaug.usecase.CreateUserUseCase;
import br.com.vvaug.usecase.GetUserByUsernameUseCase;
import br.com.vvaug.usecase.GetUserDataUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {

    private final GetUserDataUseCase getUserDataUseCase;
    private final GetUserByUsernameUseCase getUserByUsernameUseCase;
    private final CreateUserUseCase createUserUseCase;

    @GetMapping("/{username}")
    public UserResponse getUserByUsername(@PathVariable("username") String username){
        return getUserByUsernameUseCase.execute(username);
    }

    @Deprecated
    @PostMapping
    public ResponseEntity<UserResponse> getUserData(@RequestBody GetUserDataRequest getUserDataRequest){
        return getUserDataUseCase.execute(getUserDataRequest);
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest createUserRequest){
        return createUserUseCase.execute(createUserRequest);
    }
}
